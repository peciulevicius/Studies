import React from "react";
import { Link } from "react-router-dom";

import './ChooseGame.styles.scss';

const ChooseGame = () => (
  <div className="button-container">
    <Link to="/">
        <button className="button">3x3</button>
    </Link>
    <Link to="/4x4">
        <button className="button">4x4</button>
    </Link>
    <Link to="/5x5">
        <button className="button">5x5</button>
    </Link>
  </div>
);

export default ChooseGame;
