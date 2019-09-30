import {registerReducer} from "./authentication.reducers";
import {testReducers} from "./test.reducer";

export default {
  register: registerReducer,
  test: testReducers,
}
