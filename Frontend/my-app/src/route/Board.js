import React from 'react';
import axios from 'axios';
import BoardList from '../BoardList';

class Board extends React.Component {
    state={
        Boards: []
    }


    getBoardList = async () => {
        const {
            data: { data }
        } = await axios.get("http://localhost:8080/board");
        
        this.setState({
            Boards: data
        });
    }

    componentDidMount() {
        this.getBoardList();
    }

    checkLogin = () =>{
        const {history} = this.props;
        if(window.sessionStorage.getItem('id')){
           history.push("/write"); 
        }
    }

    render() {
        const { Boards } = this.state;
        return (
            <>
                <div>
                    <button type="button" className="btn btn-success" onClick={this.checkLogin}>글쓰기</button>
                </div>
                <div>
                    <table className="table table-hover">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>작성일자</th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                        {Boards.map(function (Board) {
                            return <BoardList no={Board.no} title={Board.title} name={Board.name} writedate={Board.writedate} readcount={Board.readcount} content={Board.content} pass={Board.pass} key={Board.no}/>
                        })}
                    </table>
                </div>
            </>
        );

    }
}

export default Board;