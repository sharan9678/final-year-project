package com.sharan.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
