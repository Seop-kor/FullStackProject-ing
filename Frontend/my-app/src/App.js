import React from 'react';
import { BrowserRouter, Route } from 'react-router-dom';
import Home from './route/Home';
import Board from './route/Board';
import Product from './route/Product';
import Information from './route/Information';
import Navigation from './Navigation/Navigation';
import Detail from './route/Detail';
import BoardDetail from './route/BoardDetail';
import Login from './route/Login';
import Signup from './route/Signup';
import BoardWrite from './route/BoardWrite';


function App() {
  return (
    <>
      <BrowserRouter>
        <div>
          <nav className="navbar navbar-expand-md bg-primary navbar-light" id="navbarcontainer">
            <Navigation />
          </nav>
        </div>
        <div className="container">
          <Route path="/" exact={true} component={Home} />
          <Route path="/info" component={Information} />
          <Route path="/product" exact={true} component={Product} />
          <Route path="/product/:num" component={Detail} />
          <Route path="/board" exact={true} component={Board} />
          <Route path="/board/:no" component={BoardDetail} />
          <Route path="/login" component={Login} />
          <Route path="/signup" component={Signup} />
          <Route path="/write" component={BoardWrite} />
        </div>
      </BrowserRouter>
    </>
  );
}

export default App;