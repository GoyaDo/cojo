package com.ysmjjsy.goya.cojo.controller;

import com.ysmjjsy.goya.cojo.cmd.RegisterCustomerRequest;
import com.ysmjjsy.goya.cojo.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Goya
 * @version 1.0
 * @since 2024/3/28 22:28
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CustomerService customerService;

    @PostMapping("/register/customer")
    public ResponseEntity<RegisterCustomerRequest> registerCustomer(@RequestBody RegisterCustomerRequest request){
        return ResponseEntity.ok(customerService.registerCustomer(request));
    }
}
