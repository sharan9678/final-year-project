import React from "react";
import { useHistory } from "react-router-dom";

const handleButton1Click = () => {
    window.open("localhost:5761", "_blank");
}

const handleContracts = () => {
    useHistory().push("/contracts")
}

export default function Home() {
    return (
        <div>
            <h1>Welcome to</h1>
            <h2>Contract Testing Tool for Microservices</h2>
            <button onClick={handleButton1Click}>View Available Services</button>
            <button onClick={handleContracts}>Contracts</button>
            <button>Comparator</button>
        </div>
    )
};