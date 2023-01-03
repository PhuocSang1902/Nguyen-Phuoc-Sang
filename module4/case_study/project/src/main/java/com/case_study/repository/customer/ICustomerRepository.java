package com.case_study.repository.customer;

import com.case_study.dtoView.CustomerUseFacilityView;
import com.case_study.model.customer.Customer;
import com.case_study.model.customer.CustomerType;
import com.case_study.dtoView.CustomerView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    //    @Query(value = "select id,name,birthday, customer_type_id, gender, id_card as idCard, phone_number as phoneNumber, email, address from customer where flag_remove = true ", nativeQuery = true,
//    countQuery = "select * from (select id,name,birthday,customer_type_id as customerType, gender, id_card as idCard, phone_number as phoneNumber, email, address from customer where flag_remove = true) as a")
//    @Query(value = "select c.id,c.name,c.birthday, ct.name as customerType, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address from customer c join customer_type ct on c.customer_type_id = ct.id where flag_remove = true order by c.id",
//            countQuery = "select *from (select c.id,c.name,c.birthday, ct.name as customerType, c.gender, c.id_card as idCard, c.phone_number as phoneNumber, c.email, c.address from customer c join customer_type ct on c.customer_type_id = ct.id where flag_remove = true order by c.id) as a",
//            nativeQuery = true)
//    Page<CustomerView> showList(Pageable pageable);
    Page<CustomerView> findByNameContainingAndEmailContainingAndCustomerType(String name, String email, CustomerType customerType, Pageable pageable);

    Page<CustomerView> findByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

    @Query(value = "SELECT cu.id, cu.name, ct.name as customerTypeName, cu.birthday, cu.gender, cu.id_card as idCard, cu.phone_number as phoneNumber, cu.email, cu.address FROM customer cu JOIN contract c on cu.id = c.customer_id JOIN customer_type ct on ct.id = cu.customer_type_id where cu.customer_type_id = :customerTypeId and cu.email like CONCAT('%',:email,'%') and cu.name like CONCAT('%',:name,'%') AND cu.flag_remove = true GROUP BY cu.id",
            nativeQuery = true,
            countQuery = "select *from (SELECT cu.id, cu.name, ct.name as customerTypeName, cu.birthday, cu.gender, cu.id_card as idCard, cu.phone_number as phoneNumber, cu.email, cu.address FROM customer cu JOIN contract c on cu.id = c.customer_id JOIN customer_type ct on ct.id = cu.customer_type_id where cu.customer_type_id = :customerTypeId and cu.email like CONCAT('%',:email,'%') and cu.name like CONCAT('%',:name,'%') AND cu.flag_remove = true GROUP BY cu.id)as A")
    Page<CustomerUseFacilityView> showListUseFacilityByNameAndEmailAndCustomerType(@Param("name") String name, @Param("email") String email, @Param("customerTypeId") int customerTypeId, Pageable pageable);

    @Query(value = "SELECT cu.id, cu.name, ct.name as customerTypeName, cu.birthday, cu.gender, cu.id_card as idCard, cu.phone_number as phoneNumber, cu.email, cu.address FROM customer cu JOIN contract c on cu.id = c.customer_id JOIN customer_type ct on ct.id = cu.customer_type_id where cu.email like CONCAT('%',:email,'%') and cu.name like CONCAT('%',:name,'%') AND cu.flag_remove = true GROUP BY cu.id",
            nativeQuery = true,
            countQuery = "select *from (SELECT cu.id, cu.name, ct.name as customerTypeName, cu.birthday, cu.gender, cu.id_card as idCard, cu.phone_number as phoneNumber, cu.email, cu.address FROM customer cu JOIN contract c on cu.id = c.customer_id JOIN customer_type ct on ct.id = cu.customer_type_id where cu.email like CONCAT('%',:email,'%') and cu.name like CONCAT('%',:name,'%') AND cu.flag_remove = true GROUP BY cu.id)as A")
    Page<CustomerUseFacilityView> showListUseFacilityByNameAndEmail(@Param("name") String name, @Param("email") String email, Pageable pageable);

}
