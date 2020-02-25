import React from 'react';
import axios from 'axios';
import crypto from 'crypto';

class BoardWrite extends React.Component{

    writeboard = (e) => {
        e.preventDefault();
        const title = document.getElementById('title').value;
        const content = document.getElementById('content').value;
        const pass = document.getElementById('pass').value;
        const {history} = this.props;
        crypto.randomBytes(64, (err, buf) => {
            crypto.pbkdf2(pass, buf.toString('base64'), 100000, 64, 'sha512', async (err,key) => {
                await axios.post("http://localhost:8080/board", {
                    title: title,
                    content: content,
                    name: window.sessionStorage.getItem('name'),
                    pass: key.toString('base64'),
                    salt: buf.toString('base64')
                }).then(history.goBack());
            });
        });
    }

    render(){
        return (
            <div className="justify-content-end">
                <form method="post" onSubmit={this.writeboard}>
                    <table className="table table-strip">
                        <tbody>
                            <tr>
                                <th>제목</th>
                                <td><label htmlFor="title"><input type="text" placeholder="제목" name="title" id="title"></input></label></td>
                            </tr>
                            <tr>
                                <th>내용</th>
                                <td><label htmlFor="content"><textarea placeholder="내용" name="content" id="content" rows="20" cols="100"></textarea></label></td>
                            </tr>
                            <tr>
                                <th>비밀번호</th>
                                <td><label htmlFor="pass"><input type="password" placeholder="비밀번호" name="pass" id="pass"></input></label></td>
                            </tr>
                            <tr>
                                <td><button type="submit" className="btn btn-success">작성</button></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        );
    }
}


export default BoardWrite;