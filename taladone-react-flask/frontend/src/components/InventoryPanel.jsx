export function InventoryPanel({ items, title = 'Inventory' }) {
  return (
    <section className="panel">
      <h2>{title}</h2>
      {items.length === 0 ? (
        <p>No inventory items yet.</p>
      ) : (
        <ul className="inventory-list">
          {items.map((item) => (
            <li key={item.id} className="inventory-item">
              <div>
                <strong>{item.name}</strong> ({item.item_type})
              </div>
              <div className="muted">{item.description}</div>
              <div>
                Effect: {item.effect_value} | Cost: {item.cost}
              </div>
            </li>
          ))}
        </ul>
      )}
    </section>
  )
}
