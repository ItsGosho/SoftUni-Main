import 'isomorphic-fetch';
import Dropbox from 'dropbox';


const ACCESS_TOKEN = '';

export default new Dropbox.Dropbox({accessToken: ACCESS_TOKEN});