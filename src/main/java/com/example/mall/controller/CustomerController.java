package com.example.mall.controller;

import com.example.mall.dto.CustomerDto;
import com.example.mall.dto.SignupRequest;
import com.example.mall.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/signup")
    @ResponseBody
    public CustomerDto signup(HttpServletRequest request) {

        // 1. 회원 정보 조회
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        SignupRequest signupRequest = new SignupRequest(name, email, password, address);
        CustomerDto customerDto = customerService.signup(signupRequest);

        // 2. 세션에 회원 정보 저장 & 세션 유지 시간 설정
        if (customerDto.getCustomerId() != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginMember", customerDto);
            session.setMaxInactiveInterval(60 * 30);
        }

        return customerDto;
    }

    @PostMapping("/login")
    @ResponseBody
    public CustomerDto login(HttpServletRequest request) {

        // 1. 회원 정보 조회
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");
        CustomerDto customerDto = customerService.login(loginId, password);

        // 2. 세션에 회원 정보 저장 & 세션 유지 시간 설정
        if (customerDto.getCustomerId() != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginMember", customerDto);
            session.setMaxInactiveInterval(60 * 30);
        }

        return customerDto;
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
        return;
    }

    @GetMapping("/cust/{id}")
    public CustomerDto findCustomer(@PathVariable("id") int custId) {
        return customerService.getCustomersById(custId);
    }
}
