import { createContext, useContext, useMemo, useState } from 'react'

const GameContext = createContext(null)

const createInitialRegionProgress = () => ({
  northen_woods: Array(30).fill(false),
  eastern_graveyard: Array(30).fill(false),
  southern_ocean: Array(30).fill(false),
  western_mountain: Array(30).fill(false),
})

const initialPlayer = {
  playerName: '',
  health: 100,
  attackDamage: 100,
  armor: 0,
  bank: 100,
  jarlLevelCount: 0,
  sidequests: Array(15).fill(false),
  regionProgress: createInitialRegionProgress(),
}

export function GameProvider({ children }) {
  const [player, setPlayer] = useState(initialPlayer)

  const setPlayerName = (playerName) => {
    setPlayer((prev) => ({ ...prev, playerName }))
  }

  const patchPlayer = (patch) => {
    setPlayer((prev) => ({ ...prev, ...patch }))
  }

  const applyInventoryEffect = (item, direction) => {
    const safeDirection = direction >= 0 ? 1 : -1

    setPlayer((prev) => {
      const next = { ...prev }

      if (item.item_type === 'good') {
        next.health = Math.max(0, prev.health + item.effect_value * safeDirection)
      } else if (item.item_type === 'weapon') {
        next.attackDamage = Math.max(
          0,
          prev.attackDamage + item.effect_value * safeDirection,
        )
      } else if (item.item_type === 'armor') {
        next.armor = Math.max(0, prev.armor + item.effect_value * safeDirection)
      }

      return next
    })
  }

  const adjustBank = (delta) => {
    setPlayer((prev) => ({ ...prev, bank: Math.max(0, prev.bank + delta) }))
  }

  const resetPlayerToDefaults = () => {
    setPlayer(initialPlayer)
  }

  const value = useMemo(
    () => ({
      player,
      setPlayerName,
      patchPlayer,
      applyInventoryEffect,
      adjustBank,
      resetPlayerToDefaults,
    }),
    [player],
  )

  return <GameContext.Provider value={value}>{children}</GameContext.Provider>
}

export function useGameContext() {
  const ctx = useContext(GameContext)
  if (!ctx) {
    throw new Error('useGameContext must be used inside GameProvider.')
  }
  return ctx
}
