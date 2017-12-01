/**
 * 
 */
package com.allen.spring.persist.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author first
 *
 */
@Entity
@Table(name = "Employee_tab")
@SequenceGenerator(name = "ES", sequenceName = "Employee_seq", allocationSize = 1)
public class Employee {

    @Id
    @GeneratedValue(generator = "ES", strategy = GenerationType.AUTO)
    private Integer id;
    private String lastName;
    private String email;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @JoinColumn(name="DEPARTMENT_ID ")
    @ManyToOne(fetch=FetchType.LAZY)
    private Department department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
