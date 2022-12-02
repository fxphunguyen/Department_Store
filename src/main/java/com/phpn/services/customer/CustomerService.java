package com.phpn.services.customer;

import com.phpn.dto.customer.CreateCustomerParam;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.ICustomer;
import com.phpn.repositories.model.ICustomerOwerImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerService {

    List<CustomerResult> findAllCustomer();

    CustomerResult findById(Integer id);

    CustomerOrderResult findByIdCustomerOrder(Integer id);

    CustomerResult create(CreateCustomerParam customerCreate);

    List<CustomerResult> findCustomerByDeleted(boolean deleted);

    List<CustomerOrderResult> findAllCustomerResultByDeleted(boolean deleted);

    List<CustomerResult> findAll();


    CustomerResult update(CustomerResult customerResult);

    @Transactional(readOnly = true)
    CustomerGender[] findAllByCustomerGender();

    List<CustomerResult> findAllCustomerByDelete(boolean deleted);

//    Customer  updateCustomerOrder(CustomerOrderResult customerOrderResult);

    List<ICustomer> showAllCustomerMixInfoByStatus();

    List<ICustomer>  showAllCustomerMixInfo();

    ICustomer CustomerInfoById(Integer id);

     List<ICustomerOwerImpl> CustomerOwerById(Integer id);



}
