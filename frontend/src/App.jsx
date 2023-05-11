import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import React from "react";
import Home from "./pages/home/Home";
import Contracts from "./pages/contracts/ContractsDashboard";
import Comparator from "./pages/comparator/ComparatorDashboard";

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