import Button from './Button';
import { GoBell } from 'react-icons/go';

function App() {
  return (
    <div>
      <div>
        <Button success rounded outline>
          <GoBell />
          Click
        </Button>
      </div>
    </div>
  );
}

export default App;
