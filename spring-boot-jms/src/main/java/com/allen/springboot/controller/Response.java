/**
 * 
 */
package com.allen.springboot.controller;

/**
 * @author first
 *
 */
public class Response {

    private String message;
    private String name;
    
    public Response() {

    }
    
    public Response(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
