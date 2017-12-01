/**
 * 
 */
package com.allen.spring.controller.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allen.spring.controller.EmployeeController;
import com.allen.spring.persist.bean.Employee;
import com.allen.spring.service.EmployeeService;

/**
 * @author first
 *
 */
@Controller
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    //指定一个常量：pageSize=10
    private final Integer pageSize = 10;

    /* 
     * 带分页的查询员工
     * @return String 
     * @see com.allen.spring.controller.EmployeeController#list(java.lang.String, java.util.Map)
     */
    @Override
    @RequestMapping(path = "list", method = RequestMethod.GET)
    public String list(@RequestParam(required = true, name = "pageNo", defaultValue = "1") String pageNo,Map<String , Object> map) {
        Integer pageNo1 = Integer.parseInt(pageNo);
        if (pageNo1 < 1) {
            pageNo1 = 1;
        }
        Page<Employee> page = employeeService.getPage(pageNo1, pageSize);
        map.put("page", page);
        return "emp/list";
    }

    @ResponseBody
    @RequestMapping(path="/ajaxValidateLastName",method=RequestMethod.POST)
    @Override
    public String validateLastName(@RequestParam(value="lastName",required=true)String lastName) {
        Employee employee = employeeService.findByLastName(lastName);
        return employee == null? "0": "1";
    }

    @RequestMapping(path="emp",method=RequestMethod.POST)
    @Override
    public String save(Employee employee) {
        employeeService.save(employee);
        return "redirect:list";
    }

}
