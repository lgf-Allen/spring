/**
 * 
 */
package com.allen.spring.persist.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author first
 *
 */
@Entity
@Table(name="department_tab")
@SequenceGenerator(name="DS",sequenceName="Department_seq",allocationSize=1)
public class Department {

    @Id
    @GeneratedValue(generator="DS",strategy=GenerationType.AUTO)
    private Integer id;
    private String departmentName;
    public Department() {

    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    
}
