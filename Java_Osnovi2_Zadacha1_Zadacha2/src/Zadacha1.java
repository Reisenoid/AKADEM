import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadacha1 {
    public static void main(String[] args) {
        // Создаем список студентов
        List<Student> students = new ArrayList<>();
        students.add(new Student("Алиса", 29, "Жен"));
        students.add(new Student("Дмитрий", 19, "Муж"));
        students.add(new Student("Некич", 19, "Муж"));
        students.add(new Student("Дорош", 19, "Муж"));

        // Записываем студентов в файл
        String fileName = "students.dat";
        writeStudentsToFile(students, fileName);

        // Считываем студентов из файла
        List<Student> loadedStudents = readStudentsFromFile(fileName);

        // Запрашиваем у пользователя пол для фильтрации
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пол для фильтрации (Муж/Жен): ");
        String genderFilter = scanner.nextLine();

        // Выводим студентов выбранного пола
        System.out.println("Студенты с полом " + genderFilter + ":");
        for (Student student : loadedStudents) {
            if (student.getGender().equalsIgnoreCase(genderFilter)) {
                System.out.println(student);
            }
        }
    }

    // Метод для записи списка студентов в файл
    private static void writeStudentsToFile(List<Student> students, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
            System.out.println("Список студентов записан в файл: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения списка студентов из файла
    private static List<Student> readStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Список студентов загружен из файла: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}