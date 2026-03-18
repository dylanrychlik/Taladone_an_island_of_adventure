from flask import Blueprint, jsonify, request

from services.save_status_service import save_status_service

save_status_bp = Blueprint("save_status", __name__, url_prefix="/api/save-status")


@save_status_bp.get("")
def get_current_save_status() -> tuple:
    current = save_status_service.get_current_status()
    return jsonify(current), 200


@save_status_bp.post("")
def create_save_status() -> tuple:
    payload = request.get_json(silent=True) or {}
    status, error = save_status_service.create_or_save(payload)
    if error:
        return jsonify({"error": error}), 400
    return jsonify({"status": status}), 201


@save_status_bp.put("")
def update_save_status() -> tuple:
    payload = request.get_json(silent=True) or {}
    status, error = save_status_service.update(payload)
    if error == "No saved status exists to update.":
        return jsonify({"error": error}), 404
    if error:
        return jsonify({"error": error}), 400
    return jsonify({"status": status}), 200


@save_status_bp.post("/load")
def load_save_status() -> tuple:
    status, error = save_status_service.load()
    if error:
        return jsonify({"error": error}), 404
    return jsonify({"status": status}), 200


@save_status_bp.delete("")
def reset_save_status() -> tuple:
    existed = save_status_service.reset()
    return jsonify({"message": "Save status reset.", "had_save": existed}), 200
