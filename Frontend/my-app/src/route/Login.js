import React from 'react';
import axios from 'axios';
import crypto from 'crypto';

class Login extends React.Component{
    state={

    }

    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    selmember = async (e) => {
        e.preventDefault();
        const {history} = this.props;
        const {id, pass} = this.state;
        if(id === undefined && pass === undefined){
            return;
        }
        await axios.get(`http://localhost:8080/login/${id}`).then((data,error) => {
            crypto.pbkdf2(pass, data.data[1], 100000, 64, 'sha512', (err,key) =>{
                if(key.toString('base64') === data.data[0]){
                    window.sessionStorage.setItem('id',id);
                    window.sessionStorage.setItem('name',data.data[2]);
                    history.push({
                        pathname: "/"
                    });
                    window.location.reload();
                }else{
                    alert("아이디나 패스워드가 일치하지않습니다.");
                }
            });
        });
        
    }

    render(){
        return (
            <form className="container" method="post" onSubmit={this.selmember}>
                <table className="justify-content-center">
                    <tbody>
                        <tr className="row">
                            <td className="col"><label htmlFor="id">ID</label><input type="text" name="id" id="id" className="form-control" onChange={this.handleChange} /></td>
                        </tr>
                        <tr className="row">
                            <td className="col"><label htmlFor="pass">PassWord</label><input type="password" name="pass" id="pass" className="form-control" onChange={this.handleChange} /></td>
                        </tr>
                        <tr className="row">
                            <td className="col"><input type="submit" value="로그인" className="btn bg-success" onChange={this.handleChange} /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        );
    }
}

export default Login;