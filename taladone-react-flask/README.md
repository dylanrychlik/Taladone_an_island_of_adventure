# Taladone React Flask

Initial migration of the JavaFX Taladone project into a full-stack web app:

- **Frontend**: React + React Router + hooks/context
- **Backend**: Flask REST APIs + CORS
- **APIs migrated now**:
  - Inventory item CRUD
  - Game save status create/get/update/load/reset

## Project layout

```text
taladone-react-flask/
  backend/
    app.py
    requirements.txt
    routes/
    services/
    models/
    tests/
  frontend/
    src/
      components/
      pages/
      services/
      hooks/
      context/
    package.json
```

## Local run instructions

## 1) Backend

```bash
cd taladone-react-flask/backend
python3 -m pip install -r requirements.txt
python3 app.py
```

Backend runs by default at: `http://localhost:5000`

## 2) Frontend

In a separate terminal:

```bash
cd taladone-react-flask/frontend
npm install
npm run dev
```

Frontend runs by default at: `http://localhost:5173`

If needed, set API base URL:

```bash
VITE_API_BASE_URL=http://localhost:5000 npm run dev
```

## Tests

## Backend tests

```bash
cd taladone-react-flask/backend
python3 -m pytest -q
```

## Frontend tests

```bash
cd taladone-react-flask/frontend
npm run test:run
```

## Frontend build check

```bash
cd taladone-react-flask/frontend
npm run build
```

## Implemented API endpoints

## Inventory Item API

- `GET /api/inventory`
- `GET /api/inventory/<item_id>`
- `POST /api/inventory`
- `PUT /api/inventory/<item_id>`
- `DELETE /api/inventory/<item_id>`

## Game Save Status API

- `GET /api/save-status`
- `POST /api/save-status`
- `PUT /api/save-status`
- `POST /api/save-status/load`
- `DELETE /api/save-status`

## Migration status (initial)

### Migrated now

- JavaFX discovery/mapping documented (`/workspace/MIGRATION_PLAN.md`)
- Core Davenrun web flow:
  - Start page
  - Inside House page (save/load/reset)
  - Outside House hub
  - General Store page
  - Armory page
  - Gate status page
- Inventory + save status API integration

### Not fully migrated yet

- Full regional quest controller set (Northen/Eastern/Southern/Western/Final) and all side quest battle screens
- Mini-games (poker/blackjack/janken) in web form
- Persistent DB backend (currently in-memory service layer)

