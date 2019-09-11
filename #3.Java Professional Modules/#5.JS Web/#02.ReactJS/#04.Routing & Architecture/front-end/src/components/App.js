import React, {Component, Fragment} from 'react';
import {Route, Router, Link, Switch, BrowserRouter} from 'react-router-dom';
import RoutingURLs from "../constants/routing.url.constants";
import './App.css';

import Home from './Home/Home';
import Register from './Register/Register';
import Login from './Login/Login';
import Create from './Movie/Create';
import Navigation from "./Navigation/Navigation";

class App extends Component {

    render() {
        return (
            <div className="App">
                <BrowserRouter>
                    <Fragment>
                        <Navigation role="Guest" username="Joreto"/>
                        <Switch>
                            <Route exact path={RoutingURLs.HOME} component={() => <Home role="Guest"/>}/>
                            <Route exact path={RoutingURLs.AUTHENTICATION.LOGIN} component={() => <Login/>}/>
                            <Route exact path={RoutingURLs.AUTHENTICATION.REGISTER} component={() => <Register/>}/>
                            <Route exact path={RoutingURLs.MOVIE.CREATE} component={() => <Create/>}/>
                        </Switch>
                    </Fragment>
                </BrowserRouter>
            </div>
        );
    }
}

export default App;
