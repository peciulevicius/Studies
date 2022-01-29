import React from "react";
import { shallow } from "enzyme";
import "../../../setupTests";
import Board3x3 from "../../../components/board/Board3x3.component";

describe("Board3x3 testing", () => {
  it("Renders without crashing", () => {
    let squares = Array(9).fill(null);
    shallow(<Board3x3 squares={squares} />);
  });

  // it("calls onClick event on click of a board square", () => {
  //   let squares = Array(9).fill(null);
  //   const onClick = jest.fn();
  //   let wrapper = mount(<Board3x3 squares={squares} onClick={onClick} />);
  //   wrapper.find("button.square").first().simulate("click");
  //   expect(onClick).toBeCalledWith(0);
  // });
});
