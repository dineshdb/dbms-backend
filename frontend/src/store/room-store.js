import {createStore} from 'redux'

const initialState = {

}
let store = createStore(reducer)

function reducer(state = initialState, action){
    switch(action.type){

    }
}

// actions 
export const addRoom = () => {
    return {
        type : 'ADD_ROOM'
    }
}

export const removeRoom = () => {
    return {
        type : 'REMOVE_ROOM'
    }
}
