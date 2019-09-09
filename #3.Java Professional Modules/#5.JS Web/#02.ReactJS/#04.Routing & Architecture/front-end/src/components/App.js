import React, {Component,Fragment} from 'react';
import {Route, Router, Link, Switch, BrowserRouter} from 'react-router-dom';
import RoutingURLs from "../constants/routing.url.constants";
import './App.css';

import Home from './Home/Home';
import Register from './Register/Register';
import Login from './Login/Login';
import Create from './Create/Create';
import Navigation from "./Navigation/Navigation";

class App extends Component {

    render() {
        return (
            <div className="App">
                <BrowserRouter>
                    <Fragment>
                        <Navigation role="Guest" username="Joreto"/>
                        <Switch>
                            <Route path={RoutingURLs.HOME} component={Home} exact/>
                            <Route path={RoutingURLs.AUTHENTICATION.LOGIN} component={Login} exact/>
                            <Route path={RoutingURLs.AUTHENTICATION.REGISTER} component={Register} exact/>
                            <Route path={RoutingURLs.MOVIE.CREATE} component={Create} exact/>
                        </Switch>
                    </Fragment>
                </BrowserRouter>
            </div>
        );
    }
}

export default App;
