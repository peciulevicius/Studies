import React from "react";
import { shallow } from "enzyme";
import Square from "../../../components/square/Square.component";
import "../../../setupTests";

describe("Square testing", () => {
  it("Renders without crashing", () => {
    shallow(<Square />);
  });

  it("Should render empty the square div", () => {
    const square = shallow(<Square value="" />);
    expect(square.text()).toEqual("");
  });

  it("Should have value as X when it is X ", () => {
    const squareX = shallow(<Square value="X" />);
    expect(squareX.text()).toEqual("X");
  });

  it("Should have value as O when it is O ", () => {
    const squareO = shallow(<Square value="O" />);
    expect(squareO.text()).toEqual("O");
  });
});
