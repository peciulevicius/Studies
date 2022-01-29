import React from "react";
import Square from "../square/Square.component";

import './Board.styles.scss';

const Board5x5 = ({ squares, onClick }) => (
  <div className="board5x5">
    {squares.map((square, i) => ( // loop over the squares from props (array for playing field)
      <Square key={i} value={square} onClick={() => onClick(i)} />
    ))}
  </div>
);

export default Board5x5;
