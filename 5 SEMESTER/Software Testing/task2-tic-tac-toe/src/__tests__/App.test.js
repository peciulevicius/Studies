import React from "react";
import App from "../App";
import { shallow, mount } from "enzyme";
import "../setupTests";
import { MemoryRouter } from "react-router-dom";
import Game3x3 from "../components/game/Game3x3.component";
import NotFound from "../components/notFound/NotFound.component";

describe("<App />", () => {
  it("Renders <App /> component correctly", () => {
    // shallow creates instance of a component
    expect(shallow(<App />)).toMatchSnapshot();
  });

  // test if app goes to specific route by using MemoryRouter provided by react-router.
  // we also need to check the deep rendered component by the router so we must use mount()
  it("Invalid path should redirect to 404", () => {
    const wrapper = mount(
      // MemoryRouter have initialEntries prop to custom your initial route path
      // We mock the BrowserRouter used by App.js by creating /__mocks__/react-router-dom.js
      // We need to mock it because it'll overlap with our MemoryRouter and causing the intialEntries not work.
      <MemoryRouter initialEntries={["/random"]}>
        <App />
      </MemoryRouter>
    );
    expect(wrapper.find(Game3x3)).toHaveLength(0);
    expect(wrapper.find(NotFound)).toHaveLength(1);
  });

  it("Valid path should not redirect to 404", () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={["/"]}>
        <App />
      </MemoryRouter>
    );
    expect(wrapper.find(Game3x3)).toHaveLength(1);
    expect(wrapper.find(NotFound)).toHaveLength(0);
  });
});
