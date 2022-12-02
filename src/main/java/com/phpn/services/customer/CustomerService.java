package com.phpn.services.customer;

import com.phpn.dto.customer.CreateCustomerParam;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerParam;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.ICustomer;
<<<<<<< HEAD
import com.phpn.repositories.model.ICustomerOwerImpl;
import org.springframework.http.ResponseEntity;
=======
>>>>>>> phu_dev

import java.util.List;

public interface CustomerService {

    List<CustomerResult> findAllCustomer();

    CustomerResult findById(Integer id);

    CustomerOrderResult findByIdCustomerOrder(Integer id);

<<<<<<< HEAD
<<<<<<< HEAD
    Customer create(CustomerCreate customerCreate);

    List<CustomerResult> findAllCustomerResultByDeleted(boolean deleted);
=======
    Customer createCustomerResult(CustomerParam customerParam);

    Customer create(CustomerCreate customerCreate);
=======
    CustomerResult create(CreateCustomerParam customerCreate);
>>>>>>> phu_dev

    List<CustomerResult> findCustomerByDeleted(boolean deleted);

    List<CustomerOrderResult> findAllCustomerResultByDeleted(boolean deleted);
>>>>>>> 3b66ad51328ce8e461613c0e16cc121d6712cdb6

    List<CustomerResult> findAll();

<<<<<<< HEAD
    Customer update(CustomerResult customerResult);
=======

    CustomerResult update(CustomerResult customerResult);
>>>>>>> phu_dev

    List<CustomerResult> findAllCustomerByDelete(boolean deleted);

//    Customer  updateCustomerOrder(CustomerOrderResult customerOrderResult);

    List<ICustomer> showAllCustomerMixInfoByStatus();

    List<ICustomer>  showAllCustomerMixInfo();

    ICustomer CustomerInfoById(Integer id);

<<<<<<< HEAD
     List<ICustomerOwerImpl> CustomerOwerById(Integer id);


=======
//    ShippingAddressResult createShippingAddress(ShippingAddressParam shippingAddressParam);
>>>>>>> phu_dev
}
