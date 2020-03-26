package com.example.whatspidemo.restudyjava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {

        List<User> users=User.init();

        Predicate<User> userPredicate=user -> user.getAge()>18&&user.getAge()<40;
        Predicate<User> userPredicate2=user -> user.getName().contains("k7");




        //System.out.println("user1 是否符合 "+userPredicate.and(userPredicate2).test(user1));
        //System.out.println("user2 是否符合 "+userPredicate.test(user2));


        // 用户增加2岁
        Function<User,User> function=user -> {
            if(userPredicate.test(user)){
                user.setAge(user.getAge()+2);
            }
            return user;
        };
        Function<User,User> function2=user -> {
            if(userPredicate2.test(user)){
                user.setAge(user.getAge()+3);
            }
            return user;
        };
        //User user3=function.apply(user1);
        //System.out.println(user3.getAge());

        //System.out.println("user4 加2岁后是否符合 "+userPredicate.test(function.apply(user4)));

        // 所有成员都加两岁
        users.forEach(user->
                System.out.println(user.getAge()+":"+function.andThen(function2).apply(user).getAge()));
    }


}

class User{
    String id;
    String name;
    int age;

    public User() {

    }

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     *  初始化用户列表
     * @return
     */
    public static List<User> init(){
       /* User user1=new User("1","kk",35);
        User user2=new User("2","ll",16);
        User user3=new User("3","kk",25);
        User user4=new User("4","ll",40);

        return Arrays.asList(user1,user2,user3,user4);*/

        List<User> users=new ArrayList<>();

        for (int i = 0; i < 88; i++) {
            User user=new User("no"+i,"kk"+i,i);
            users.add(user);
        }
        return users;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
