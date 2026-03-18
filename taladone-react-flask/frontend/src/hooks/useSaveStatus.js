import { useState } from 'react'
import { saveStatusService } from '../services/saveStatusService'

export function useSaveStatus() {
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState('')

  const run = async (fn) => {
    setLoading(true)
    setError('')
    try {
      return await fn()
    } catch (err) {
      setError(err.message)
      throw err
    } finally {
      setLoading(false)
    }
  }

  return {
    loading,
    error,
    getCurrent: () => run(() => saveStatusService.getCurrent()),
    createSave: (payload) => run(() => saveStatusService.createSave(payload)),
    updateSave: (payload) => run(() => saveStatusService.updateSave(payload)),
    loadSavedStatus: () => run(() => saveStatusService.loadSavedStatus()),
    resetSave: () => run(() => saveStatusService.resetSave()),
  }
}
