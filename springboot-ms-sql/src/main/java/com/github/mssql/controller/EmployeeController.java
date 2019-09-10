package com.github.mssql.controller;

import com.github.mssql.common.exception.ResourceNotFoundException;
import com.github.mssql.model.Employee;
import com.github.mssql.model.Moniter5m20191001b;
import com.github.mssql.model.SysUser;
import com.github.mssql.model.TestData;
import com.github.mssql.repository.EmployeeRepository;
import com.github.mssql.repository.Moniter5m20191001bRepository;
import com.github.mssql.repository.SysUserRepository;
import com.github.mssql.repository.TestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: demo的接口
 * @author: KL
 * @create: 2019-07-19
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestDataRepository testDataRepository;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private Moniter5m20191001bRepository moniter5m20191001bRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/testdata/{id}")
    public ResponseEntity<TestData> getTestDataById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        TestData employee = testDataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping("/sysuser")
    public  List<SysUser> getAllUser()
            throws ResourceNotFoundException {
        return sysUserRepository.findAll();
    }

    @GetMapping("/5m")
    public Page<Moniter5m20191001b> getAllMoniter5m()
            throws ResourceNotFoundException {
        return moniter5m20191001bRepository.findAll(new PageRequest(1, 20));
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
