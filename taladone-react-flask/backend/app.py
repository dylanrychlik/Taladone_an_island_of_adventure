from flask import Flask, jsonify
from flask_cors import CORS

from routes.inventory_routes import inventory_bp
from routes.save_status_routes import save_status_bp


def create_app() -> Flask:
    app = Flask(__name__)
    app.config["JSON_SORT_KEYS"] = False

    # Local development CORS for React dev server.
    CORS(app, resources={r"/api/*": {"origins": "*"}})

    app.register_blueprint(inventory_bp)
    app.register_blueprint(save_status_bp)

    @app.get("/api/health")
    def health() -> tuple:
        return jsonify({"status": "ok"}), 200

    return app


app = create_app()


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
