import { useDispatch, useSelector } from 'react-redux';
import { changeCost, changeName } from '../store';

function CarForm() {
  const dispatch = useDispatch();
  const { name, cost } = useSelector((state) => {
    return { name: state.form.name, cost: state.form.cost };
  });

  const handleNameChange = (event) => {
    dispatch(changeName(event.target.value));
  };

  const handleCostChange = (event) => {
    const carCost = parseInt(event.target.value) || 0;
    dispatch(changeCost(carCost));
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

          <div className="filed">
            <label className="label">Cost</label>
            <input
              className="input is-expanded"
              value={cost}
              onChange={handleCostChange}
              type="number"
            />
          </div>
        </div>
      </form>
    </div>
  );
}

export default CarForm;
