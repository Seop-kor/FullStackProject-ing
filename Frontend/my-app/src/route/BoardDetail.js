import React from 'react';
import {Link} from 'react-router-dom';

class BoardDetail extends React.Component{
    componentDidMount(){
        const{location, history} = this.props;
        if(location.state === undefined){
            history.push("/board");
        }
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
                        <td><Link to={
                            {
                                pathname: `/boardDelete/${location.state.no}`,
                                state: {
                                    no: location.state.no
                                }
                            }
                        } className="btn btn-primary">삭제</Link></td>
                    </tr>
                </tbody>
            </table>
        );
    }

}

export default BoardDetail;