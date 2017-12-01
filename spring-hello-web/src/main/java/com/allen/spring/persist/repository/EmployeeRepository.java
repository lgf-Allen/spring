/**
 * 
 */
package com.allen.spring.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allen.spring.persist.bean.Employee;

/**
 * @author first
 *
 */

public interface EmployeeRepository extends EmployeeCustom,JpaRepository<Employee, Integer> {

    Employee findByLastName(String lastName);
    
}
