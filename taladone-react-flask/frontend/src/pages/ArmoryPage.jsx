import { useMemo, useState } from 'react'
import { Link } from 'react-router-dom'
import { PlayerStatsPanel } from '../components/PlayerStatsPanel'
import { armoryArmorCatalog, armoryWeaponCatalog } from '../data/storeCatalog'
import { useGameContext } from '../context/GameContext'
import { useInventory } from '../hooks/useInventory'

export function ArmoryPage() {
  const { player, applyInventoryEffect, adjustBank } = useGameContext()
  const { items, addItem, removeItem, loading, error } = useInventory()
  const [selectedWeaponIndex, setSelectedWeaponIndex] = useState(0)
  const [selectedArmorIndex, setSelectedArmorIndex] = useState(0)
  const [selectedSellWeaponId, setSelectedSellWeaponId] = useState('')
  const [selectedSellArmorId, setSelectedSellArmorId] = useState('')
  const [message, setMessage] = useState('')

  const ownedWeapons = useMemo(
    () => items.filter((item) => item.item_type === 'weapon'),
    [items],
  )
  const ownedArmor = useMemo(
    () => items.filter((item) => item.item_type === 'armor'),
    [items],
  )

  const buyItem = async (catalogItem) => {
    if (catalogItem.cost > player.bank) {
      setMessage('You do not have enough funds for that item.')
      return
    }

    try {
      const created = await addItem(catalogItem)
      adjustBank(-created.cost)
      applyInventoryEffect(created, 1)
      setMessage(`${created.name} added to your inventory.`)
    } catch (buyError) {
      setMessage(buyError.message)
    }
  }

  const sellItem = async (item, resetSelection) => {
    if (!item) {
      setMessage('Select an inventory item to sell.')
      return
    }
    try {
      await removeItem(item.id)
      adjustBank(item.cost)
      applyInventoryEffect(item, -1)
      resetSelection('')
      setMessage(`${item.name} sold.`)
    } catch (sellError) {
      setMessage(sellError.message)
    }
  }

  return (
    <main className="page">
      <section className="panel">
        <h1>Armory</h1>
        <p>Buy and sell weapons and armor to prepare for Taladone&apos;s dangers.</p>
        <div className="button-row">
          <Link className="button-link" to="/outside-house">
            Return to Outside House
          </Link>
        </div>
      </section>

      <div className="grid">
        <PlayerStatsPanel player={player} />

        <section className="panel">
          <h2>Buy Weapon</h2>
          <select
            value={selectedWeaponIndex}
            onChange={(event) => setSelectedWeaponIndex(Number(event.target.value))}
          >
            {armoryWeaponCatalog.map((item, index) => (
              <option key={`${item.name}-${index}`} value={index}>
                {item.name} (cost: {item.cost}, effect: {item.effect_value})
              </option>
            ))}
          </select>
          <button onClick={() => buyItem(armoryWeaponCatalog[selectedWeaponIndex])}>
            Buy Weapon
          </button>

          <h2>Buy Armor</h2>
          <select
            value={selectedArmorIndex}
            onChange={(event) => setSelectedArmorIndex(Number(event.target.value))}
          >
            {armoryArmorCatalog.map((item, index) => (
              <option key={`${item.name}-${index}`} value={index}>
                {item.name} (cost: {item.cost}, effect: {item.effect_value})
              </option>
            ))}
          </select>
          <button onClick={() => buyItem(armoryArmorCatalog[selectedArmorIndex])}>
            Buy Armor
          </button>
        </section>
      </div>

      <section className="panel">
        <h2>Sell Weapon</h2>
        <select
          value={selectedSellWeaponId}
          onChange={(event) => setSelectedSellWeaponId(event.target.value)}
        >
          <option value="">Select weapon</option>
          {ownedWeapons.map((item) => (
            <option key={item.id} value={item.id}>
              {item.name} (cost: {item.cost})
            </option>
          ))}
        </select>
        <button
          onClick={() =>
            sellItem(
              ownedWeapons.find((item) => item.id === selectedSellWeaponId),
              setSelectedSellWeaponId,
            )
          }
        >
          Sell Weapon
        </button>

        <h2>Sell Armor</h2>
        <select
          value={selectedSellArmorId}
          onChange={(event) => setSelectedSellArmorId(event.target.value)}
        >
          <option value="">Select armor</option>
          {ownedArmor.map((item) => (
            <option key={item.id} value={item.id}>
              {item.name} (cost: {item.cost})
            </option>
          ))}
        </select>
        <button
          onClick={() =>
            sellItem(
              ownedArmor.find((item) => item.id === selectedSellArmorId),
              setSelectedSellArmorId,
            )
          }
        >
          Sell Armor
        </button>
      </section>

      {loading ? <p>Loading inventory...</p> : null}
      {error ? <p className="error-text">{error}</p> : null}
      {message ? <p className="success-text">{message}</p> : null}
    </main>
  )
}
