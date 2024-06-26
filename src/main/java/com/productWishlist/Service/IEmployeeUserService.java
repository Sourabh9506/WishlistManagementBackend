package com.productWishlist.Service;

import com.productWishlist.Model.Employee;
import com.productWishlist.Model.dto.EmployeeDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface IEmployeeUserService {
    /**
     * Adds a new employee user.
     *
     * @param employeeDto the DTO object representing the employee details
     * @return the added Employee object
     */
    public Employee addEmployee(EmployeeDto employeeDto);
    /**
     * Retrieves the BCryptPasswordEncoder instance.
     *
     * @return the BCryptPasswordEncoder instance
     */

    public BCryptPasswordEncoder bCryptPasswordEncode();
    /**
     * Finds an employee user by email.
     *
     * @param email the email of the employee user to find
     * @return the found Employee object, or null if not found
     */

    public Employee findByEmail(String email);
    /**
     * Finds an employee user by verification code.
     *
     * @param code the verification code to search for
     * @return true if a matching user is found, false otherwise
     */
    public boolean findByVerificationCode(String code);
}
