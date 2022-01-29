import React from "react";
import { shallow, mount } from "enzyme";
import Game5x5 from "../../../components/game/Game5x5.component";
import "../../../setupTests";

describe("Game5x5 testing", () => {
  it("Renders without crashing", () => {
    shallow(<Game5x5 />);
  });

  it("Testing game logic and outputing a draw", () => {
    const wrapper = mount(<Game5x5 />);
    const firstPlayer = wrapper.find("div.game5x5").children().first().text();
    expect(firstPlayer).toEqual("Next player: X");

    //player X
    const turn1 = wrapper.find("button.square").at(0);
    turn1.simulate("click");
    const secondPlayer = wrapper.find("div.game5x5").children().first().text();
    expect(secondPlayer).toEqual("Next player: O");

    //player O
    const turn2 = wrapper.find("button.square").at(1);
    turn2.simulate("click");
    //player X
    const turn3 = wrapper.find("button.square").at(2);
    turn3.simulate("click");
    //player O
    const turn4 = wrapper.find("button.square").at(3);
    turn4.simulate("click");
    //player X
    const turn5 = wrapper.find("button.square").at(4);
    turn5.simulate("click");
    //player O
    const turn6 = wrapper.find("button.square").at(6);
    turn6.simulate("click");
    //player X
    const turn7 = wrapper.find("button.square").at(5);
    turn7.simulate("click");
    //player O
    const turn8 = wrapper.find("button.square").at(8);
    turn8.simulate("click");
    //player X
    const turn9 = wrapper.find("button.square").at(7);
    turn9.simulate("click");
    //player O
    const turn10 = wrapper.find("button.square").at(10);
    turn10.simulate("click");
    //player X
    const turn11 = wrapper.find("button.square").at(9);
    turn11.simulate("click");
    //player O
    const turn12 = wrapper.find("button.square").at(12);
    turn12.simulate("click");
    //player X
    const turn13 = wrapper.find("button.square").at(11);
    turn13.simulate("click");
    //player O
    const turn14 = wrapper.find("button.square").at(14);
    turn14.simulate("click");
    //player X
    const turn15 = wrapper.find("button.square").at(13);
    turn15.simulate("click");
    //player O
    const turn16 = wrapper.find("button.square").at(15);
    turn16.simulate("click");
    //player X
    const turn17 = wrapper.find("button.square").at(16);
    turn17.simulate("click");
    //player O
    const turn18 = wrapper.find("button.square").at(17);
    turn18.simulate("click");
    //player X
    const turn19 = wrapper.find("button.square").at(18);
    turn19.simulate("click");
    //player O
    const turn20 = wrapper.find("button.square").at(19);
    turn20.simulate("click");
    //player X
    const turn21 = wrapper.find("button.square").at(20);
    turn21.simulate("click");
    //player O
    const turn22 = wrapper.find("button.square").at(21);
    turn22.simulate("click");
    //player X
    const turn23 = wrapper.find("button.square").at(22);
    turn23.simulate("click");
    //player O
    const turn24 = wrapper.find("button.square").at(23);
    turn24.simulate("click");
    //player X
    const turn25 = wrapper.find("button.square").at(24);
    turn25.simulate("click");

    const draw = wrapper.find("div.game5x5").children().first().text();
    expect(draw).toEqual("Draw");
  });
});
