import React from 'react';

export default function MainView(props) {
  const message = props.message;

  return (
    <div className='w-screen h-screen bg-gray-200 p-8'>
      <p className='text-3xl'>{message}</p>
      <p className='text-xs absolute bottom-4 w-full text-center'>devlab</p>
    </div>
  );
}
