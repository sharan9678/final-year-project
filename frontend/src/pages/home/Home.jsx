import { Button, Grid } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";
import "./home.css"

const handleButton1Click = () => {
    window.open("localhost:5761", "_blank");
}

export default function Home() {
    return (
        <div>
            <center>
                <h1>Welcome to</h1>
                <h2>Contract Testing Tool for Microservices</h2>    
            </center>
            <Grid container spacing={3} className="buttons">
                <Grid item >
                    <Button variant="contained" onClick={handleButton1Click}>View Available Services</Button>
                </Grid>
                <Grid item>
                    <Link to="/contracts">
                        <Button variant="contained">Contracts</Button>
                    </Link>
                </Grid>
                <Grid item>
                    <Link to="/comparator">
                        <Button variant="contained">Comparator</Button>
                    </Link>
                </Grid>
            </Grid>            
        </div>
    )
};