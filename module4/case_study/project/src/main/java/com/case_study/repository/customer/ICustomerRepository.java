package com.case_study.repository.customer;

import com.case_study.model.customer.Customer;
import com.case_study.model.customer.CustomerType;
import com.case_study.viewDto.CustomerView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query(value = "select id,name,birthday, customer_type_id, gender, id_card as idCard, phone_number as phoneNumber, email, address from customer where flag_remove = true ", nativeQuery = true,
//    countQuery = "select * from (select id,name,birthday,customer_type_id as customerType, gender, id_card as idCard, phone_number as phoneNumber, email, address from customer where flag_remove = true) as a")
//    @Query(value = "select c.id,c.name,c.birthday, ct.name as customerType, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address from customer c join customer_type ct on c.customer_type_id = ct.id where flag_remove = true order by c.id",
//            countQuery = "select *from (select c.id,c.name,c.birthday, ct.name as customerType, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address from customer c join customer_type ct on c.customer_type_id = ct.id where flag_remove = true order by c.id) as a",
//            nativeQuery = true)
//    Page<CustomerView> showList(Pageable pageable);
    Page<CustomerView> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType,Pageable pageable);
    Page<CustomerView> findByNameContainingAndEmailContaining(String name, String email,Pageable pageable);

}
