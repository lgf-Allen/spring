/**
 * 
 */
package com.allen.spring.service;

import java.util.List;

import com.allen.spring.persist.bean.Department;

/**
 * @author first
 *
 */
public interface DepartmentService {
    
    public List<Department> findAll();
}
