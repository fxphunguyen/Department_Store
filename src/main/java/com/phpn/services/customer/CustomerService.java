package com.phpn.services.customer;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerParam;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.ICustomer;
import com.phpn.repositories.model.ICustomerOwerImpl;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerResult> findAllCustomer();

    void  deleteStatusCustomer(Integer id);

    CustomerResult findById(Integer id);

    CustomerOrderResult findByIdCustomerOrder(Integer id);

<<<<<<< HEAD
    Customer create(CustomerCreate customerCreate);

    List<CustomerResult> findAllCustomerResultByDeleted(boolean deleted);
=======
    Customer createCustomerResult(CustomerParam customerParam);

    Customer create(CustomerCreate customerCreate);

    List<CustomerResult> findCustomerByDeleted(boolean deleted);

    List<CustomerOrderResult> findAllCustomerResultByDeleted(boolean deleted);
>>>>>>> 3b66ad51328ce8e461613c0e16cc121d6712cdb6

    List<CustomerResult> findAll();

    Customer update(CustomerResult customerResult);

    List<CustomerResult> findAllCustomerByDelete(boolean deleted);

//    Customer  updateCustomerOrder(CustomerOrderResult customerOrderResult);

    List<ICustomer> showAllCustomerMixInfoByStatus();

    List<ICustomer>  showAllCustomerMixInfo();

    ICustomer CustomerInfoById(Integer id);

     List<ICustomerOwerImpl> CustomerOwerById(Integer id);


}
