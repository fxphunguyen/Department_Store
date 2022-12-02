package com.phpn.services.customer;

import com.phpn.dto.customer.CreateCustomerParam;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerParam;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.ICustomer;

import java.util.List;

public interface CustomerService {

    void  deleteCustomer (Integer id);

    CustomerResult findById(Integer id);

    CustomerOrderResult findByIdCustomerOrder(Integer id);

    CustomerResult create(CreateCustomerParam customerCreate);

    List<CustomerResult> findCustomerByDeleted(boolean deleted);

    List<CustomerOrderResult> findAllCustomerResultByDeleted(boolean deleted);

    List<CustomerResult> findAll();


    CustomerResult update(CustomerResult customerResult);


     CustomerGender[] findAllByCustomerGender();

    List<CustomerResult> findAllCustomerByDelete(boolean deleted);

//    Customer  updateCustomerOrder(CustomerOrderResult customerOrderResult);

    List<ICustomer> showAllCustomerMixInfoByStatus();

    List<ICustomer>  showAllCustomerMixInfo();

    ICustomer CustomerInfoById(Integer id);

//    ShippingAddressResult createShippingAddress(ShippingAddressParam shippingAddressParam);
}
