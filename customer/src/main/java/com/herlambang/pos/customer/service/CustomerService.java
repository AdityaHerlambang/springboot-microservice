package com.herlambang.pos.customer.service;

import com.herlambang.pos.customer.entity.Customer;
import com.herlambang.pos.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FileUploadService fileUploadService;

    public Customer createCustomer(Customer customer, MultipartFile ktpFile) {
        String filePath = fileUploadService.saveUploadedFile(ktpFile);
        customer.setKtp(filePath);
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(UUID id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(UUID id, Customer updatedCustomer, MultipartFile ktpFile) {
        if (customerRepository.existsById(id)) {
            if(ktpFile != null) {
                String filePath = fileUploadService.saveUploadedFile(ktpFile);
                updatedCustomer.setKtp(filePath);
            }
            updatedCustomer.setId(id);
            return customerRepository.save(updatedCustomer);
        }
        return null;
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

}
