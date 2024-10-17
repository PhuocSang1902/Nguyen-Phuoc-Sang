import Button from './Button';
import { GoBell } from 'react-icons/go';

function App() {
  const handleClick = () => {
    console.log('Click');
  };
  return (
    <div>
      <div>
        <Button success rounded outline onClick={handleClick}>
          <GoBell />
          Click
        </Button>
      </div>
    </div>
  );
}

export default App;
