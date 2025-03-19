package com.lipanpan.website.entity;

public class LombokTest {

    public static void main(String[] args) {
        User user = new User();
        user.setName("Alice");
        user.setAge(30);

        System.out.println(user.getName()); // 输出：Alice
        System.out.println(user.getAge());  // 输出：30
        System.out.println(user.toString()); // 输出：User(name=Alice, age=30)
    }

}
