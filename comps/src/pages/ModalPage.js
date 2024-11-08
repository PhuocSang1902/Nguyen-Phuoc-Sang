import { useState } from 'react';
import Modal from '../components/Modal';
import Button from '../components/Button';

function ModalPage() {
  const [showModal, setShowModal] = useState(false);

  const handleClick = () => {
    setShowModal(true);
  };

  const handleClose = () => {
    setShowModal(false);
  };

  const actionBar = (
    <div>
      <Button primary onClick={handleClose}>
        I accept
      </Button>
    </div>
  );

  const modal = (
    <Modal onClose={handleClose} actionBar={actionBar}>
      <p>Here is an important agreement for you to accept</p>
    </Modal>
  );

  return (
    <div>
      <Button onClick={handleClick} primary>
        Open modal
      </Button>
      {showModal && modal}
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
      <p>
        dkflajlsdkfslfdsafdsafdsafds dkflajlsdkfslfdsafdsafdsafdssdfas
        dkflajlsdkfslfdsafdsafdsafds{' '}
      </p>
    </div>
  );
}

export default ModalPage;
