import React from 'react';
import { shallow } from 'enzyme';
import "../../../setupTests";

import ChooseGame from "../../../components/chooseGame/ChooseGame.component.jsx";

describe("ChooseGame testing", () => {
    it("Renders without crashing", () => {
        shallow(<ChooseGame />);
    });
})