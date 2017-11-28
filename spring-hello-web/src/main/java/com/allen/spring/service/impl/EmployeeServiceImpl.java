/**
 * 
 */
package com.allen.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allen.spring.persist.bean.Employee;
import com.allen.spring.persist.repository.EmployeeRepository;
import com.allen.spring.service.EmployeeService;

/**
 * @author first
 *
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Transactional(readOnly=true)
    @Override
    public Page<Employee> getPage(int page, int size) {
        PageRequest pageable = new PageRequest(page-1, size);
        return employeeRepository.findAll(pageable);
    }

    
}
