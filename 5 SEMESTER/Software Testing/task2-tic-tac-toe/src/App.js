import React from "react";
import { Switch, Route } from "react-router-dom";

import Game3x3 from "./components/game/Game3x3.component";
import Game4x4 from "./components/game/Game4x4.component";
import Game5x5 from "./components/game/Game5x5.component";
import NotFound from "./components/notFound/NotFound.component";

import ChooseGame from "./components/chooseGame/ChooseGame.component";

const App = () => {
  return (
    <div>
      <Switch>
        <Route exact path="/" component={Game3x3} />
        <Route path="/4x4" component={Game4x4} />
        <Route path="/5x5" component={Game5x5} />
        <Route component={NotFound} />
      </Switch>
      <ChooseGame />
    </div>
  );
};

export default App;
