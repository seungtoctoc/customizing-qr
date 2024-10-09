import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getMessage } from '../apis/apis';

import CheckForm from '../components/CheckForm';

export default function MainPage() {
  const { uuid } = useParams();
  const [message, setMessage] = useState('');

  const [clickCnt, setClickCnt] = useState(0);

  useEffect(() => {
    getMessage(uuid).then((data) => {
      if (data.success === true) {
        setMessage(data.response.message);
        return;
      }
      setMessage('check uuid');
    });
  }, []);

  const clickBottom = () => {
    setClickCnt((prevCnt) => prevCnt + 1);
  };

  return (
    <div>
      <div className='w-screen p-8' style={{ height: '90vh' }}>
        <p className='text-3xl'>{message}</p>
      </div>
      {clickCnt < 10 && (
        <div
          className='text-sm text-center bg-gray-200'
          style={{ height: '10vh' }}
          onClick={clickBottom}
        >
          devlab
        </div>
      )}
      {clickCnt >= 10 && <CheckForm />}
    </div>
  );
}
