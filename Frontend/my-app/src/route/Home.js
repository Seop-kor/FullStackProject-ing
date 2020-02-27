import React from 'react';
import Swiper from 'react-id-swiper'
import 'swiper/css/swiper.css';

const Home = () => {
    const params = {
        pagination: {
          el: '.swiper-pagination',
          type: 'bullets',
          clickable: true
        },
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev'
        },
        spaceBetween: 30
    }

    return(
        <Swiper {...params}>
            <img src="./img/left1.jpg" alt="left1" title="left1"></img>
            <img src="./img/right1.jpg" alt="right1" title="right1"></img>
            <img src="./img/left2.jpg" alt="left2" title="left2"></img>
            <img src="./img/right2.jpg" alt="right2" title="right2"></img>
            <img src="./img/left3.jpg" alt="left3" title="left3"></img>
            <img src="./img/right3.jpg" alt="right3" title="right3"></img>
        </Swiper>
    );
}

export default Home;
