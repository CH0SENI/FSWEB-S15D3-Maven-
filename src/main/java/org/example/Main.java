package org.example;

import org.example.entity.Employee;
import java.util.*;

public class Main {

    public static LinkedList<Employee> employees = new LinkedList<>(Arrays.asList(
            new Employee(1, "Dogancan", "Yılmaz"),
            new Employee(2, "Ali", "Demir"),
            new Employee(3, "Ayşe", "Kara"),
            new Employee(1, "Dogancan", "Yılmaz"), // duplicate
            new Employee(2, "Ali", "Demir"),       // duplicate
            new Employee(1, "Dogancan", "Yılmaz"), // duplicate
            new Employee(4, "Burak", "Çelik")      // tek geçen
    ));

    public static void main(String[] args) {
        System.out.println("Tüm çalışanlar: " + employees);
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Map<Employee, Integer> countMap = new LinkedHashMap<>();
        for (Employee e : list) {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        }

        List<Employee> duplicates = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                for (int i = 0; i < entry.getValue(); i++) duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> map = new LinkedHashMap<>();
        for (Employee e : list) {
            map.putIfAbsent(e.getId(), e);
        }
        return map;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Employee, Integer> countMap = new LinkedHashMap<>();
        for (Employee e : list) {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        }

        List<Employee> unique = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) unique.add(entry.getKey());
        }
        return unique;
    }
}
