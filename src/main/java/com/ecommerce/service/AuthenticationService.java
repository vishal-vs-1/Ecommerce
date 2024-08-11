package com.ecommerce.service;

import com.ecommerce.requests.AuthenticateRequest;
import com.ecommerce.requests.RegistrationRequest;

public interface AuthenticationService {


    String registerUser(RegistrationRequest req);
    String authenticateUser(AuthenticateRequest req);

}
