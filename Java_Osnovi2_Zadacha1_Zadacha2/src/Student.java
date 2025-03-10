import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private String gender;

    // Обычный конструктор
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
    }

    // Конструктор с параметрами
    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Конструктор через билдер
    public static class Builder {
        private String name;
        private int age;
        private String gender;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Student build() {
            return new Student(name, age, gender);
        }
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}