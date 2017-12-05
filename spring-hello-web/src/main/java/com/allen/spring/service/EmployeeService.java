/**
 * 
 */
package com.allen.spring.service;

import org.springframework.data.domain.Page;

import com.allen.spring.persist.bean.Employee;

/**
 * @author first
 *
 */
public interface EmployeeService {

    /**
     * 查询所有的员工
     */
    public Page<Employee> getPage(int pageNo,int pageSize);
    
    /**
     * 查询该用户名是否可用，
     * @param lastName
     * @return Employee
     */
    public Employee findByLastName(String lastName);
    
    
    /*
     * 保存新增的用户
     */
    public void save(Employee employee);
    
    public Employee get(Integer id);
}
