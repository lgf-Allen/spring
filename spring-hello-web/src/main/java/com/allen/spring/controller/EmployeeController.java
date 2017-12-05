/**
 * 
 */
package com.allen.spring.controller;

import java.util.Map;

import com.allen.spring.persist.bean.Employee;

/**
 * @author first
 *
 */
public interface EmployeeController {


    String list(String pageNo, Map<String, Object> map);
    
    String validateLastName(String lastName);
    
    public String save(Employee employee);
    
    public String input(Integer id,Map<String ,Object> map);
}
