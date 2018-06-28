import React from 'react'
import HomeBar from '../components/appBar/index'
import Description from '../components/Description/index'
import Footer from '../components/footer/index'
class Home extends React.Component
{
    
    render(){
        return (
            <div>
               
            <HomeBar/>
            <Description/>
            <Footer/>
            </div>
            )
}
}
export default Home;