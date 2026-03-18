import { apiClient } from './apiClient'

export const inventoryService = {
  async getAll() {
    const data = await apiClient.get('/api/inventory')
    return data.items
  },

  async getById(itemId) {
    const data = await apiClient.get(`/api/inventory/${itemId}`)
    return data.item
  },

  async add(item) {
    const data = await apiClient.post('/api/inventory', item)
    return data.item
  },

  async update(itemId, updates) {
    const data = await apiClient.put(`/api/inventory/${itemId}`, updates)
    return data.item
  },

  async remove(itemId) {
    return apiClient.delete(`/api/inventory/${itemId}`)
  },
}
