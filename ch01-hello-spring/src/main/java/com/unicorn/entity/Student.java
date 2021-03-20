package com.unicorn.entity;

public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("调用了Student类的空参构造器");
    }

    public Student(String name, Integer age) {
        System.out.println("调用了Student类的带参构造器");
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        System.out.println("调用了Student对象的setName方法: "+name);
        this.name = name;
    }

    public void setAge(Integer age) {
        System.out.println("调用了Student对象的setAge方法: "+age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
