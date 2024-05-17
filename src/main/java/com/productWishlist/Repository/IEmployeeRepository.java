package com.productWishlist.Repository;

import com.productWishlist.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,String> {
        Employee findByEmail(String email);
        Employee findByVerificationCode(String code);

}
