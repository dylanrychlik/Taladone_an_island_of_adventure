from dataclasses import asdict, dataclass, field
from datetime import datetime, timezone


@dataclass
class SaveStatus:
    player_name: str
    health: int
    attack_damage: int
    armor: int
    bank: int
    jarl_level_count: int
    inventory_item_ids: list[str] = field(default_factory=list)
    sidequests: list[bool] = field(default_factory=lambda: [False] * 15)
    region_progress: dict[str, list[bool]] = field(
        default_factory=lambda: {
            "northen_woods": [False] * 30,
            "eastern_graveyard": [False] * 30,
            "southern_ocean": [False] * 30,
            "western_mountain": [False] * 30,
        }
    )
    updated_at: str = field(
        default_factory=lambda: datetime.now(timezone.utc).isoformat()
    )

    def touch(self) -> None:
        self.updated_at = datetime.now(timezone.utc).isoformat()

    def to_dict(self) -> dict:
        return asdict(self)
