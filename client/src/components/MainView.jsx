import React from 'react';

export default function MainView(props) {
  const message = props.message;

  return <div className='w-screen h-screen bg-gray-200 p-10'>{message}</div>;
}
