import React from 'react'
import { BrowserRouter as Router} from 'react-router-dom'
import Route from 'react-router-dom/Route'
import Home from './views/home'
import Login from './views/login'
import SignUp from './views/signup'
import Event from './views/event'
import NewEvent from './views/newEvent'


class App extends React.Component {
    render() {
        return (
            <Router>
                <div >
                    <Route path = "/" exact strict component={
                      Home
                    }
                    />
                    <Route path = "/login" exact strict component={
                        Login
                        }
                    />
                    <Route path = "/signup" exact strict component={
                       SignUp
                        }
                    />
                     <Route path = "/:id/newEvent" component={
                       NewEvent
                        }
                    />
                    
                </div>
            </Router>


        )
    }
}

export default App;
