/**
 * 
 */
package com.allen.spring.controller;

import java.util.Map;

/**
 * @author first
 *
 */
public interface EmployeeController {


    String list(String pageNo, Map<String, Object> map);
}
