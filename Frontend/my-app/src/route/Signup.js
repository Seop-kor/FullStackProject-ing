import React from 'react';
import axios from 'axios';
import bcrypt from 'bcryptjs';

class Signup extends React.Component {
    state = {
        idcheck: false
    }

    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    check_id = async () => {
        const {id} = this.state;
        const {data} = await axios.get(`http://localhost:8080/member/?mid=${id}`);
        if(data){
            alert("아이디가 중복입니다.");
            document.getElementById('id').value="";
        }else{
            alert("중복되지않습니다.");
            this.setState({idcheck: true});
        }
    }

    check_pass = () => {
        const { pass, pass_check } = this.state;
        if (pass === pass_check) {
            return true;
        } else {
            alert("패스워드가 일치하지않습니다.");
            return false;
        }
    }

    signup = (e) => {
        e.preventDefault();
        const {idcheck} = this.state;
        const {history} = this.props;
        if(!idcheck){
            alert("아이디 중복검사를 해주세요");
            return;
        }
        if (this.check_pass()) {
            var { pass } = this.state;
        }else{
            return ;
        }

        bcrypt.genSalt(8,(err,salt) => {
            bcrypt.hash(pass,salt, (error,hash) => {
                axios.post("http://localhost:8080/signup",{
                    mid: this.state.id.toString(),
                    mpass: hash.toString(),
                    mpass_check: hash.toString(),
                    mname: this.state.name.toString(),
                    salt: salt
                }).then(history.goBack());
            });
        });
    
        /*
        crypto.randomBytes(64, (err, buf) => {
            crypto.pbkdf2(pass, buf.toString('base64'), 100000, 64, 'sha512', async (err, key) => {
                await axios.post(`http://localhost:8080/signup`,{
                    mid: this.state.id.toString(),
                    mpass: key.toString('base64'),
                    mpass_check: key.toString('base64'),
                    mname: this.state.name.toString(),
                    salt: buf.toString('base64')
                }).then(history.goBack());
            });
        });
        */
    }


    render() {
        return (
            <form method="post" onSubmit={this.signup}>
                <table>
                    <tbody>
                        <tr className="row">
                            <td className="col"><label htmlFor="id">ID</label><input type="text" name="id" id="id" className="form-control" onChange={this.handleChange} /></td>
                            <td><button type="button" className="btn btn-primary" id="check" onClick={this.check_id}>중복체크</button></td>
                        </tr>
                        <tr className="row">
                            <td className="col"><label htmlFor="pass">PassWord</label><input type="password" name="pass" id="pass" className="form-control" onChange={this.handleChange} /></td>
                        </tr>
                        <tr className="row">
                            <td className="col"><label htmlFor="pass_check">PassWord Check</label><input type="password" name="pass_check" id="pass_check" className="form-control" onChange={this.handleChange} /></td>
                        </tr>
                        <tr className="row">
                            <td className="col"><label htmlFor="name">Name</label><input type="text" name="name" id="name" className="form-control" onChange={this.handleChange} /></td>
                        </tr>
                        <tr className="row">
                            <td className="col"><input type="submit" value="회원가입" className="btn bg-success" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        );
    }
}

export default Signup;