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
}
