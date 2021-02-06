package com.goga.cms.service;

import com.goga.cms.DAO.CustomerDao;
import com.goga.cms.Exception.CustomerNotFoundException;
import com.goga.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
//import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class CustomerService {


    @Autowired
    private CustomerDao customerDao;

    /*

    private int customerIdCounter=1;
    private List<Customer> customerList=new CopyOnWriteArrayList<>();
    */

    public Customer addCustomer(Customer customer){
        /*
        customer.setCustomerId(customerIdCounter);
        customerList.add(customer);
        customerList.add(customer);
        customerIdCounter++;

         */
      return  customerDao.save(customer);
     //   return customer;
    }
    public List<Customer> getCostumers(){
        return customerDao.findAll();
      //  return customerList;
    }
    public Customer getCustomer(int customerId){
        /*
    return    customerList.stream().filter(c->c.getCustomerId()==customerId)
        .findFirst().get();

         */
        Optional<Customer> optionalCustomer=customerDao.findById(customerId);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available");
    return optionalCustomer.get();

    }
    public Customer updateCustomer(int customerId,Customer customer){
        /*
        customerList.stream().forEach(c->{
            if(c.getCustomerId()==customerId){
                c.setCustomerEmail(customer.getCustomerEmail());
                c.setCustomerFirstName(customer.getCustomerFirstName());
                c.setCustomerLastName(customer.getCustomerLastName());
            }
        });
        return customerList.stream().filter(c->c.getCustomerId()==customerId).findFirst().get();

         */
        customer.setCustomerId(customerId);
        return customerDao.save(customer);
    }

   public void deleteCustomer(int customerId) {
        /*
       customerList.stream().forEach(c->{
           if(c.getCustomerId()==customerId){
                customerList.remove(c);
           }
       });
         */
       customerDao.deleteById(customerId);
   }

}
