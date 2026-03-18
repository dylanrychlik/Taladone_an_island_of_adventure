import { Link } from 'react-router-dom'

export function NotFoundPage() {
  return (
    <main className="page">
      <section className="panel">
        <h1>Page not found</h1>
        <p>The path you requested is not part of the current migration scope.</p>
        <Link className="button-link" to="/">
          Return to Start
        </Link>
      </section>
    </main>
  )
}
