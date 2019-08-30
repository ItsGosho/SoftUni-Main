import 'isomorphic-fetch';
import Dropbox from 'dropbox';

const ACCESS_TOKEN = 'k-aFCKNYmaAAAAAAAAAAWPI477TB18AoO8Zwyf8MKG0HNN0j_g2EnF178dU8GliX';

export default new Dropbox.Dropbox({accessToken: ACCESS_TOKEN});