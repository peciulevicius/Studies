import React from "react";
import { shallow } from "enzyme";
import "../../../setupTests";
import Board5x5 from "../../../components/board/Board5x5.component";

describe("Board5x5 testing", () => {
  it("Renders without crashing", () => {
    let squares = Array(25).fill(null);
    shallow(<Board5x5 squares={squares} />);
  });

  // it('calls onClick event on click of a board square', () =>{
  //     let squares = Array(25).fill(null)
  //     const onClick = jest.fn();
  //     let wrapper = mount(<Board5x5 squares={squares} onClick={onClick}/>);
  //     wrapper.find('button.square').first().simulate('click');
  //     expect(onClick).toBeCalledWith(0)
  // });
});
