import React from "react";
import { shallow, mount } from "enzyme";
import Game4x4 from "../../../components/game/Game4x4.component";
import "../../../setupTests";

describe("Game4x4 testing", () => {
  it("Renders without crashing", () => {
    shallow(<Game4x4 />);
  });

  it("Testing game logic and outputing a winner of O", () => {
    const wrapper = mount(<Game4x4 />);
    const firstPlayer = wrapper.find("div.game4x4").children().first().text();
    expect(firstPlayer).toEqual("Next player: X");

    //player X
    const turn1 = wrapper.find("button.square").at(0);
    turn1.simulate("click");
    const secondPlayer = wrapper.find("div.game4x4").children().first().text();
    expect(secondPlayer).toEqual("Next player: O");

    //player O
    const turn2 = wrapper.find("button.square").at(3);
    turn2.simulate("click");
    //player X
    const turn3 = wrapper.find("button.square").at(2);
    turn3.simulate("click");
    //player O
    const turn4 = wrapper.find("button.square").at(6);
    turn4.simulate("click");
    //player X
    const turn5 = wrapper.find("button.square").at(7);
    turn5.simulate("click");
    //playerO
    const turn6 = wrapper.find("button.square").at(9);
    turn6.simulate("click");

    const winner = wrapper.find("div.game4x4").children().first().text();
    expect(winner).toEqual("Winner: O");
  });
});
