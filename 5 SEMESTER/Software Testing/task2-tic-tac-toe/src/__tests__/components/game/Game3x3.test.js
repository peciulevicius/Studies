import React from "react";
import { mount, shallow } from "enzyme";
import Game3x3 from "../../../components/game/Game3x3.component";
import "../../../setupTests";

describe("Game3x3 testing", () => {
  it("Renders without crashing", () => {
    shallow(<Game3x3 />);
  });

  /* 
  With our next test we’ll check if game status renders correctly. 
  For now we will start with a simple check of “Next Player:” and will make sure that before 
  the game starts the next player is X and after the first move it changes to O. We will have 
  to mount all our components in this case again, so add mount to your Enzyme import. 
  */
  it("Testing first few moves for the game", () => {
    const wrapper = mount(<Game3x3 />);
    const firstPlayer = wrapper.find("div.game3x3").children().first().text();
    //if we change it to Y, test will fail
    expect(firstPlayer).toEqual("Next player: X");

    const button = wrapper.find("button.square").first();
    button.simulate("click");
    const secondPlayer = wrapper.find("div.game3x3").children().first().text();
    expect(secondPlayer).toEqual("Next player: O");
  });

  /* 
we have to add to our status check is declaring the winner when the game is over. 
We will have to simulate clicks on squares, specifying the square number using Enzyme’s .at(index) 
method that should return a wrapper around the node at a given index of the current wrapper (<Game />). 
Since we already click once on the first square for our first half of the test to work, we’ll continue 
taking turns starting from turn 2. Below is the updated test for the above one:
*/
  it("Testing game logic and outputing a winner of X", () => {
    const wrapper = mount(<Game3x3 />);
    const firstPlayer = wrapper.find("div.game3x3").children().first().text();
    //if we change it to Y, test will fail
    expect(firstPlayer).toEqual("Next player: X");

    // player X
    const button = wrapper.find("button.square").first();
    button.simulate("click");
    const secondPlayer = wrapper.find("div.game3x3").children().first().text();
    expect(secondPlayer).toEqual("Next player: O");

    //player O
    const turn2 = wrapper.find("button.square").at(1);
    turn2.simulate("click");
    //player X
    const turn3 = wrapper.find("button.square").at(4);
    turn3.simulate("click");
    //player O
    const turn4 = wrapper.find("button.square").at(5);
    turn4.simulate("click");
    //player X
    const turn5 = wrapper.find("button.square").at(8);
    turn5.simulate("click");

    const winner = wrapper.find("div.game3x3").children().first().text();
    expect(winner).toEqual("Winner: X");
  });
});
