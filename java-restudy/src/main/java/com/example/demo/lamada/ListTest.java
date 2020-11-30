package com.example.demo.lamada;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListTest {

    public static List<User> userList=new ArrayList<>();

    static {
        for (int i = 0; i < 12; i++) {
            userList.add(new User.UserBuilder().id(i+1).age(i+1).name("kk"+i).build());
        }
    }

    public static void main(String[] args) {
        List<Integer> ages= Arrays.asList(3,6,2);
        StringBuilder ids = new StringBuilder();
        userList.stream().filter(user -> ages.contains(user.getAge())).map(User::getId).forEach(id->ids.append(id).append(";"));

        System.out.println(ids);
        Map map=userList.stream().collect(Collectors.toMap(User::getId, user -> user));

        map.forEach((key,value)->{
            System.out.println(key+":"+value);
        });
    }

}

@Builder
@Data
class User{
    int id;
    String name;
    int age;
    String email;
}
