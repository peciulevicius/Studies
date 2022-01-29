import React, { useState } from "react";
import { calculateWinner5x5 } from "../../helpers";
import Board5x5 from "../board/Board5x5.component";

import "./Game.styles.scss";

const Game5x5 = () => {
  const [history, setHistory] = useState([Array(25).fill(null)]);
  const [stepNumber, setStepNumber] = useState(0);
  const [xIsNext, setXIsNext] = useState(true);
  const winInfo = calculateWinner5x5(history[stepNumber]);
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
      <Board5x5 squares={history[stepNumber]} onClick={handleClick} />
      <div className="game5x5">
        {status}
        {renderMoves()}
      </div>
    </>
  );
};

export default Game5x5;
