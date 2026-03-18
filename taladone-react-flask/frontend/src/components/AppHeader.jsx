import { Link } from 'react-router-dom'
import { useGameContext } from '../context/GameContext'

export function AppHeader() {
  const { player } = useGameContext()

  return (
    <header className="app-header">
      <div>
        <strong>Taladone React Flask</strong>
      </div>
      <nav className="header-nav">
        <Link to="/">Start</Link>
        <Link to="/inside-house">Inside House</Link>
        <Link to="/outside-house">Outside House</Link>
        <Link to="/general-store">General Store</Link>
        <Link to="/armory">Armory</Link>
        <Link to="/gate">Gate</Link>
      </nav>
      <div className="muted">
        {player.playerName ? `Adventurer: ${player.playerName}` : 'No player set'}
      </div>
    </header>
  )
}
