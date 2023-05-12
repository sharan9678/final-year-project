import { Button, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, TextField, Typography } from "@mui/material";
import React, { useEffect, useState } from "react";
import "./contracts.css";
import axios from 'axios';

export default function ContractsDashboard() {
    let num = 1;
    const [contracts, setContracts] = useState([]);
    const [contractUrl, setContractUrl] = useState("");
    const [responseArrived, setResponseArrived] = useState(false);

    const handleContractUrlChange = (event) => {
        console.log(event.target.value);
        setContractUrl(event.target.value);
    }

    const handleDownloadClick = () => {
        axios.get(`http://localhost:8765/contract-test/download-contract?url=${contractUrl}`)
            .then(response => {
                setResponseArrived(true);
                console.log(response);
                if (response.status == 200) {
                    alert("Downloaded Successfully!");
                    setContractUrl("");
                } else {
                    alert("Enter a valid URL!");
                    setContractUrl("");
                }
            })
            .catch(error => {
                console.log(error);
                alert("Enter a valid URL!")
            })
    }

    useEffect(() => {
        axios.get('http://localhost:8765/contract-test/files')
        .then(response => {
            setContracts(response.data);
            setResponseArrived(false);
        })
        .catch(error => {
            console.log(error);
        });
    }, [responseArrived]);

    return (
        <div>
            <div className="center">
                <Typography variant="h2"><b>Contracts Dashboard</b></Typography>
                <Typography variant="h3" color="text.secondary">View & Download <b>Contracts</b></Typography>
            </div>
            <div className="center">
                <TextField 
                    className="tfield" 
                    variant="outlined" 
                    label="Download Contracts" 
                    id="getContract"
                    value={contractUrl}
                    onChange={handleContractUrlChange}
                />
                <span>&nbsp;&nbsp;</span>
                <Button className="tbtn" variant="contained" onClick={handleDownloadClick}>Download</Button>
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