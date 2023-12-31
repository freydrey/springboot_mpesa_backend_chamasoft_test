package com.chamasoft.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(
            @PathVariable("customerId") Integer customerId){
        return customerService.getCustomerById(customerId);
    }


    @PostMapping("/register")
    public void registerCustomer(
            @RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        customerService.addCustomer(customerRegistrationRequest);
    }

    @PostMapping("/login")
    public Customer loginCustomer(
            @RequestBody CustomerLoginRequest customerLoginRequest){
        return customerService.getCustomerByPhonePassword(customerLoginRequest);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer customerId){
         customerService.deleteCustomerById(customerId);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") Integer customerId,
            @RequestBody CustomerUpdateRequest customerUpdateRequest){
         customerService.updateCustomer(customerId,customerUpdateRequest);
    }

}
