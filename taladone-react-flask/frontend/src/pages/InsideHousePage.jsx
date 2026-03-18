import { useState } from 'react'
import { Link } from 'react-router-dom'
import { PlayerStatsPanel } from '../components/PlayerStatsPanel'
import { useGameContext } from '../context/GameContext'
import { useInventory } from '../hooks/useInventory'
import { useSaveStatus } from '../hooks/useSaveStatus'

const introText =
  'You wake up in your tiny one-room house in Davenrun. Dawn is breaking, and your adventure begins.'

export function InsideHousePage() {
  const { player, patchPlayer } = useGameContext()
  const { items } = useInventory()
  const saveStatus = useSaveStatus()
  const [message, setMessage] = useState('')

  const handleSave = async () => {
    try {
      const saved = await saveStatus.createSave({
        player_name: player.playerName || 'Unnamed Adventurer',
        health: player.health,
        attack_damage: player.attackDamage,
        armor: player.armor,
        bank: player.bank,
        jarl_level_count: player.jarlLevelCount,
        inventory_item_ids: items.map((item) => item.id),
        sidequests: player.sidequests,
        region_progress: player.regionProgress,
      })
      setMessage(`Game saved at ${new Date(saved.updated_at).toLocaleString()}.`)
    } catch {
      setMessage('Failed to save game status.')
    }
  }

  const handleLoad = async () => {
    try {
      const loaded = await saveStatus.loadSavedStatus()
      patchPlayer({
        playerName: loaded.player_name,
        health: loaded.health,
        attackDamage: loaded.attack_damage,
        armor: loaded.armor,
        bank: loaded.bank,
        jarlLevelCount: loaded.jarl_level_count,
        sidequests: loaded.sidequests,
        regionProgress: loaded.region_progress,
      })
      setMessage('Saved game loaded.')
    } catch {
      setMessage('No saved status available to load.')
    }
  }

  const handleResetSave = async () => {
    try {
      await saveStatus.resetSave()
      setMessage('Save status reset.')
    } catch {
      setMessage('Unable to reset save status.')
    }
  }

  return (
    <main className="page">
      <section className="panel">
        <h1>Inside House</h1>
        <p>{introText}</p>
        <div className="button-row">
          <Link className="button-link" to="/outside-house">
            Go Outside
          </Link>
          <button onClick={handleSave} disabled={saveStatus.loading}>
            Save Game
          </button>
          <button onClick={handleLoad} disabled={saveStatus.loading}>
            Load Saved Status
          </button>
          <button onClick={handleResetSave} disabled={saveStatus.loading}>
            Reset Save
          </button>
        </div>
        {message ? <p className="success-text">{message}</p> : null}
        {saveStatus.error ? <p className="error-text">{saveStatus.error}</p> : null}
      </section>

      <PlayerStatsPanel player={player} />
    </main>
  )
}
