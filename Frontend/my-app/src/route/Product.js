import React from 'react';
import axios from 'axios';
import '../css/ProductCard.css';
import ProductCard from '../ProductCard';

class Product extends React.Component {
    state = {
        product: []
    };

    getProduct = async () => {
        const {
            data: { data }
        } = await axios.get("http://localhost:8080/product");
        this.setState({ product: data });
    }

    componentDidMount() {
        this.getProduct();
    }

    render() {
        const { product } = this.state;
        return <div className="cardbody container">
            <header className="jumbotron my-4">
                <h1 className="display-3">Spring Project를 진행중입니다!</h1>
                <p className="lead">이 페이지는 관리자만이 업로드 할 수있습니다.</p>
            </header>
            <div className="row text-center">
                {product.map(function (prod) {
                    return <ProductCard num={prod.num} imgaddr={prod.imgaddr} content={prod.content} title={prod.title} key={prod.num}/>;
                })}
            </div>
        </div>;
    }
}

export default Product;