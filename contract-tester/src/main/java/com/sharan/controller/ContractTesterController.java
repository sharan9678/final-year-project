package com.sharan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contract-tester")
public class ContractTesterController {
    @GetMapping
    public String getAllMethods() {
        return "Hello from API side";
    }
}
