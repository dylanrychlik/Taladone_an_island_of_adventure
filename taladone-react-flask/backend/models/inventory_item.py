from dataclasses import asdict, dataclass


@dataclass
class InventoryItem:
    id: str
    name: str
    description: str
    item_type: str
    effect_value: int
    cost: int

    def to_dict(self) -> dict:
        return asdict(self)
