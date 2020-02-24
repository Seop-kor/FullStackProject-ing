import React from 'react';
import PropTypes from 'prop-types';
import {Link} from 'react-router-dom';

function ProductCard({ num, imgaddr, content, title }) {
    return (
        <div className="col-lg-3 col-md-6 mb-4">
            <Link to={
                {
                    pathname: `/product/${num}`,
                    state: {
                        imgaddr,
                        content,
                        title
                    }
                }
            }>
                <div className="card h-100">
                    <img className="card-img-top" src={imgaddr} alt={title} title={title} />
                    <div className="card-body">
                        <h4 className="card-title">{title}</h4>
                        <p className="card-text">{content.slice(0, 50)}...</p>
                    </div>
                    <div className="card-footer">
                        <button className="btn btn-primary">Find</button>
                    </div>
                </div>
            </Link>
        </div>
    );
}

ProductCard.propTypes = {
    num: PropTypes.number.isRequired,
    imgaddr: PropTypes.string.isRequired,
    content: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired
}

export default ProductCard;