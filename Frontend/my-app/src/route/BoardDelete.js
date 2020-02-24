import React from 'react';
import axios from 'axios';

class BoardDelete extends React.Component{
    deleteItem = async () =>{
        const{location} = this.props;
        await axios.delete(`http://localhost:8080/boardlist/${location.state.no}`);
    }

    render(){
        this.deleteItem();
        return <div>Hi</div>;
    }
}

export default BoardDelete;