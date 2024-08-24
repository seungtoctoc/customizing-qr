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
