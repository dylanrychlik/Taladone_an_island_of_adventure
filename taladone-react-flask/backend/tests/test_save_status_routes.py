def test_get_current_save_status_when_empty(client):
    response = client.get("/api/save-status")
    assert response.status_code == 200
    data = response.get_json()
    assert data["has_save"] is False
    assert data["status"] is None


def test_create_and_load_save_status(client):
    create_payload = {
        "player_name": "Dylan",
        "health": 120,
        "attack_damage": 140,
        "armor": 80,
        "bank": 350,
        "jarl_level_count": 3,
        "sidequests": [False] * 15,
        "region_progress": {
            "northen_woods": [True] * 30,
            "eastern_graveyard": [False] * 30,
            "southern_ocean": [False] * 30,
            "western_mountain": [False] * 30,
        },
    }

    create_response = client.post("/api/save-status", json=create_payload)
    assert create_response.status_code == 201
    created = create_response.get_json()["status"]
    assert created["player_name"] == "Dylan"
    assert created["jarl_level_count"] == 3

    load_response = client.post("/api/save-status/load")
    assert load_response.status_code == 200
    loaded = load_response.get_json()["status"]
    assert loaded["bank"] == 350
    assert loaded["region_progress"]["northen_woods"][0] is True


def test_update_save_status(client):
    client.post(
        "/api/save-status",
        json={
            "player_name": "Dylan",
            "health": 100,
            "attack_damage": 100,
            "armor": 0,
            "bank": 100,
            "jarl_level_count": 0,
        },
    )

    update_response = client.put(
        "/api/save-status",
        json={"bank": 900, "jarl_level_count": 5},
    )
    assert update_response.status_code == 200
    updated = update_response.get_json()["status"]
    assert updated["bank"] == 900
    assert updated["jarl_level_count"] == 5


def test_reset_save_status(client):
    client.post(
        "/api/save-status",
        json={
            "player_name": "Dylan",
            "health": 100,
            "attack_damage": 100,
            "armor": 0,
            "bank": 100,
            "jarl_level_count": 0,
        },
    )

    reset_response = client.delete("/api/save-status")
    assert reset_response.status_code == 200
    assert reset_response.get_json()["had_save"] is True

    load_after_reset = client.post("/api/save-status/load")
    assert load_after_reset.status_code == 404
