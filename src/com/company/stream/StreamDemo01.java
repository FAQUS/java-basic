package com.company.stream;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yull
 * @date 2024-07-31 21:20
 */
public class StreamDemo01 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(LocalDateTime.of(2024, 7, 30, 12, 10,12)));
        users.add(new User(LocalDateTime.of(2024, 7, 29, 12, 0,12)));
        users.add(new User(LocalDateTime.of(2024, 7, 31, 12, 0,12)));
        users.add(new User(LocalDateTime.of(2024, 7, 31, 12, 0,11)));
        users.add(new User(null));

        List<User> collect1 = users.stream().sorted(Comparator.comparing(User::getCrateTime, Comparator.nullsFirst(Comparator.naturalOrder())).reversed()).collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);
        List<User> collect = users.stream().sorted(Comparator.comparing(User::getCrateTime)).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

}
class User{
    private LocalDateTime crateTime;

    public LocalDateTime getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(LocalDateTime crateTime) {
        this.crateTime = crateTime;
    }

    public User(LocalDateTime crateTime) {
        this.crateTime = crateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "crateTime=" + crateTime +
                '}';
    }
}

