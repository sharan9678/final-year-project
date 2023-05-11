import { Button, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Typography } from "@mui/material";
import React from "react";
import "./contracts.css";

const rows = [
    {
        name:"contract 1",
        location:"location 1"
    },
    {   
        name:"contract 2",
        location:"location 2"
    }
]

export default function ContractsDashboard() {
    return (
        <div>
            <div className="center">
                <Typography variant="h2"><b>Contracts Dashboard</b></Typography>
                <Typography variant="h3" color="text.secondary">View & Download <b>Contracts</b></Typography>
            </div>
            <div className="center">
                <TextField className="tfield" variant="outlined" label="Download Contracts" id="getContract"/>
                <span>&nbsp;&nbsp;</span>
                <Button className="tbtn" variant="contained">Download</Button>
            </div>
            <div>
                <TableContainer component={Paper} /*className="table"*/>
                    <Table sx={{width:1000, marginLeft:12}} aria-label="simple table">
                        <TableHead>
                            <TableRow>
                                <TableCell>Contract ID</TableCell>
                                <TableCell align="right">Contract Name</TableCell>
                                <TableCell align="right">Contract Location</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {rows.map((row) => (
                                <TableRow
                                    key={row.name}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                    <TableCell>1</TableCell>
                                    <TableCell align="right">{row.name}</TableCell>
                                    <TableCell align="right">{row.location}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </div>
        </div>
    )
}