import { Button, Card, CardActions, CardContent, Grid, Typography, CardMedia} from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";
import "./home.css"

const handleButton1Click = () => {
    window.open("http://localhost:8761", "_blank");
}

export default function Home() {
    return (
        <div>
            <div className="center-text bottom-space expand">
            <Typography variant="h2"><b>Contract Testing Tool</b></Typography>
            <Typography variant="h3" color="text.secondary">for <b>Microservices</b></Typography>
            </div>
            <div>
                <Grid container spacing={3} className="buttons card-center">
                    <Grid item >
                        <Card variant="outlined" className="expand">
                            <CardMedia
                                component="img"
                                height="194"
                                width="194"
                                image="..\images\service-discovery.png"
                                alt="service discovery"
                            />
                            <CardContent>
                                <Typography variant="h4" sx={{ fontSize:20 }}><b>Service Discovery</b></Typography>
                                <Typography variant="body1" color="text.secondary">View all Services Available<br/>in the Microservice</Typography>
                            </CardContent>
                            <CardActions className="card-center">
                                <Button variant="contained" onClick={handleButton1Click}>open</Button>
                            </CardActions>
                        </Card>
                    </Grid>
                    <Grid item>
                        <Card variant="outlined" className="expand">
                            <CardMedia
                                component="img"
                                height="194"
                                width="194"
                                image="..\images\contracts.png"
                                alt="service discovery"
                            />
                            <CardContent>
                                <Typography variant="h4" sx={{ fontSize:20 }}><b>Contracts Dashboard</b></Typography>
                                <Typography variant="body1" color="text.secondary">Download Required Contracts</Typography>
                                <Typography variant="body1" color="text.secondary">View all the Contracts Available</Typography>
                            </CardContent>
                            <CardActions className="card-center">
                                <Link to="/contracts">
                                    <Button variant="contained">open</Button>
                                </Link>
                            </CardActions>
                        </Card>
                    </Grid>
                    <Grid item>
                        <Card variant="outlined" className="expand">
                            <CardMedia
                                component="img"
                                height="194"
                                width="194"
                                image="..\images\comparator.png"
                                alt="service discovery"
                            />
                            <CardContent>
                                <Typography variant="h4" sx={{ fontSize:20 }}><b>Contract Testing</b></Typography>
                                <Typography variant="body1" color="text.secondary">Run Comparator</Typography>
                                <Typography variant="body1" color="text.secondary">View the Test Results</Typography>
                            </CardContent>
                            <CardActions className="card-center">
                                <Link to="/comparator">
                                    <Button variant="contained">open</Button>
                                </Link>
                            </CardActions>
                        </Card>
                    </Grid>
                </Grid>
            </div>        
        </div>
    )
};