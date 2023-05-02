import React from "react";
import { Link } from "react-router-dom";

const handleButton1Click = () => {
    window.open("localhost:5761", "_blank");
}

export default function Home() {
    return (
        <div>
            <h1>Welcome to</h1>
            <h2>Contract Testing Tool for Microservices</h2>
            <button onClick={handleButton1Click}>View Available Services</button>
            <Link to="/contracts">
                <button>Contracts</button>
            </Link>
            <Link to="/comparator">
                <button>Comparator</button>
            </Link>
        </div>
    )
};