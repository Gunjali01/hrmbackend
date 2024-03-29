package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepo employeeRepoImpl;

    public Employee save(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag = false;

        Employee employee = employeeRepoImpl.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword);

        if (employee != null && employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
            flag = true;
        }
        return flag;
    }

    public List<Employee> findByName(String empName) {
        return employeeRepoImpl.findByEmpName(empName);
    }

    public List<Employee> findAll() {
        return employeeRepoImpl.findAll();
    }
}
