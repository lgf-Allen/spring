/**
 * 
 */
package com.allen.spring.jms.vo;

import java.util.Date;

/**
 * @author first
 *
 */
public class Response {

    private String name;
    private String message;
    private Date date;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Response [name=" + name + ", message=" + message + ", date=" + date + "]";
    }
}
