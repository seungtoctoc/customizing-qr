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
      }
    });
  }, []);

  return (
    <div>
      MainPage
      <p className='text-3xl font-bold'>current uuid: {uuid}</p>
      <p>message: {message}</p>
    </div>
  );
}
