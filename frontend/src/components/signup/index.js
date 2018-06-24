import React from 'react'
import {withStyles} from '@material-ui/core/styles'
import PropTypes from 'prop-types'
import Grid from '@material-ui/core/Grid'
import Button from '@material-ui/core/Button'
import Paper from '@material-ui/core/Paper'
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
                passwordValid: true,
                phoneValid: true,
                addressValid: true,
                firstNameLabel: "First Name",
                lastNameLabel: "Last Name",
                emailLabel: "Email",
                passwordLabel: "Password",
                phoneLabel: "Phone",
                addressLabel: "Address",
                submitValid: false

            
        }
    }
        validateSubmit(){
     
            const {firstNameValid,lastNameValid,emailValid,passwordValid,phoneValid,addressValid} = this.state
            return !(firstNameValid && lastNameValid && emailValid && passwordValid && phoneValid && addressValid)
            
             
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
            this.validateEmail()
           
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
            this.validatePhone()
            
        }
        handleAddress(event){
            this.setState({
                address: event.target.value
            })
            this.validateAddress()
            
        }
        validateFirstName(){
            const {firstName} = this.state
            if(firstName.length > 0){
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
            if(lastName.length > 0){
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
            var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            if(!re.test(String(email).toLowerCase())){
                this.setState({
                    emailValid: false,
                    emailLabel: "Invalid Email"
                })
            }
            else{
                this.setState({
                    emailValid: true,
                    emailLabel: "Email"
                })
            }
        }
            
        validatePassword(){
            const {password} = this.state
            if(password.length > 7){
                this.setState({
                    passwordValid: true,
                    passwordLabel: "Password"
                })
            }
           
            else{
                this.setState({
                    passwordValid: false,
                    passwordLabel: "Invalid Password"
                })
            }
        }
        validatePhone(){
            const {phone} = this.state
            if(phone.length === 10 ){
                this.setState({
                    phoneValid: true,
                    phoneLabel: "Phone"
                    
                })
            }
            else{
                this.setState({
                    phoneValid: false,
                    phoneLabel: "Invalid Phone No"
                })
            }
        }
        validateAddress(){
            const {address} = this.state
            if(address.length > 0){
                this.setState({
                    addressValid: true,
                    addressLabel: "Address"
                    
                })
            }
            else{
                this.setState({
                    addressValid: false,
                    addressLabel: "Invalid Address"
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
                    <Grid item xs={5}>
                    <Paper elevation={6} square>
                    <form onSubmit={this.handleSubmit.bind(this)} style={{marginLeft:20,marginRight: 20,marginTop: 20,marginBottom: 20}}>
                    <div>
                    <TextField
                            name="firstName"
                            margin="dense"
                            id="firstName"
                            type="text"
                            error={!this.state.firstNameValid}
                            placeholder="First Name"
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
                            placeholder="Last Name"
                            label={this.state.lastNameLabel}
                            onChange={this.handleLastName.bind(this)}
                            onBlur = {this.validateLastName.bind(this)}
                            fullWidth
                          
                        />
                         </div>
                        <div>
                    <TextField
                            error={!this.state.emailValid}
                            margin="dense"
                            id="email"
                            type="email"
                            placeholder="Email"
                            label={this.state.emailLabel}
                            onChange={this.handleEmail.bind(this)}
                            onBlur ={this.validateEmail.bind(this)}
                            
                            fullWidth
                        />
                         </div>
                        <div>
                    <TextField
                        error={!this.state.passwordValid}
                           name="password"
                           margin="dense"
                           id="password"
                           type="password"
                          
                           placeholder="Password"
                           label= {this.state.passwordLabel}
                           onChange={this.handlePassword.bind(this)}
                           onBlur = {this.validatePassword.bind(this)}
                           
                           fullWidth
                        />
                         </div>
                        <div>
                     <TextField
                            error={!this.state.phoneValid}
                            name="phone"
                            margin="dense"
                            id="phone"
                            type="text"
                            placeholder="Phone"
                            label={this.state.phoneLabel}
                            onChange={this.handlePhone.bind(this)}
                            onBlur= {this.validatePhone.bind(this)}
                            
                            fullWidth
                        />
                         </div>
                        <div>
                         <TextField
                            error={!this.state.addressValid}
                            margin="dense"
                            name="address"
                            id="address"
                            type="text"
                            placeholder="Address"
                            label={this.state.addressLabel}
                            onChange={this.handleAddress.bind(this)}
                            onBlur={this.validateAddress.bind(this)}
                            fullWidth
                        />
                         </div>
                    
                    <Grid container spacing={24} style={{marginTop: 10}}
                        >
                        <Grid item xs={9}>
                        </Grid>
                        <Button 
                        disabled = {this.validateSubmit()}
                        variant = "contained" 
                        type="submit" 
                        color="inherit" 
        
                        >
                        Submit
                        </Button>

                    </Grid>
                
                    </form> 
                    </Paper>
                    </Grid>
                    <Grid item xs={3}>
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