import axios from 'axios';

export const getMessage = async (uuid) => {
  try {
    const response = await axios.get(
      import.meta.env.VITE_API_URL + '/api/user',
      {
        params: {
          uuid: uuid,
        },
      }
    );

    return response.data;
  } catch (err) {
    console.log('err: ' + err);
  }
};

export const checkUser = async (uuid, ordererId) => {
  try {
    const response = await axios.post(
      import.meta.env.VITE_API_URL + '/api/user/check',
      {
        body: {
          uuid: uuid,
          ordererId: ordererId,
        },
      }
    );

    return response.data;
  } catch (err) {
    console.log('err: ' + err);
  }
};
