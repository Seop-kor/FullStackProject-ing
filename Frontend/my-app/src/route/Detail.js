import React from 'react';

class Detail extends React.Component{

    constructor(props){
        super(props);
        if(!window.localStorage.getItem('token')){
            this.props.history.goBack();
        }
    }

    componentDidMount(){
        const{location, history} = this.props;
        if(location.state === undefined){
            history.push("/");
        }
    }

    render(){
        const{location} = this.props;
        return (<div className="container jumbotron my-4">
            <img src={location.state.imgaddr} alt={location.state.title}></img>
            <p className="lead">{location.state.content}</p>
        </div>);
    }
}

export default Detail;