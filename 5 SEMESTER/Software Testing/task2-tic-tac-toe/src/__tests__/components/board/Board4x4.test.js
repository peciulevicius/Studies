import React from "react";
import { shallow } from "enzyme";
import "../../../setupTests";
import Board4x4 from "../../../components/board/Board4x4.component";

describe("Board4x4 testing", () => {
  it("Renders without crashing", () => {
    let squares = Array(16).fill(null);
    shallow(<Board4x4 squares={squares} />);
  });

  // it('calls onClick event on click of a board square', () =>{
  //     let squares = Array(16).fill(null)
  //     const onClick = jest.fn();
  //     let wrapper = mount(<Board4x4 squares={squares} onClick={onClick}/>);
  //     wrapper.find('button.square').first().simulate('click');
  //     expect(onClick).toBeCalledWith(0)
  // });
});
