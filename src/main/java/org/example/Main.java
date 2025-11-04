package org.example;

import org.example.entity.Employee;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Ali", "Demir"));
        employees.add(new Employee(2, "Ayşe", "Kara"));
        employees.add(new Employee(3, "Fatma", "Yılmaz"));
        employees.add(new Employee(1, "Ali", "Demir")); // duplicate
        employees.add(new Employee(2, "Ayşe", "Kara")); // duplicate
        employees.add(new Employee(4, "Ahmet", "Çelik"));

        System.out.println("Tüm çalışanlar: " + employees);

        System.out.println("Tekrar eden çalışanlar:");
        System.out.println(findDuplicates(employees));

        System.out.println("Tekrar edenlerden biri + uniqueler:");
        System.out.println(findUniques(employees));

        System.out.println("Sadece unique çalışanlar (tekrar edenler çıkarıldı):");
        System.out.println(removeDuplicates(employees));
    }

    // Tekrar eden çalışanlar döngüsü
    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee e : list) {
            if (!seen.add(e)) { // add false dönerse zaten var
                duplicates.add(e);
            }
        }
        return duplicates;
    }

    // Tekrar edenlerden sadece birini + uniqueleri döndüren dönngü
    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Set<Integer> duplicateIds = new HashSet<>();

        for (Employee e : list) {
            if (uniqueMap.containsKey(e.getId())) {
                duplicateIds.add(e.getId());
            } else {
                uniqueMap.put(e.getId(), e);
            }
        }

        // duplicate id’ler zaten map’te bir kez var
        return uniqueMap;
    }

    // Sadece tek geçen çalışanları getiren döngü
    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Employee, Integer> countMap = new HashMap<>();

        for (Employee e : list) {
            countMap.put(e, countMap.getOrDefault(e, 0) + 1);
        }

        List<Employee> onlyUnique = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                onlyUnique.add(entry.getKey());
            }
        }
        return onlyUnique;
    }
}
