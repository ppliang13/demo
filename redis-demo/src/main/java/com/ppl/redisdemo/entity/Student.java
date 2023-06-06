package com.ppl.redisdemo.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pisiliang on 2023/6/6 16:46
 */
public class Student {

    private String name;
    private Integer age;
    private Boolean sex;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Student> randomList(int size){
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Student student = new Student();
            student.setDate(randomDate(size));
            student.setSex(size%3==1);
            student.setAge(size);
            student.setName("小"+size);
            list.add(student);
        }
        return list;
    }

    private Date randomDate(int size){
        LocalDateTime dateTime = LocalDateTime.now().minus(Duration.ofDays(size*10));
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
