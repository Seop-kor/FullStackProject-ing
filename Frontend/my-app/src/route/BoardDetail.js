import React from 'react';
import axios from 'axios';

class BoardDetail extends React.Component{
    componentDidMount(){
        const{location, history} = this.props;
        if(location.state === undefined){
            history.push("/board");
        }
    }

    deleteItem = async () =>{
        const {location, history} = this.props;
        await axios.delete(`http://localhost:8080/board/${location.state.no}`);
        history.goBack();
    }

    render(){
        const {location} = this.props;
        return (
            <table className="container justify-content-center">
                <tbody>
                    <tr>
                        <th>제목</th>
                        <td>{location.state.title}</td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td>{location.state.name}</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                    </tr>
                    <tr>
                        <td>{location.state.content}</td>
                    </tr>
                    <tr>
                        <td><button type="button" className="btn btn-primary" onClick={this.deleteItem}>삭제</button></td>
                    </tr>
                </tbody>
            </table>
        );
    }

}

export default BoardDetail;