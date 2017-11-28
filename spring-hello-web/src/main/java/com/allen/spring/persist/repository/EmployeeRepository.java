/**
 * 
 */
package com.allen.spring.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.allen.spring.persist.bean.Employee;

/**
 * @author first
 *
 */

public interface EmployeeRepository extends EmployeeCustom,JpaRepository<Employee, Integer> {

}
