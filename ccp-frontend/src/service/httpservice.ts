import axios from "axios";

//axios.defaults.baseURL = 'https://api.example.com';
//axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

export default axios.create({
  baseURL: "http://localhost:8080/api"
});