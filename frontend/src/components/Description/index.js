import React from 'react'
import Grid from '@material-ui/core/Grid'
import Logo from '../../assets/images/b.jpg'
export default function(){
    return <div>
            <Grid container spacing={24}>
                <Grid item xs={5}>
                <img src={Logo} style={{height: 500,width: 400}}></img>
                    </Grid>
                <Grid item xs={7}>
                    <h3>
                        Welcome to ICT !!
                    </h3>
                </Grid>
            </Grid>
                
        </div>
}