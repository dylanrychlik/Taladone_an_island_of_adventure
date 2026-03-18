from typing import Optional

from models.save_status import SaveStatus


class SaveStatusService:
    def __init__(self) -> None:
        self._status: Optional[SaveStatus] = None

    def get_current_status(self) -> dict:
        if self._status is None:
            return {"has_save": False, "status": None}
        return {"has_save": True, "status": self._status.to_dict()}

    def create_or_save(self, payload: dict) -> tuple[dict, Optional[str]]:
        validation_error = self._validate_payload(payload, for_update=False)
        if validation_error:
            return {}, validation_error

        self._status = SaveStatus(
            player_name=payload["player_name"].strip(),
            health=int(payload["health"]),
            attack_damage=int(payload["attack_damage"]),
            armor=int(payload["armor"]),
            bank=int(payload["bank"]),
            jarl_level_count=int(payload["jarl_level_count"]),
            inventory_item_ids=list(payload.get("inventory_item_ids", [])),
            sidequests=list(payload.get("sidequests", [False] * 15)),
            region_progress=dict(payload.get("region_progress", {}))
            or {
                "northen_woods": [False] * 30,
                "eastern_graveyard": [False] * 30,
                "southern_ocean": [False] * 30,
                "western_mountain": [False] * 30,
            },
        )
        self._status.touch()
        return self._status.to_dict(), None

    def update(self, payload: dict) -> tuple[Optional[dict], Optional[str]]:
        if self._status is None:
            return None, "No saved status exists to update."

        validation_error = self._validate_payload(payload, for_update=True)
        if validation_error:
            return None, validation_error

        if "player_name" in payload:
            self._status.player_name = str(payload["player_name"]).strip()
        if "health" in payload:
            self._status.health = int(payload["health"])
        if "attack_damage" in payload:
            self._status.attack_damage = int(payload["attack_damage"])
        if "armor" in payload:
            self._status.armor = int(payload["armor"])
        if "bank" in payload:
            self._status.bank = int(payload["bank"])
        if "jarl_level_count" in payload:
            self._status.jarl_level_count = int(payload["jarl_level_count"])
        if "inventory_item_ids" in payload:
            self._status.inventory_item_ids = list(payload["inventory_item_ids"])
        if "sidequests" in payload:
            self._status.sidequests = list(payload["sidequests"])
        if "region_progress" in payload:
            self._status.region_progress = dict(payload["region_progress"])

        self._status.touch()
        return self._status.to_dict(), None

    def load(self) -> tuple[Optional[dict], Optional[str]]:
        if self._status is None:
            return None, "No saved status found."
        return self._status.to_dict(), None

    def reset(self) -> bool:
        had_save = self._status is not None
        self._status = None
        return had_save

    def _validate_payload(self, payload: dict, *, for_update: bool) -> Optional[str]:
        required_fields = [
            "player_name",
            "health",
            "attack_damage",
            "armor",
            "bank",
            "jarl_level_count",
        ]
        if not for_update:
            missing = [field for field in required_fields if field not in payload]
            if missing:
                return f"Missing fields: {', '.join(missing)}."

        if "player_name" in payload and not str(payload["player_name"]).strip():
            return "Field 'player_name' cannot be empty."

        int_fields = ["health", "attack_damage", "armor", "bank", "jarl_level_count"]
        for field in int_fields:
            if field in payload:
                try:
                    int(payload[field])
                except (TypeError, ValueError):
                    return f"Field '{field}' must be an integer."

        if "sidequests" in payload and not isinstance(payload["sidequests"], list):
            return "Field 'sidequests' must be an array of booleans."
        if "inventory_item_ids" in payload and not isinstance(
            payload["inventory_item_ids"], list
        ):
            return "Field 'inventory_item_ids' must be an array."

        if "region_progress" in payload and not isinstance(payload["region_progress"], dict):
            return "Field 'region_progress' must be an object."

        return None


save_status_service = SaveStatusService()
