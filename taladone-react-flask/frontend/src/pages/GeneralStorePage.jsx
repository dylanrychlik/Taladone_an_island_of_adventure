import { useMemo, useState } from 'react'
import { Link } from 'react-router-dom'
import { PlayerStatsPanel } from '../components/PlayerStatsPanel'
import { goodStoreCatalog } from '../data/storeCatalog'
import { useGameContext } from '../context/GameContext'
import { useInventory } from '../hooks/useInventory'

export function GeneralStorePage() {
  const { player, applyInventoryEffect, adjustBank } = useGameContext()
  const { items, addItem, removeItem, loading, error } = useInventory()
  const [selectedCatalogIndex, setSelectedCatalogIndex] = useState(0)
  const [selectedSellId, setSelectedSellId] = useState('')
  const [message, setMessage] = useState('')

  const selectedCatalogItem = goodStoreCatalog[selectedCatalogIndex]
  const ownedGoodItems = useMemo(
    () => items.filter((item) => item.item_type === 'good'),
    [items],
  )

  const buySelected = async () => {
    if (!selectedCatalogItem) {
      return
    }
    if (selectedCatalogItem.cost > player.bank) {
      setMessage('You do not have enough funds for that item.')
      return
    }

    try {
      const created = await addItem(selectedCatalogItem)
      adjustBank(-created.cost)
      applyInventoryEffect(created, 1)
      setMessage(`${created.name} added to your inventory.`)
    } catch (buyError) {
      setMessage(buyError.message)
    }
  }

  const sellSelected = async () => {
    if (!selectedSellId) {
      setMessage('Select an inventory item to sell.')
      return
    }
    const itemToSell = ownedGoodItems.find((item) => item.id === selectedSellId)
    if (!itemToSell) {
      setMessage('Selected item is no longer available.')
      return
    }

    try {
      await removeItem(itemToSell.id)
      adjustBank(itemToSell.cost)
      applyInventoryEffect(itemToSell, -1)
      setSelectedSellId('')
      setMessage(`${itemToSell.name} sold.`)
    } catch (sellError) {
      setMessage(sellError.message)
    }
  }

  return (
    <main className="page">
      <section className="panel">
        <h1>Fordland&apos;s General Good Store</h1>
        <p>
          Buy useful goods or sell items from your inventory, mirroring the
          JavaFX store behavior in a web flow.
        </p>
        <div className="button-row">
          <Link className="button-link" to="/outside-house">
            Return to Outside House
          </Link>
        </div>
      </section>

      <div className="grid">
        <PlayerStatsPanel player={player} />

        <section className="panel">
          <h2>Buy Good Item</h2>
          <select
            value={selectedCatalogIndex}
            onChange={(event) => setSelectedCatalogIndex(Number(event.target.value))}
          >
            {goodStoreCatalog.map((item, index) => (
              <option key={`${item.name}-${index}`} value={index}>
                {item.name} (cost: {item.cost}, effect: {item.effect_value})
              </option>
            ))}
          </select>
          <button onClick={buySelected}>Buy Item</button>
        </section>
      </div>

      <section className="panel">
        <h2>Sell Good Item</h2>
        <select
          value={selectedSellId}
          onChange={(event) => setSelectedSellId(event.target.value)}
        >
          <option value="">Select an item to sell</option>
          {ownedGoodItems.map((item) => (
            <option key={item.id} value={item.id}>
              {item.name} (cost: {item.cost})
            </option>
          ))}
        </select>
        <button onClick={sellSelected}>Sell Item</button>
      </section>

      {loading ? <p>Loading inventory...</p> : null}
      {error ? <p className="error-text">{error}</p> : null}
      {message ? <p className="success-text">{message}</p> : null}
    </main>
  )
}
