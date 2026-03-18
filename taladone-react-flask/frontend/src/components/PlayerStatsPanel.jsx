export function PlayerStatsPanel({ player }) {
  return (
    <section className="panel">
      <h2>Player Stats</h2>
      <ul className="stats-list">
        <li>
          <strong>Name:</strong> {player.playerName || 'Unnamed Adventurer'}
        </li>
        <li>
          <strong>Health:</strong> {player.health}
        </li>
        <li>
          <strong>Attack Damage:</strong> {player.attackDamage}
        </li>
        <li>
          <strong>Armor:</strong> {player.armor}
        </li>
        <li>
          <strong>Bank:</strong> {player.bank} gold
        </li>
        <li>
          <strong>Jarl Level:</strong> {player.jarlLevelCount}
        </li>
      </ul>
    </section>
  )
}
