package Sample_Day10_Programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User {
    public int age;
    public String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}

public class Comparator_Program {
    public static void main(String[] args) {

        Comparator<User> ageComparator = new Comparator<User>() {
            public int compare(User u1, User u2) {
                if (u1.age > u2.age)
                    return 1;
                else
                    return -1;
            }
        };

        List<User> userList = new ArrayList<>();
        userList.add(new User(22, "Alice"));
        userList.add(new User(24, "Bob"));
        userList.add(new User(23, "Charlie"));

        Collections.sort(userList, ageComparator);

        for (User user : userList) {
            System.out.println(user);
        }
    }
}
