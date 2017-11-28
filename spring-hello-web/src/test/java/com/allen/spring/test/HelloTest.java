/**
 * 
 */
package com.allen.spring.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.allen.spring.persist.bean.Employee;
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

}
