import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getMessage } from '../apis/apis';

export default function MainPage() {
  const { uuid } = useParams();
  const [message, setMessage] = useState('');

  useEffect(() => {
    getMessage(uuid).then((data) => {
      if (data.success === true) {
        setMessage(data.response.message);
        return;
      }
      setMessage('check uuid');
    });
  }, []);

  return (
    <div>
      <div className='w-screen p-8' style={{ height: '90vh' }}>
        <p className='text-3xl'>{message}</p>
      </div>
      <div
        className='text-sm text-center bg-gray-200'
        style={{ height: '10vh' }}
      >
        devlab
      </div>
    </div>
  );
}
