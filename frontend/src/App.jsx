import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import React from "react";
import Home from "./pages/home/Home";
import Contracts from "./pages/contracts/Contracts";
import Comparator from "./pages/comparator/Comparator";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/contracts" element={<Contracts/>}/>
        <Route path="/comparator" element={<Comparator/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;