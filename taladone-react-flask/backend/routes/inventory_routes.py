from flask import Blueprint, jsonify, request

from services.inventory_service import inventory_service

inventory_bp = Blueprint("inventory", __name__, url_prefix="/api/inventory")


@inventory_bp.get("")
def get_inventory_items() -> tuple:
    items = inventory_service.list_items()
    return jsonify({"items": items, "count": len(items)}), 200


@inventory_bp.get("/<item_id>")
def get_inventory_item(item_id: str) -> tuple:
    item = inventory_service.get_item(item_id)
    if not item:
        return jsonify({"error": "Inventory item not found."}), 404
    return jsonify({"item": item}), 200


@inventory_bp.post("")
def create_inventory_item() -> tuple:
    payload = request.get_json(silent=True) or {}
    item, error = inventory_service.create_item(payload)
    if error:
        return jsonify({"error": error}), 400
    return jsonify({"item": item}), 201


@inventory_bp.put("/<item_id>")
def update_inventory_item(item_id: str) -> tuple:
    payload = request.get_json(silent=True) or {}
    item, error = inventory_service.update_item(item_id, payload)
    if error == "Item not found.":
        return jsonify({"error": error}), 404
    if error:
        return jsonify({"error": error}), 400
    return jsonify({"item": item}), 200


@inventory_bp.delete("/<item_id>")
def delete_inventory_item(item_id: str) -> tuple:
    deleted = inventory_service.delete_item(item_id)
    if not deleted:
        return jsonify({"error": "Inventory item not found."}), 404
    return jsonify({"message": f"Inventory item '{item_id}' deleted."}), 200
