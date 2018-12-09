package com.allen.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by meng on 2018/12/9.
 */
@Service
public class BeanService {
    @Autowired
    Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
