import { useCallback, useEffect, useState } from 'react'
import { inventoryService } from '../services/inventoryService'

export function useInventory() {
  const [items, setItems] = useState([])
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')

  const refresh = useCallback(async () => {
    setLoading(true)
    setError('')
    try {
      const fetchedItems = await inventoryService.getAll()
      setItems(fetchedItems)
    } catch (err) {
      setError(err.message)
    } finally {
      setLoading(false)
    }
  }, [])

  useEffect(() => {
    refresh()
  }, [refresh])

  const addItem = async (item) => {
    const created = await inventoryService.add(item)
    setItems((prev) => [...prev, created])
    return created
  }

  const updateItem = async (itemId, updates) => {
    const updated = await inventoryService.update(itemId, updates)
    setItems((prev) => prev.map((item) => (item.id === itemId ? updated : item)))
    return updated
  }

  const removeItem = async (itemId) => {
    await inventoryService.remove(itemId)
    setItems((prev) => prev.filter((item) => item.id !== itemId))
  }

  return {
    items,
    loading,
    error,
    refresh,
    addItem,
    updateItem,
    removeItem,
  }
}
