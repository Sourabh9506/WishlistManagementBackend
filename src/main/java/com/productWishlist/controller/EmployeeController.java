package com.productWishlist.controller;
import com.productWishlist.Model.Employee;
import com.productWishlist.Model.dto.EmployeeDto;
import com.productWishlist.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//    This api is for registering a new user
//    @Hidden
    @PostMapping("/register")
    public ResponseEntity<String> RegisterUser(@Valid @RequestBody EmployeeDto employeeDto){
        try{
            Employee employee = employeeService.addEmployee(employeeDto);
            if(employee==null){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");

            }else{
                return ResponseEntity.ok("Registered Successfully");
            }
        }catch(DataIntegrityViolationException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
        }
    }

}
