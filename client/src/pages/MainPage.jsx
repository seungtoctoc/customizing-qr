import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getMessage } from '../apis/apis';

import Bottom from '../components/bottom';
import MainView from '../components/MainView';

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
      <MainView message={message} />
      <Bottom />
    </div>
  );
}
