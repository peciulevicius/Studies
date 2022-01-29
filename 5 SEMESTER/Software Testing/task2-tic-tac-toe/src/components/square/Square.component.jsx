import React from "react";

import "./Square.styles.scss";

// value is X or O // onClick changes value (X, O)
const Square = ({ value, onClick }) => {
  const style = value ? `square ${value}` : `square`;
  return(
  <button className={style} onClick={onClick}>
    {value}
  </button>
  );
};

export default Square;
