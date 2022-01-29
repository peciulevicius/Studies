import React, { useState } from "react";
import { calculateWinner4x4 } from "../../helpers";
import Board4x4 from "../board/Board4x4.component";

import "./Game.styles.scss";

const Game4x4 = () => {
  const [history, setHistory] = useState([Array(16).fill(null)]);
  const [stepNumber, setStepNumber] = useState(0);
  const [xIsNext, setXIsNext] = useState(true);
  const winInfo = calculateWinner4x4(history[stepNumber]);
  const winner = winInfo.winner;

  let status;
  if (winner) {
    status = "Winner: " + winner;
  } else {
    if (winInfo.isDraw) {
      status = "Draw";
    } else {
      status = "Next player: " + (xIsNext ? "X" : "O");
    }
  }

  const handleClick = (i) => {
    const timeInHistory = history.slice(0, stepNumber + 1);
    const current = timeInHistory[stepNumber];
    const squares = [...current];

    if (winner || squares[i]) return;
    squares[i] = xIsNext ? "X" : "O";
    setHistory([...timeInHistory, squares]);
    setStepNumber(timeInHistory.length);
    setXIsNext(!xIsNext);
  };

  const jumpTo = (step) => {
    setStepNumber(step);
    setXIsNext(step % 2 === 0);
  };

  const renderMoves = () => {
    return history.map((_step, move) => {
      const destination = move ? `Go to move #${move}` : "Go to start";
      return (
        <ul className="ul-element" key={move}>
          <button className="game-button" onClick={() => jumpTo(move)}>
            {destination}
          </button>
        </ul>
      );
    });
  };

  return (
    <>
      <Board4x4 squares={history[stepNumber]} onClick={handleClick} />
      <div className="game4x4">
        {status}
        {renderMoves()}
      </div>
    </>
  );
};

export default Game4x4;
