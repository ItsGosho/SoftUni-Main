import React,{Fragment,Component} from 'react';
import './App.css';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import ReactNotification from "react-notifications-component";
import RoutingURLs from "../constants/routing.url.constants";

class App extends Component {

  render() {
    return (
        <div className="App">
            <BrowserRouter>
              <Fragment>
                <ReactNotification/>

                <Route component={() => null}/>

                <Switch>
                  <Route exact path={RoutingURLs.HOME} component={() => (<h1>Home</h1>)}/>

                  <Route exact path={RoutingURLs.OTHER.STORE} component={() => null}/>
                  <Route exact path={RoutingURLs.OTHER.CART} component={() => null}/>

                  <Route exact path={RoutingURLs.AUTHENTICATION.LOGIN} component={() => null}/>
                  <Route exact path={RoutingURLs.AUTHENTICATION.REGISTER} component={() => null}/>
                  <Route exact path={RoutingURLs.AUTHENTICATION.LOGOUT} component={() => null}/>

                  <Route exact path={RoutingURLs.BOOK.CREATE} component={() => null}/>
                  <Route exact path={RoutingURLs.BOOK.DETAILS} component={() => null}/>

                  <Route exact path={RoutingURLs.ORDER.MY} component={() => null}/>
                  <Route exact path={RoutingURLs.ORDER.PENDING} component={() => null}/>

                </Switch>

                <Route component={() => null}/>

              </Fragment>
            </BrowserRouter>
        </div>
    );
  }
}

export default App;
