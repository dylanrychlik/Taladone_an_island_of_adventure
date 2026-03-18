def test_get_inventory_items_returns_seed_items(client):
    response = client.get("/api/inventory")
    assert response.status_code == 200
    data = response.get_json()
    assert "items" in data
    assert data["count"] == len(data["items"])
    assert data["count"] >= 6


def test_inventory_crud_flow(client):
    create_payload = {
        "id": "good-99",
        "name": "Magic Potion",
        "description": "Restores 50 health",
        "item_type": "good",
        "effect_value": 50,
        "cost": 20,
    }
    create_response = client.post("/api/inventory", json=create_payload)
    assert create_response.status_code == 201
    created = create_response.get_json()["item"]
    assert created["id"] == "good-99"
    assert created["name"] == "Magic Potion"

    get_response = client.get("/api/inventory/good-99")
    assert get_response.status_code == 200
    assert get_response.get_json()["item"]["cost"] == 20

    update_response = client.put(
        "/api/inventory/good-99",
        json={"cost": 35, "description": "Restores 50 health points"},
    )
    assert update_response.status_code == 200
    updated = update_response.get_json()["item"]
    assert updated["cost"] == 35
    assert updated["description"] == "Restores 50 health points"

    delete_response = client.delete("/api/inventory/good-99")
    assert delete_response.status_code == 200

    missing_response = client.get("/api/inventory/good-99")
    assert missing_response.status_code == 404


def test_create_inventory_item_rejects_invalid_item_type(client):
    response = client.post(
        "/api/inventory",
        json={
            "name": "Invalid Item",
            "description": "Bad type",
            "item_type": "artifact",
            "effect_value": 1,
            "cost": 1,
        },
    )
    assert response.status_code == 400
    assert "item_type" in response.get_json()["error"]
