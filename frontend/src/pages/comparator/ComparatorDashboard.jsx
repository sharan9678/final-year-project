import { Button, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Typography } from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";

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

export default function ComparatorDashboard() {
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
            <Typography variant="h2"><b>Comparator Dashboard</b></Typography>
            <Typography variant="h3" color="text.secondary">Run & View <b>Contract Testing Results</b></Typography>
            
            </div>
            {/* <hr/> */}
            <div className="center">
                <TextField className="tfield" variant="outlined" label="Contract 1" id="contract1"/>
                <span>&nbsp;&nbsp;</span>
                <TextField className="tfield" variant="outlined" label="Contract 2" id="contract2"/>
                <span>&nbsp;&nbsp;</span>
                <Button className="tbtn" variant="contained">run test</Button>
            </div>
            {/* <hr/> */}
            <div>
                <Typography className="center" variant="h4" color="text.secondary">Available <b>CONTRACTS</b></Typography>
                <TableContainer component={Paper}>
                    <Table sx={{ width:1000, marginLeft:12 }} aria-label="simple table">
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
};