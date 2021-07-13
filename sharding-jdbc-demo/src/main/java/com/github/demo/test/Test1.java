package com.github.demo.test;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        // 构建A数组
        User[] users=new User[5];
        // 创建5个人，并实例化
        User u1 = new User(1,"david");
        User u2 = new User(2,"alin");
        User u3 = new User(3,"ming");
        User u4 = new User(4,"lili");
        User u5 = new User(5,"amy");
        users[0]=u1;
        users[1]=u2;
        users[2]=u3;
        users[3]=u4;
        users[4]=u5;

        // 构建B数组
        int[] arr=new int[]{5,1,4,3,2};

        Integer select=0;
        for (int i = 0; i < arr.length; i++) {
            select=arr[i]; //5 1 4 3 2
            for (int j = 0; j < users.length; j++) {
                if (users[j].getId().equals(select)){
                    // 将用户交换到对应位置
                    User temp=users[j];
                    users[j]=users[i];
                    users[i]=temp;
                }

            }
        }
        // 结果打印
        Arrays.stream(users).forEach(System.out::println);
    }
}

class User{
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
