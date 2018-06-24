import React from 'react'
import HomeBar from '../components/appBar/index'
import Footer from '../components/footer/index'
import Description from '../components/Description/index'
import Renderer from '../components/newUserDetails'
class Home extends React.Component
{
    render(){
        return (
            <div>
               
            <HomeBar/>
            <Description/>
            <Renderer/>
            <Footer/>
            </div>
            )
}
}
export default Home;