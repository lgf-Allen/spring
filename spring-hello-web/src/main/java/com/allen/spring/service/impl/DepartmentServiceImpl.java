/**
 * 
 */
package com.allen.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allen.spring.persist.bean.Department;
import com.allen.spring.persist.repository.DepartmentRepository;
import com.allen.spring.service.DepartmentService;

/**
 * @author first
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    /* (non-Javadoc)
     * @see com.allen.spring.service.DepartmentService#findAll()
     */
    @Override
    public List<Department> findAll() {
        List<Department> list = departmentRepository.getAll();
        return list;
    }

}
