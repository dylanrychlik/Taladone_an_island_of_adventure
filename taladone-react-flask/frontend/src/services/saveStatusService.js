import { apiClient } from './apiClient'

export const saveStatusService = {
  async getCurrent() {
    return apiClient.get('/api/save-status')
  },

  async createSave(payload) {
    const data = await apiClient.post('/api/save-status', payload)
    return data.status
  },

  async updateSave(payload) {
    const data = await apiClient.put('/api/save-status', payload)
    return data.status
  },

  async loadSavedStatus() {
    const data = await apiClient.post('/api/save-status/load', {})
    return data.status
  },

  async resetSave() {
    return apiClient.delete('/api/save-status')
  },
}
