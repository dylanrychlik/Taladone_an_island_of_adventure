from typing import Optional
from uuid import uuid4

from models.inventory_item import InventoryItem

VALID_ITEM_TYPES = {"good", "weapon", "armor"}


class InventoryService:
    def __init__(self) -> None:
        self._items: dict[str, InventoryItem] = {}
        self._seed_from_javafx_defaults()

    def _seed_from_javafx_defaults(self) -> None:
        seed_items = [
            InventoryItem(
                id="good-0",
                name="Ruby",
                description="Ruby",
                item_type="good",
                effect_value=0,
                cost=10,
            ),
            InventoryItem(
                id="good-1",
                name="Ring",
                description="Taladones ancient rings of the Northen woods.",
                item_type="good",
                effect_value=10,
                cost=30,
            ),
            InventoryItem(
                id="weapon-4",
                name="Sword",
                description="Starter sword",
                item_type="weapon",
                effect_value=140,
                cost=30,
            ),
            InventoryItem(
                id="weapon-5",
                name="Axe",
                description="Starter axe",
                item_type="weapon",
                effect_value=100,
                cost=30,
            ),
            InventoryItem(
                id="armor-0",
                name="Plate Armor",
                description="Starter plate armor",
                item_type="armor",
                effect_value=100,
                cost=30,
            ),
            InventoryItem(
                id="armor-1",
                name="Plate Armor II",
                description="Starter plate armor",
                item_type="armor",
                effect_value=100,
                cost=30,
            ),
        ]
        self._items = {item.id: item for item in seed_items}

    def list_items(self) -> list[dict]:
        return [item.to_dict() for item in self._items.values()]

    def get_item(self, item_id: str) -> Optional[dict]:
        item = self._items.get(item_id)
        return item.to_dict() if item else None

    def create_item(self, payload: dict) -> tuple[Optional[dict], Optional[str]]:
        validation_error = self._validate_payload(payload, allow_partial=False)
        if validation_error:
            return None, validation_error

        item_id = payload.get("id") or str(uuid4())
        if item_id in self._items:
            return None, f"Item with id '{item_id}' already exists."

        new_item = InventoryItem(
            id=item_id,
            name=payload["name"].strip(),
            description=payload["description"].strip(),
            item_type=payload["item_type"].strip().lower(),
            effect_value=int(payload["effect_value"]),
            cost=int(payload["cost"]),
        )
        self._items[item_id] = new_item
        return new_item.to_dict(), None

    def update_item(self, item_id: str, payload: dict) -> tuple[Optional[dict], Optional[str]]:
        item = self._items.get(item_id)
        if not item:
            return None, "Item not found."

        validation_error = self._validate_payload(payload, allow_partial=True)
        if validation_error:
            return None, validation_error

        if "name" in payload:
            item.name = payload["name"].strip()
        if "description" in payload:
            item.description = payload["description"].strip()
        if "item_type" in payload:
            item.item_type = payload["item_type"].strip().lower()
        if "effect_value" in payload:
            item.effect_value = int(payload["effect_value"])
        if "cost" in payload:
            item.cost = int(payload["cost"])

        return item.to_dict(), None

    def delete_item(self, item_id: str) -> bool:
        if item_id not in self._items:
            return False
        del self._items[item_id]
        return True

    def _validate_payload(self, payload: dict, *, allow_partial: bool) -> Optional[str]:
        required_fields = ["name", "description", "item_type", "effect_value", "cost"]
        if not allow_partial:
            missing = [field for field in required_fields if field not in payload]
            if missing:
                return f"Missing fields: {', '.join(missing)}."

        if "name" in payload and not str(payload["name"]).strip():
            return "Field 'name' cannot be empty."
        if "description" in payload and not str(payload["description"]).strip():
            return "Field 'description' cannot be empty."
        if "item_type" in payload:
            item_type = str(payload["item_type"]).strip().lower()
            if item_type not in VALID_ITEM_TYPES:
                return f"Field 'item_type' must be one of: {', '.join(sorted(VALID_ITEM_TYPES))}."
        if "effect_value" in payload:
            try:
                int(payload["effect_value"])
            except (TypeError, ValueError):
                return "Field 'effect_value' must be an integer."
        if "cost" in payload:
            try:
                int(payload["cost"])
            except (TypeError, ValueError):
                return "Field 'cost' must be an integer."

        return None


inventory_service = InventoryService()
