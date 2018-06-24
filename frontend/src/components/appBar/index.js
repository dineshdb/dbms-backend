import React from 'react';
import PropTypes from 'prop-types';
import {withStyles} from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import {connect} from 'react-redux'
import {Link} from 'react-router-dom'
import Grid from '@material-ui/core/Grid'




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
    pad:{
        paddingTop: 10
    }
};


class HomeBar extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
           isLoggedIn: false
        }
    }


    render() {
        const {classes} = this.props;
        if(!this.state.isLoggedIn){
            return (
                <div >
                    <AppBar position="static">
                        <Toolbar>
                            <Grid container spacing = {24}>
                                <Grid item xs={1}>
                                </Grid>
                                <Grid item xs={1}>
                                <Link to="/" className={classes.pad}>
                                    <Button color="inherit">
                                    Home
                                    </Button>
                                </Link>
                                </Grid>
                                <Grid item xs={8}>
                                </Grid>
                                <Grid item xs={1}>
                                <Link to="/signup" className={classes.pad}>
                                    <Button color="inherit">
                                    SignUp
                                    </Button>
                                </Link>
                                </Grid>
                                <Grid item xs={1}>
                                <Link to="/login" className={classes.pad}>
                                    <Button color="inherit">
                                    Login
                                    </Button>
                                </Link>
                                </Grid>
                            
                                </Grid>
                        </Toolbar>
                    </AppBar>
                    


                </div>
            );
        }
        else{
           
            return (
                <div >
                    <AppBar position="static">
                        <Toolbar>
                            <Grid container spacing = {24} spacing={40}>
                                <Grid item xs={6}>
                                </Grid>
                                <Grid item xs={3}>
                                <Link to="/signup" className={classes.pad}>
                                    <Button color="inherit">
                                    SignUp
                                    </Button>
                                </Link>
                                </Grid>
                                <Grid item xs={3}>
                                <Link to="/login" className={classes.pad}>
                                    <Button color="inherit">
                                    Login
                                    </Button>
                                </Link>
                                </Grid>
                            
                                </Grid>
                        </Toolbar>
                    </AppBar>


                </div>
            );

        }
}
}
HomeBar.propTypes = {
    classes: PropTypes.object.isRequired,
};

function mapStateToProps(state){
    return {
        appBarStatus: state.appBarStatus

    }
}
export default connect(mapStateToProps)(withStyles(styles)(HomeBar))
