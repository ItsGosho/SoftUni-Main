import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';
import {Provider} from 'react-redux'
import {createStore, applyMiddleware, combineReducers, compose} from 'redux'
import thunk from 'redux-thunk'
import reducers from './redux/reducers'
import createLogger from 'redux-logger'
import 'react-notifications-component/dist/theme.css'

const store = createStore(
    combineReducers(reducers),
    compose(applyMiddleware(thunk, createLogger), window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__())
);


ReactDOM.render(
    <Provider store={store}>
        <App/>
    </Provider>
    , document.getElementById('root'));
