package com.productWishlist.Service;
import com.productWishlist.Model.Employee;
import com.productWishlist.Model.dto.EmployeeDto;
import com.productWishlist.Repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService implements IEmployeeUserService{

    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public Employee addEmployee(EmployeeDto employeeDto) {
        if(employeeDto == null || employeeDto.getName()==null || employeeDto.getEmail()==null || employeeDto.getPassword() == null){
            throw new IllegalArgumentException("Employee Dto and its properties cannot be null");
        }
        String encryptPassword = bCryptPasswordEncode().encode(employeeDto.getPassword());
        if(encryptPassword == null){
            throw new RuntimeException("Failed to encrypt password");
        }
        Employee employee = new Employee(employeeDto.getName(),employeeDto.getEmail());
        employee.setPassword(encryptPassword);
        employee.setRole("ROLE_USER");
        employee.setEnable(true);
        employee.setVerificationCode(UUID.randomUUID().toString());
        employee.setAccountNotLocked(true);

        try{
            iEmployeeRepository.save(employee);
            return employee;
        }catch(Exception e){
            throw new RuntimeException("Failed to save employee",e);
        }
    }

    @Override
    public BCryptPasswordEncoder bCryptPasswordEncode() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Employee findByEmail(String email) {
        return iEmployeeRepository.findByEmail(email);
    }

    @Override
    public boolean findByVerificationCode(String code) {
        Employee employee = iEmployeeRepository.findByVerificationCode(code);
        if(employee!=null){
            employee.setVerificationCode(null);
            employee.setEnable(true);
            iEmployeeRepository.save(employee);
        }
        return false;
    }
}
