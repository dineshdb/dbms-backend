import React, { Component } from 'react';
import { withStyles } from '@material-ui/core/styles';
import './App.css';
import { Switch, Route, Link } from 'react-router-dom'
import MenuBar from './MenuBar';
import Event from './views/Event';
import AdminDash from './views/AdminDash';
import Home from './views/Home';
import Signup from './views/Signup'
import NotFound from './views/404'

const styles = {
  root: {
    flexGrow: 1,
  },
  flex: {
    flex: 1,
  },
  menuButton: {
    marginLeft: -12,
    marginRight: 20,
  },
};


class App extends Component {
  render() {
    const { classes } = this.props;
    return (
      <div>
        <MenuBar />
        <main>
          <Switch>
            <Route exact path='/' component={Home} />
            <Route path='/event' component={Event} />
            <Route path='/admin' component={AdminDash} />
            <Route path='/signup' component={Signup} />
            <Route component={NotFound} />
          </Switch>
        </main>
      </div>
    );
  }
}

export default withStyles(styles)(App);