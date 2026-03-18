import { Navigate, Route, Routes } from 'react-router-dom'
import { AppHeader } from './components/AppHeader'
import { GameProvider } from './context/GameContext'
import { ArmoryPage } from './pages/ArmoryPage'
import { GatePage } from './pages/GatePage'
import { GeneralStorePage } from './pages/GeneralStorePage'
import { InsideHousePage } from './pages/InsideHousePage'
import { NotFoundPage } from './pages/NotFoundPage'
import { OutsideHousePage } from './pages/OutsideHousePage'
import { StartPage } from './pages/StartPage'
import './styles.css'

function App() {
  return (
    <GameProvider>
      <div className="app-shell">
        <AppHeader />
        <Routes>
          <Route path="/" element={<StartPage />} />
          <Route path="/inside-house" element={<InsideHousePage />} />
          <Route path="/outside-house" element={<OutsideHousePage />} />
          <Route path="/general-store" element={<GeneralStorePage />} />
          <Route path="/armory" element={<ArmoryPage />} />
          <Route path="/gate" element={<GatePage />} />
          <Route path="/home" element={<Navigate to="/" replace />} />
          <Route path="*" element={<NotFoundPage />} />
        </Routes>
      </div>
    </GameProvider>
  )
}

export default App
