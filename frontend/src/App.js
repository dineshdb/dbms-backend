import React, { Component } from 'react';
import { withStyles } from '@material-ui/core/styles';
import './App.css';
import { CssBaseline } from '@material-ui/core';
import MenuBar from './MenuBar';

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
     <React.Fragment>
       <CssBaseline />
        <MenuBar/>
    </React.Fragment> 
    );
  }
}

export default withStyles(styles)(App);