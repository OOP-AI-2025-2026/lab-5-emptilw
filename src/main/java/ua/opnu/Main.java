package ua.opnu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Перше завдання:\n");
        // --- Тест конструкторів ---
        TimeSpan t1 = new TimeSpan();                  // 0 год, 0 хв
        TimeSpan t2 = new TimeSpan(75);                // 1 год 15 хв
        TimeSpan t3 = new TimeSpan(2, 50);             // 2 год 50 хв
        TimeSpan t4 = new TimeSpan(t3);                // копія t3

        System.out.println("Конструктори:");
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
        System.out.println("t3: " + t3);
        System.out.println("t4: " + t4);
        System.out.println();

        // --- Тест додавання ---
        t1.add(1, 45);           // додати 1 год 45 хв
        t2.add(30);              // додати 30 хв
        t3.add(t2);              // додати t2 (1 год 45 хв + 2 год 50 хв = 4 год 35 хв)

        System.out.println("Після додавання:");
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
        System.out.println("t3: " + t3);
        System.out.println();

        // --- Тест віднімання ---
        t1.subtract(0, 50);      // відняти 50 хв
        t2.subtract(90);         // відняти 90 хв
        t3.subtract(t4);         // відняти t4 (2 год 50 хв)

        System.out.println("Після віднімання:");
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
        System.out.println("t3: " + t3);
        System.out.println();

        // --- Тест getTotalHours та getTotalMinutes ---
        System.out.println("Загальні значення:");
        System.out.printf("t1: %.2f год, %d хв\n", t1.getTotalHours(), t1.getTotalMinutes());
        System.out.printf("t2: %.2f год, %d хв\n", t2.getTotalHours(), t2.getTotalMinutes());
        System.out.printf("t3: %.2f год, %d хв\n", t3.getTotalHours(), t3.getTotalMinutes());
        System.out.println();

        System.out.println("Друге завдання:\n");
        Person p1 = new Person("Коваленко", "Ірина", 45);
        Student s1 = new Student("Петренко", "Олег", 19, "ІТ-12", "ST12345");
        Lecturer l1 = new Lecturer("Мельник", "Світлана", 38, "Інформатика", 25000);

        // Висхідне перетворення: всі зберігаються як Person
        Person[] people = {p1, s1, l1, new Student("Шевченко", "Анна", 20, "ІТ-14", "ST54321")};

        // Виведення інформації
        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}