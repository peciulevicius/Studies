import React, { useState } from "react";
import { calculateWinner3x3 } from "../../helpers";
import Board3x3 from "../board/Board3x3.component";

import "./Game.styles.scss";

const Game3x3 = () => {
  const [history, setHistory] = useState([Array(9).fill(null)]); //step history state
  const [stepNumber, setStepNumber] = useState(0); //step number state
  const [xIsNext, setXIsNext] = useState(true); //X is next history
  const winInfo = calculateWinner3x3(history[stepNumber]);
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
    const timeInHistory = history.slice(0, stepNumber + 1); //gives us all the moves up to the step we are currently at
    const current = timeInHistory[stepNumber]; //gives us current state from timeInHistory (shows current step)
    const squares = [...current]; //it will copy current into a const called squares

    // if user clicks on occupied square or if game is won, return
    if (winner || squares[i]) return;
    squares[i] = xIsNext ? "X" : "O"; //put an X or an O in the clicked square
    setHistory([...timeInHistory, squares]); //spreading old state because we want to keep old state, and adding squares we're creating new move and adding to history array
    setStepNumber(timeInHistory.length); //changing step number (gives us current step number)
    setXIsNext(!xIsNext); //gives us other value (true => false, false => true)
  };

  const jumpTo = (step) => {
    setStepNumber(step);
    setXIsNext(step % 2 === 0); //returns true to all even numbers
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
      <Board3x3 squares={history[stepNumber]} onClick={handleClick} />
      <div className="game3x3">
        {status}
        {renderMoves()}
      </div>
    </>
  );
};

export default Game3x3;
