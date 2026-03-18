import { Link } from 'react-router-dom'
import { InventoryPanel } from '../components/InventoryPanel'
import { PlayerStatsPanel } from '../components/PlayerStatsPanel'
import { QuestPanel } from '../components/QuestPanel'
import { useGameContext } from '../context/GameContext'
import { useInventory } from '../hooks/useInventory'

const outsideIntro =
  'You stand outside your house in Davenrun. You can head to the stores, return inside, or move toward the gate.'

export function OutsideHousePage() {
  const { player } = useGameContext()
  const { items, loading, error } = useInventory()

  return (
    <main className="page">
      <section className="panel">
        <h1>Outside House</h1>
        <p>{outsideIntro}</p>
        <div className="button-row">
          <Link className="button-link" to="/inside-house">
            Go Inside
          </Link>
          <Link className="button-link" to="/general-store">
            Fordland&apos;s General Store
          </Link>
          <Link className="button-link" to="/armory">
            Armory
          </Link>
          <Link className="button-link" to="/gate">
            Gate
          </Link>
        </div>
      </section>

      <div className="grid">
        <PlayerStatsPanel player={player} />
        <QuestPanel jarlLevelCount={player.jarlLevelCount} />
      </div>

      <section className="panel">
        {loading ? <p>Loading inventory...</p> : null}
        {error ? <p className="error-text">{error}</p> : null}
        {!loading && !error ? <InventoryPanel items={items} /> : null}
      </section>
    </main>
  )
}
