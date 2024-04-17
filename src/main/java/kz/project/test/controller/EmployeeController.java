package kz.project.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.project.test.model.Address;
import kz.project.test.model.Employee;
import kz.project.test.model.EmployeeDto;
import kz.project.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@Api(description = "для иллюстрация swagger")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees/{id}")
    @ApiOperation("для получения работника по айди")
    private ResponseEntity<Address> getAddress(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeId(id));
    }

    @PostMapping("/employees")
    @ApiOperation("for adding new employee")
    private ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.saveEmployee(employeeDto));
    }

}

