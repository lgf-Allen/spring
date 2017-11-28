/**
 * 
 */
package com.allen.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.allen.spring.controller.EmployeeController;
import com.allen.spring.service.EmployeeService;

/**
 * @author first
 *
 */
@Controller
@RequestMapping("employee")
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    private final Integer pageSize=10;
    @Override
    @RequestMapping(path="list",method=RequestMethod.GET)
    public String list(@RequestParam(required=true,name="pageNo",defaultValue="1")String pageNo) {
        Integer pageNo1 = Integer.parseInt(pageNo);
        employeeService.getPage(pageNo1, pageSize);
        return "emp/list";
    }

}
