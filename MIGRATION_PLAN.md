# Taladone JavaFX -> React + Flask Migration Plan

## Scope of this migration pass

This pass focuses on:

1. **Discovery and architecture mapping** from the existing JavaFX project.
2. **New full-stack scaffold** under `taladone-react-flask/`.
3. **Backend APIs** for:
   - Inventory items
   - Game save status
4. **Initial React translation** of the core Davenrun flow with API integration.
5. **Automated tests** for backend APIs and basic frontend behavior.

This does **not** fully port all ~900 JavaFX files yet. It establishes the migration backbone and ports the core gameplay shell where the JavaFX app starts and where inventory/save logic currently lives.

---

## 1) JavaFX discovery summary (source of truth)

### Project profile

- Build system: NetBeans/Ant (`build.xml`, `nbproject/project.properties`)
- Java version target: Java 8
- Main class: `Davenrun.Taladone_an_island_of_adventure`
- UI framework: JavaFX FXML + controllers
- Data dependencies in legacy code:
  - SQLite path hardcoded to Windows desktop in save/load controllers
  - MySQL connector references also present

### Package-level structure (high-level)

- `Davenrun` (core town, stores, quest office, gate, mini-games, battle arena, save/load)
- `The_northen_woods`, `The_eastern_graveyard`, `The_southern_ocean`, `The_western_mountain`, `The_final_quest` (main quest regions)
- `Side_quests` (optional quest chains)
- Additional game packages (blackjack, poker, etc.)

### Major classes and roles

#### Core app boot

- `Taladone_an_island_of_adventure`
  - Launches JavaFX application and first prompt
  - Handles player naming
  - Starts at `Insidehouse.fxml`
  - Includes legacy load flow hooks (`Database_connection.fxml`)

#### Core game state model

- `Player` (static singleton style)
  - `name`, `health`, `attackdamage`, `armor`, `bank`, `Jarl_level_count`, potion count
  - Effectively global mutable state used by most controllers

#### Inventory/domain models

- `goodItem`, `Weapon`, `Armor`
- Linked-list wrappers:
  - `goodItemlinklist`
  - `Weaponlinklist`
  - `Armorlinklist`
- Inventory containers used by controllers:
  - `OutsidehouseController.gooditem` (LinkedList)
  - `OutsidehouseController.Weaponitem` (Weaponlinklist)
  - `OutsidehouseController.Armoritem` (Armorlinklist)

#### Save/load and persistence

- `InsidehouseController`
  - Save pipeline `save_table1..6`
  - Writes Player state, quest metadata, side quest completion, and quest-location mappings
- `Database_connectionController`
  - Loads player data from SQLite Player table
- Region progress arrays:
  - `The_*/*Northen_bridgeController.locations[]` used as location completion state
- Side quest completion:
  - `OutsidehouseController.Sidequests[]`

#### Navigation and quest gating

- `OutsidehouseController` (core hub)
- `GateController`
  - Gated access to regional quest branches by `Player.getJarl_level_count()`
- `JarlsofficeController`
  - Main quest progression dialog chain
  - Increments `Jarl_level_count`, awards bank gold

### Views/screens (Davenrun core)

Important FXML screens in `src/Davenrun` include:

- `Insidehouse.fxml` / `Outsidehouse.fxml`
- `Fordlands_general_good_store.fxml` + `Inside_good_store.fxml`
- `Armory.fxml` + `Insidearmory.fxml`
- `Gate.fxml`
- `Jarls_palace.fxml`, `Inside_Jarls_palace.fxml`, `Jarlsoffice.fxml`
- `Wines_inn.fxml`, `Venus_well.fxml`, `Boldsman_areana.fxml`, `Davenrun_church.fxml`
- Plus battle and mini-game views

### Dependency flow (critical)

1. `Taladone_an_island_of_adventure` -> enters Davenrun screens.
2. Controllers read/write **global static Player state**.
3. Inventory logic mutates static lists from `OutsidehouseController`.
4. Progress logic mutates:
   - `Sidequests[]`
   - region `locations[]`
5. Save controller reads these globals/arrays and persists snapshots.

### Legacy pain points to modernize carefully

- Heavy static mutable globals
- Tight UI-business coupling inside controllers
- Hardcoded DB paths and SQL strings
- Duplicated quest text/state logic across many controllers
- Minimal formal model boundaries

---

## 2) Migration map: JavaFX -> React/Flask

## What belongs in React (frontend)

- Screen rendering and navigation (route-based)
- Dialog/interaction flow for Davenrun core screens
- Local UI state (menus, selected inventory item, conversation choices)
- Client-side composition of view models from API responses
- Map/quest-status visual presentation

## What belongs in Flask (backend)

- Inventory persistence + CRUD API
- Save status persistence + load/update/reset API
- Server-side validation and normalization
- Canonical schema contracts for game-state snapshots

## What can remain client-side for now (Phase 1 web)

- Rich conversation text trees
- Non-persistent UI-only flags
- Map ASCII-style rendering representation
- Some immediate interaction effects before broader regional port

## What should become API-driven now

1. **Inventory items** (all CRUD via API)
2. **Game save status** (create/get/update/load/reset via API)

---

## 3) Proposed web architecture

## Backend (`Flask`)

- `app.py` -> app factory entrypoint + CORS + blueprint registration
- `routes/` -> REST endpoints
- `services/` -> in-memory repositories + domain operations
- `models/` -> dataclasses/schemas for inventory + save status
- `tests/` -> pytest route tests

Persistence strategy:
- In-memory repositories now
- Service interfaces designed to be swappable to SQLite later

## Frontend (`React`)

- `pages/` for primary screens (Start, House, Outside, Gate, Stores, Save)
- `components/` for reusable UI panels (player stats, inventory list)
- `context/` for global player/game session state
- `services/` for API clients (inventory, save status)
- `hooks/` for async fetch/update helpers

Routing:
- React Router for multi-screen JavaFX parity

---

## 4) End gates (Definition of Done by phase)

## Phase 1: Discovery

- [x] Core classes and state model identified
- [x] Save and inventory behavior traced
- [x] Migration ownership split documented

## Phase 2: Scaffold

- [ ] `taladone-react-flask/` structure created
- [ ] Frontend and backend start scripts available

## Phase 3: Backend APIs

- [ ] Inventory endpoints implemented:
  - `GET /api/inventory`
  - `GET /api/inventory/<id>`
  - `POST /api/inventory`
  - `PUT /api/inventory/<id>`
  - `DELETE /api/inventory/<id>`
- [ ] Save status endpoints implemented:
  - `GET /api/save-status`
  - `POST /api/save-status`
  - `PUT /api/save-status`
  - `POST /api/save-status/load`
  - `DELETE /api/save-status`
- [ ] JSON-only responses
- [ ] Backend tests pass

## Phase 4: Frontend initial translation

- [ ] JavaFX-like start -> house -> outside/store flow represented
- [ ] Inventory UI uses Flask APIs
- [ ] Save/load controls use Flask APIs
- [ ] Basic frontend tests pass

## Phase 5: Verification

- [ ] Behavior parity checks documented for migrated screens
- [ ] Missing logic/regressions listed clearly
- [ ] Run instructions validated

---

## 5) Incremental migration strategy after this pass

1. Expand regional quest routes one region at a time:
   - Northen Woods -> Eastern Graveyard -> Southern Ocean -> Western Mountain -> Final Quest
2. Convert static arrays (`locations[]`, `Sidequests[]`) to typed save-status schema fields.
3. Introduce persistent storage (SQLite) behind service interfaces.
4. Extract and unit-test reusable combat/quest resolution logic.

