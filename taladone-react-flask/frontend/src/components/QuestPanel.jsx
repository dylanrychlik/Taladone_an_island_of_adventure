function questText(level) {
  if ([0, 2, 4, 6, 8, 10].includes(level)) {
    return 'You currently have no active main quest.'
  }
  if (level === 1) {
    return 'Quest 1: The Northen Woods - Defeat the Dragon of Taladone.'
  }
  if (level === 3) {
    return 'Quest 2: The Eastern Graveyard - Defeat the Demon of the East.'
  }
  if (level === 5) {
    return 'Quest 3: The Southern Ocean - Defeat the Sea Creature.'
  }
  if (level === 7) {
    return 'Quest 4: The Western Mountain - Defeat the mountain evil.'
  }
  if (level === 9) {
    return 'Quest 5: The Final Quest - Defeat the evil in the church.'
  }
  if (level >= 11) {
    return 'Main story complete: Hero of Taladone.'
  }
  return 'Continue your journey through Taladone.'
}

export function QuestPanel({ jarlLevelCount }) {
  return (
    <section className="panel">
      <h2>Quest Status</h2>
      <p>{questText(jarlLevelCount)}</p>
    </section>
  )
}
