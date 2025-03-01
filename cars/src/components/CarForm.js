function CarForm() {
 const handleNameChange = (event) => {
  
 };

  return (
    <div className="car-form-panel">
      <h4 className="subtitle is-3">Add car</h4>
      <form>
        <div className="filed-group">
          <div className="filed">
            <label className="label">Name</label>
            <input
              className="input is-expanded"
              value={name}
              onChange={handleNameChange}
            />
          </div>
        </div>
      </form>
    </div>
  );
}

export default CarForm;
