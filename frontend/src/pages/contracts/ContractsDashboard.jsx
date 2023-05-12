import { Button, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Typography } from "@mui/material";
import React, { useEffect, useState } from "react";
import "./contracts.css";
import axios from 'axios';

export default function ContractsDashboard() {
    let num = 1;
    const [contracts, setContracts] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8765/contract-test/files')
            .then(response => {
                setContracts(response.data);
            })
            .catch(error => {
                console.log(error);
            });
    }, []);

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
                            {contracts.map((contract) => (
                                <TableRow
                                    key={contract.files}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                    <TableCell>{num++}</TableCell>
                                    <TableCell align="right">{contract.files}</TableCell>
                                    <TableCell align="right">{contract.directoryName}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
            </div>
        </div>
    )
}