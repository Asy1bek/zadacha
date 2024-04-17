package kz.project.test.service;

import kz.project.test.model.Address;
import kz.project.test.model.Employee;
import kz.project.test.model.EmployeeDto;
import kz.project.test.repository.EmployeeRepository;
import kz.project.test.testproject.AddressClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;
    @Autowired
    private AddressClient addressClient;

    public Address getEmployeeId(Long id) {
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }
        Employee employee = employeeOptional.get();
        return addressClient.getAddress(Long.valueOf(employee.getAddressId())).getBody();
    }

    public Employee saveEmployee(EmployeeDto employeeDto) {
        ResponseEntity<Address> addressResponseEntity = addressClient.saveAddress(employeeDto.getAddressDto());
        if (addressResponseEntity.getBody() == null || addressResponseEntity.getBody().getId() == null) {
            throw new RuntimeException("Address not found");
        }
        String addressId = addressResponseEntity.getBody().getId();
        Employee employee = newEmployee(employeeDto, addressId);
        return employeeRepo.save(employee);
    }

    private static Employee newEmployee(EmployeeDto employeeDto,String addressId) {
        Employee employee = new Employee();
        employee.setAge(employeeDto.getAge());
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setAddressId(addressId);
        return employee;
    }

}
