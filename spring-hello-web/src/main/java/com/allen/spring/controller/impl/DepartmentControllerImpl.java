/**
 * 
 */
package com.allen.spring.controller.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.allen.spring.controller.DepartmentController;
import com.allen.spring.persist.bean.Employee;
import com.allen.spring.service.DepartmentService;

/**
 * @author first
 *
 */
@Controller
public class DepartmentControllerImpl implements DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    /* (non-Javadoc)
     * @see com.allen.spring.controller.DepartmentController#input()
     */
    @RequestMapping(value="/emp",method=RequestMethod.GET)
    @Override
    public String input(Map<String ,Object> map) {
        map.put("departments",departmentService.findAll());
        map.put("employee",new Employee());
        return "emp/input";
    }

}
