import React from 'react'
import {withStyles} from '@material-ui/core/styles'
import PropTypes from 'prop-types'
import Grid from '@material-ui/core/Grid'
import Button from '@material-ui/core/Button'
import Paper from '@material-ui/core/Paper'
import { Field, reduxForm} from 'redux-form'
import TextField from '@material-ui/core/TextField'
import {connect} from 'react-redux'
import {addUser} from './action'

class SignUpForm extends React.Component{
    constructor(props){
        super(props)
        this.state={
                firstName: "",
                lastName: "",
                email: "",
                password: "",
                phone: "",
                address:"",
                firstNameValid: true,
                lastNameValid: true,
                emailValid: true,
                passwordvalid: true,
                phoneValid: true,
                addressValid: true,
                firstNameLabel: "First Name",
                lastNameLabel: "Last Name",
                emailLabel: "Email",
                passwordLabel: "Password",
                phoneLabel: "Phone",
                addressLabel: "Address"

            
        }
    }
        handlefirstName(event){
            
            this.setState({
                firstName: event.target.value
            })
            this.validateFirstName()
        }
        handleLastName(event){
            this.setState({
                lastName: event.target.value
            })
            this.validateLastName()
        }
        handleEmail(event){
            this.setState({
                email: event.target.value
            })
        }
        handlePassword(event){
            this.setState({
                password: event.target.value
            })
            this.validatePassword()
        }
        handlePhone(event){
            this.setState({
                phone: event.target.value
            })
        }
        handleAddress(event){
            this.setState({
                address: event.target.value
            })
        }
        validateFirstName(){
            const {firstName} = this.state
            if(firstName.length > 4){
                this.setState({
                    firstNameValid: true,
                    firstNameLabel: "First Name"
                })
            }
            else{
                this.setState({
                    firstNameValid: false,
                    firstNameLabel: "Invalid"
                })
            }
        }
        validateLastName(){
            const {lastName} = this.state
            if(lastName.length > 4){
                this.setState({
                    lastNameValid: true,
                    lastNameLabel: "Last Name"
                })
            }
            else{
                this.setState({
                    lastNameValid: false,
                    lastNameLabel: "Invalid"
                })
            }
        }
        validateEmail(){
            const {email} = this.state
            if(email.length > 4){
                this.setState({
                    emailValid: true,
                    emailLabel: "Email"
                })
            }
            else{
                this.setState({
                    emailValid: false,
                    emailLabel: "Invalid"
                })
            }
        }
        validatePassword(){
            const {password} = this.state
            if(password.length === 0){
                this.setState({
                    passwordvalid: false,
                    passwordLabel: "Must fill the password"
                })
            }
            if(password.length > 7){
                this.setState({
                    passwordvalid: true,
                    passwordLabel: "Password"
                })
            }
           
            else{
                this.setState({
                    passwordvalid: false,
                    passwordLabel: "Password should be longer"
                })
            }
        }
       
       
        handleSubmit(event){
            console.log(this.state)
            const userObject = this.state
            this.props.dispatch(addUser(userObject))
            event.preventDefault()


        }

        render(){
            return(
                <div style={{marginTop: 40}}>
                    <Grid container spacing = {24}>
                    <Grid item xs={4}>
                    </Grid>
                    <Grid item xs={3}>
                    <Paper elevation={6} square>
                    <form onSubmit={this.handleSubmit.bind(this)} style={{marginLeft:20,marginRight: 20,marginTop: 20,marginBottom: 40}}>
                    <div>
                    <TextField
                            name="firstName"
                            margin="dense"
                            id="firstName"
                            type="text"
                            error={!this.state.firstNameValid}
                            placeholder={this.state.firstName}
                            label= {this.state.firstNameLabel}
                            onChange={this.handlefirstName.bind(this)}
                            onBlur = {this.validateFirstName.bind(this)}
                            
                            fullWidth
                        />
                        </div>
                        <div>
                    <TextField
                            error={!this.state.lastNameValid}
                            margin="dense"
                            id="lastName"
                            type="text"
                            placeholder={this.state.lastName}
                            label={this.state.lastNameLabel}
                            onChange={this.handleLastName.bind(this)}
                            onBlur = {this.validateLastName.bind(this)}
                            fullWidth
                          
                        />
                         </div>
                        <div>
                    <TextField
                            autoFocus
                            margin="dense"
                            id="email"
                            type="email"
                            placeholder="Email"
                            onChange={this.handleEmail.bind(this)}
                            fullWidth
                        />
                         </div>
                        <div>
                    <TextField
                           name="password"
                           margin="dense"
                           id="password"
                           type="password"
                           error={!this.state.passwordvalid}
                           placeholder={this.state.password}
                           label= {this.state.passwordLabel}
                           onChange={this.handlePassword.bind(this)}
                           onBlur = {this.validatePassword.bind(this)}
                           
                           fullWidth
                        />
                         </div>
                        <div>
                     <TextField
                            autoFocus
                            margin="dense"
                            id="phone"
                            type="text"
                            placeholder="Phone"
                            onChange={this.handlePhone.bind(this)}
                            fullWidth
                        />
                         </div>
                        <div>
                         <TextField
                            autoFocus
                            margin="dense"
                            id="address"
                            type="text"
                            placeholder="Address"
                            onChange={this.handleAddress.bind(this)}
                            fullWidth
                        />
                         </div>
                    

                    <Button type="submit">
                    Submit
                    </Button>


                    </form> 
                    </Paper>
                    </Grid>
                    <Grid item xs={5}>
                    </Grid>
                    </Grid>  
                </div>

            )
        }
    
}
function mapStateToProps(state){
    return {
        newUsers: state.newUsers
    }
}
export default connect(mapStateToProps)(SignUpForm);