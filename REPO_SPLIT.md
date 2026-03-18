# Repository Split Notes

The project has been split into two repositories:

## 1) JavaFX repository (this repo)

- Path: `/workspace`
- Contents: original JavaFX Taladone project (`src/`, `nbproject/`, Ant build files)

## 2) React + Flask repository (standalone)

- Path: `/home/ubuntu/taladone-react-flask-repo`
- Git status: initialized as an independent git repository
- Initial commit: `Initial Taladone React Flask repository`

## Optional: push the new React/Flask repo to GitHub

From the new repo path:

```bash
cd /home/ubuntu/taladone-react-flask-repo
git branch -m main
git remote add origin <your-new-react-flask-repo-url>
git push -u origin main
```
