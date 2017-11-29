/**
 * 
 */
package com.allen.spring.test;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.hibernate.annotations.QueryHints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allen.spring.persist.bean.Department;
import com.allen.spring.persist.bean.Employee;
import com.allen.spring.persist.repository.DepartmentRepository;
import com.allen.spring.service.EmployeeService;

/**
 * @author first
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml","classpath:spring/mvc-config.xml"})
public class HelloTest {
    
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Test
    public void testDataSource() throws SQLException{

        System.out.println(dataSource.getConnection());
    }
    
    @Autowired
    private EmployeeService employeeService;
    @Test
    public void testFindAll(){
        Page<Employee> pageable = employeeService.getPage(1, 2);
        System.out.println(pageable);
    }
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    // Native Spring Data JPA don't use second level cache.
    @Test
    public void testSecondLevelCache(){
        //打印两次sql
        List<Department> list = departmentRepository.findAll();
        list = departmentRepository.findAll();
        //调用getAll(),second level cache生效
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    // set second level cache
    @Test
    public void testJpaSecondLevelCache(){
        String hql="FROM Department d";
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(hql);
        List<Department> list = query.setHint(QueryHints.CACHEABLE, true).getResultList();
        entityManager.close();
        
        entityManager = entityManagerFactory.createEntityManager();
        query = entityManager.createQuery(hql);
        list = query.setHint(QueryHints.CACHEABLE, true).getResultList();
        entityManager.close();
        
        
        
    }
}
