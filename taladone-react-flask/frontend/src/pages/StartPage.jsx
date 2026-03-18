import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useGameContext } from '../context/GameContext'

export function StartPage() {
  const navigate = useNavigate()
  const { player, setPlayerName } = useGameContext()
  const [nameInput, setNameInput] = useState(player.playerName)
  const [error, setError] = useState('')

  const startGame = () => {
    const trimmed = nameInput.trim()
    if (!trimmed) {
      setError('Please enter your adventurer name.')
      return
    }
    setError('')
    setPlayerName(trimmed)
    navigate('/inside-house')
  }

  return (
    <main className="page">
      <section className="panel hero-panel">
        <h1>Taladone: An Island of Adventure</h1>
        <p>
          A React + Flask migration of the original JavaFX experience. Start in
          your house in Davenrun and prepare for adventure.
        </p>
      </section>

      <section className="panel form-panel">
        <label htmlFor="playerName">Adventurer Name</label>
        <input
          id="playerName"
          value={nameInput}
          onChange={(event) => setNameInput(event.target.value)}
          placeholder="Enter your name"
        />
        <div className="button-row">
          <button onClick={startGame}>Play Game</button>
        </div>
        {error ? <p className="error-text">{error}</p> : null}
      </section>
    </main>
  )
}
