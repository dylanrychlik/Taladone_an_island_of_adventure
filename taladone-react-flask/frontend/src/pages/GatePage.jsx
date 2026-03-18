import { Link } from 'react-router-dom'
import { PlayerStatsPanel } from '../components/PlayerStatsPanel'
import { useGameContext } from '../context/GameContext'

const gateOptions = [
  { key: 'northen_woods', label: 'Northen Woods', requiredLevel: 1 },
  { key: 'eastern_graveyard', label: 'Eastern Graveyard', requiredLevel: 3 },
  { key: 'southern_ocean', label: 'Southern Ocean', requiredLevel: 5 },
  { key: 'western_mountain', label: 'Western Mountain', requiredLevel: 7 },
]

export function GatePage() {
  const { player } = useGameContext()

  return (
    <main className="page">
      <section className="panel">
        <h1>Gate</h1>
        <p>
          In the JavaFX game, the gate checks your Jarl quest level before
          letting you enter each major region. This page mirrors that gating
          status in the initial web migration.
        </p>
        <div className="button-row">
          <Link className="button-link" to="/outside-house">
            Return to Outside House
          </Link>
        </div>
      </section>

      <PlayerStatsPanel player={player} />

      <section className="panel">
        <h2>Regional Access</h2>
        <ul className="inventory-list">
          {gateOptions.map((option) => {
            const unlocked = player.jarlLevelCount >= option.requiredLevel
            return (
              <li key={option.key} className="inventory-item">
                <strong>{option.label}</strong>
                <div>
                  Required Jarl Level: {option.requiredLevel} | Status:{' '}
                  {unlocked ? 'Unlocked' : 'Locked'}
                </div>
              </li>
            )
          })}
        </ul>
      </section>
    </main>
  )
}
