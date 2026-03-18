import { render, screen } from '@testing-library/react'
import { MemoryRouter } from 'react-router-dom'
import { describe, expect, it } from 'vitest'
import App from './App'

describe('App', () => {
  it('renders the Taladone start screen title', () => {
    render(
      <MemoryRouter>
        <App />
      </MemoryRouter>,
    )

    expect(
      screen.getByRole('heading', { name: /taladone: an island of adventure/i }),
    ).toBeInTheDocument()
  })
})
