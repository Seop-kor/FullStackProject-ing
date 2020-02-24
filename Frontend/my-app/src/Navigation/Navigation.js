import React from "react";
import { Link } from "react-router-dom";

function Navigation() {
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
                    <Link to="/login" className="text-light">로그인</Link>
                    &nbsp;&nbsp;
                        <Link to="/signup" className="text-light">회원가입</Link>
                </div>
            </div>
        </>
    );
}

export default Navigation;
