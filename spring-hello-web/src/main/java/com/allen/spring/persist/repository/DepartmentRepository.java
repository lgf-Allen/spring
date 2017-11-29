/**
 * 
 */
package com.allen.spring.persist.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.allen.spring.persist.bean.Department;

/**
 * @author first
 *
 */
public interface DepartmentRepository extends DepartmentCustom,JpaRepository<Department, Integer> {
    
    @QueryHints({@QueryHint(name=org.hibernate.jpa.QueryHints.HINT_CACHEABLE,value="true")})
    @Query("FROM Department d")
    List<Department> getAll();
}
