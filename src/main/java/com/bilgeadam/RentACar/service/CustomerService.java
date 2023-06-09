package com.bilgeadam.RentACar.service;

import com.bilgeadam.RentACar.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.RentACar.entity.Customer;
import com.bilgeadam.RentACar.exception.RentACarException;
import com.bilgeadam.RentACar.mapper.ICustomerMapper;
import com.bilgeadam.RentACar.repository.ICustomerRepository;
import com.bilgeadam.RentACar.utility.ServiceManager;
import org.springframework.stereotype.Service;
import static com.bilgeadam.RentACar.exception.ErrorType.*;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository){
        super(customerRepository);
        this.customerRepository = customerRepository;
    }
    public void save(SaveCustomerRequestDto dto){
         save(ICustomerMapper.INSTANCE.toCustomer(dto));
    }

    public List<Customer> findAll(){
        List<Customer> customerList =  customerRepository.findAll();
        if(customerList.isEmpty()){
            throw new RentACarException(CUSTOMER_NOT_FOUND);
        }else {
            return customerList;
        }
    }

    public Optional<Customer> findById(Long id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()){
            throw new RentACarException(CUSTOMER_NOT_FOUND);
        }else {
            return optionalCustomer;
        }
    }
}
