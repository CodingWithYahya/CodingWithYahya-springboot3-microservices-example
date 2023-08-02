package com.stagedemo.departementservice.client;

import com.stagedemo.departementservice.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {
    @GetExchange("/employee/departement/{departementId}")
    public List<Employee> findByDepartement(@PathVariable("departementId")Long departementId);
}
