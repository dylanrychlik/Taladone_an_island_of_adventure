import os
import sys

import pytest

BACKEND_ROOT = os.path.abspath(os.path.join(os.path.dirname(__file__), ".."))
if BACKEND_ROOT not in sys.path:
    sys.path.insert(0, BACKEND_ROOT)

from app import create_app
from services.inventory_service import inventory_service
from services.save_status_service import save_status_service


@pytest.fixture(autouse=True)
def reset_services() -> None:
    inventory_service._seed_from_javafx_defaults()
    save_status_service.reset()


@pytest.fixture()
def app():
    app = create_app()
    app.config.update({"TESTING": True})
    return app


@pytest.fixture()
def client(app):
    return app.test_client()
