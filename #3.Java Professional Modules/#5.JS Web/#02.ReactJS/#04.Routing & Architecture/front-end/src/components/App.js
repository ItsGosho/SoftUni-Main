import React, {Component} from 'react';
import {Route, Router, Link, Switch, BrowserRouter} from 'react-router-dom';
import RoutingURLs from "../constants/routing.url.constants";
import './App.css';

import Home from './Home/Home';
import Register from './Register/Register';
import Login from './Login/Login';
import Create from './Create/Create';

class App extends Component {

    render() {
        return (
            <div className="App">
                <BrowserRouter>
                    <Switch>
                        <Route path={RoutingURLs.HOME} component={Home} exact/>
                        <Route path={RoutingURLs.AUTHENTICATION.LOGIN} component={Login} exact/>
                        <Route path={RoutingURLs.AUTHENTICATION.REGISTER} component={Register} exact/>
                        <Route path={RoutingURLs.MOVIE.CREATE} component={Create} exact/>
                    </Switch>
                </BrowserRouter>
            </div>
        );
    }
}

export default App;
