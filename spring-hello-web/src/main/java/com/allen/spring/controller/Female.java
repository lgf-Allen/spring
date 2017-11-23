/**
 * 
 */
package com.allen.spring.controller;

/**
 * @author first
 *
 */
public class Female{

    private String name;
    private String gender;

    public Female() {

    }

    public Female(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
