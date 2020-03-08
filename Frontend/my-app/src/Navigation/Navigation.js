import React from "react";
import { Link } from "react-router-dom";

class Navigation extends React.Component{

    constructor(props){
        super(props);
        const name = window.localStorage.getItem("name");
        if(name){
            this.state={
                login: true,
                name
            }
        }else{
            this.state={
                login: false
            }
        }
        
    }


    Logout = () =>{
        window.localStorage.clear();
        this.setState({
            login: false
        });
    }

    stat = () => {
        const {login, name} = this.state;
        if(login){
            return (
                <>
                <span>{name}님 환영합니다.</span>
                &nbsp;&nbsp;
                <span className="text-light" onClick={this.Logout}>로그아웃</span>
                </>
            );
        }else{
            return (
                <>
                <Link to="/login" className="text-light">로그인</Link>
                &nbsp;&nbsp;
                <Link to="/signup" className="text-light">회원가입</Link>
                </>
            );
        }
    }

    render(){
        return (
            <>
                <Link to="/" className="navbar-brand">Logo</Link>
                <div className="container-fluid">
                    <ul className="navbar-nav">
                        <li className="nav-item"><Link to="/info" className="nav-link">Information</Link></li>
                        <li className="nav-item"><Link to="/product" className="nav-link">Product</Link></li>
                        <li className="nav-item"><Link to="/board" className="nav-link">Board</Link></li>
                    </ul>
                    <div className="justify-content-end">
                        {this.stat()}
                    </div>
                </div>
            </>
        );
    }
}

export default Navigation;
