import React from 'react'
import Grid from '@material-ui/core/Grid'
import Paper from '@material-ui/core/Paper'
export default function(){
    return <div>
        <Paper position="sticky" color="secondary" square elevation={4}>
        <Grid container spacing= {24}>
            <Grid item xs={4}>
                <h4>Contact 01-233234</h4>
            </Grid>
            <Grid item xs={4}>
                <h4>Address Patan, Lalitpur, Nepal</h4>
            </Grid>
        </Grid>
        </Paper>
       

    </div>
}