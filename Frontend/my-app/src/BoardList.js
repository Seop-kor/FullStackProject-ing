import React from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

function BoardList({ no, title, name, writedate, readcount, content, pass }) {
    return (
        <tbody>
            <tr>
                <td>{no}</td>
                <td>
                    <Link to={{
                        pathname: `/board/${no}`,
                        state: {
                            no,
                            title,
                            name,
                            pass,
                            content
                        }
                    }}>
                        {title}
                    </Link>
                </td>
                <td>
                    {name}
                </td>
                <td>{writedate}</td>
                <td>{readcount}</td>
            </tr>
        </tbody>
    );
}

BoardList.propTypes = {
    no: PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    name: PropTypes.string.isRequired,
    writedate: PropTypes.string.isRequired,
    readcount: PropTypes.number.isRequired
}

export default BoardList;