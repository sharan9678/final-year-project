import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import React from "react";
import Home from "./pages/Home";
import Contracts from "./pages/Contracts";
import Comparator from "./pages/Comparator";

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