package com.case_study.repository.contract;

import com.case_study.dtoView.ContractView;
import com.case_study.model.contract.Contract;
import com.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findByCustomer(Customer customer, Pageable pageable);
    Page<Contract> findByFlagRemove(boolean flagRemove, Pageable pageable);
    @Query(value =  "SELECT c.id, c.start_date as startDate, c.end_date as endDate, cu.name as customerName, e.name as employeeName, f.name as facilityName, (sum(ifnull(cd.quantity,0) * ifnull(af.cost,0)) + f.cost) AS totalAmount, c.deposit FROM contract c LEFT JOIN contract_detail cd ON c.id=cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT  JOIN facility f ON c.facility_id = f.id JOIN customer cu ON cu.id = c.customer_id JOIN employee e on c.employee_id = e.id WHERE c.flag_remove = true GROUP BY c.id ORDER BY c.id desc",
            nativeQuery = true,
            countQuery = "select * from (SELECT c.id, c.start_date as startDate, c.end_date as endDate, cu.name as customerName, e.name as employeeName, f.name as facilityName, (sum(ifnull(cd.quantity,0) * ifnull(af.cost,0)) + f.cost) AS totalAmount, c.deposit FROM contract c LEFT JOIN contract_detail cd ON c.id=cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT  JOIN facility f ON c.facility_id = f.id JOIN customer cu ON cu.id = c.customer_id JOIN employee e on c.employee_id = e.id WHERE c.flag_remove = true GROUP BY c.id ORDER BY c.id desc) as A")
    Page<ContractView> showList(Pageable pageable);
    @Query(value =  "SELECT c.id, c.start_date as startDate, c.end_date as endDate, cu.name as customerName, e.name as employeeName, f.name as facilityName, (sum(ifnull(cd.quantity,0) * ifnull(af.cost,0)) + f.cost) AS totalAmount, c.deposit FROM contract c LEFT JOIN contract_detail cd ON c.id=cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT  JOIN facility f ON c.facility_id = f.id JOIN customer cu ON cu.id = c.customer_id JOIN employee e on c.employee_id = e.id WHERE c.flag_remove = true and c.customer_id = :id GROUP BY c.id ORDER BY c.id desc",
            nativeQuery = true,
            countQuery = "select * from (SELECT c.id, c.start_date as startDate, c.end_date as endDate, cu.name as customerName, e.name as employeeName, f.name as facilityName, (sum(ifnull(cd.quantity,0) * ifnull(af.cost,0)) + f.cost) AS totalAmount, c.deposit FROM contract c LEFT JOIN contract_detail cd ON c.id=cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT  JOIN facility f ON c.facility_id = f.id JOIN customer cu ON cu.id = c.customer_id JOIN employee e on c.employee_id = e.id WHERE c.flag_remove = true and c.customer_id = :id GROUP BY c.id ORDER BY c.id desc) as A")
    Page<ContractView> showListWithCustomer(@Param("id") int customerId, Pageable pageable);
}
