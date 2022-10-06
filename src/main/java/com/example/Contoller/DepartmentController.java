package com.example.Contoller;


import com.example.Service.DepartmentService;
import com.example.homework2_8.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findDepartmentMaxSalary(int department) {
        return departmentService.findDepartmentMaxSalary(department);
    }

    @GetMapping("/min-salary")
    public Employee findDepartmentMinSalary(int department) {
        return departmentService.findDepartmentMinSalary(department);
    }

    @GetMapping(value = "/all", params = "department")
    public Collection<Employee> findDepartmentCollection(int department) {
        return departmentService.findDepartmentCollection(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findDepartmentAll() {
        return departmentService.findDepartmentAll();
    }
}
