package ru.geekbrains.javahomework.homework4;


/*
1.Создать класс "Сотрудник" с полями: ФИО, зарплата, возраст;
2.Конструктор класса должен заполнять эти поля при создании объекта;
3.Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
4.Вывести при помощи методов из пункта 3 ФИО и возраст.
5.Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
* 6.Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
* 7. Подсчитать средние арифметические зарплаты и возраста
*** 8. Продумать конструктор таким образом, чтобы при создании каждому
сотруднику присваивался личный уникальный идентификационный порядковый номер
*/
public class Homework4 {


    public static void main(String[] args) {

        Employee employee = new Employee("Test User", 100500, 1980);
        System.out.printf("Employee %s is %d years old. \n", employee.getFullName(), employee.getAge());

        Employee[] employees = getEmployees();
        printOlderThan(employees, 40);
        increaseSalaryToOlderThanAge(employees, 45, 5000);

        System.out.printf("Average age is %f and average salary is %f $",
                getAverageAge(employees),
                getAverageSalary(employees));
    }

    private static Employee[] getEmployees() {
        final int ARRAY_SIZE = 5;
        Employee[] employees = new Employee[ARRAY_SIZE];

        employees[0] = new Employee("Ivanov Ivan", 1000, 2000);
        employees[1] = new Employee("Petrov Petr", 1200, 1991);
        employees[2] = new Employee("Sidorov Sidr", 2000, 1990);
        employees[3] = new Employee("Vasiliev Vasily", 2300, 1980);
        employees[4] = new Employee("Grachev Grach", 2500, 1969);
        return employees;
    }

    private static void printOlderThan(Employee[] employees, int age) {
        for (Employee employee : employees) {
            if (employee.getAge() >= age) System.out.println(employee.toString());
        }
    }

    private static void increaseSalaryToOlderThanAge(Employee[] employees, int age, double amount) {
        for (Employee employee : employees) {
            if (employee.getAge() >= age) {
                employee.increaseSalary(amount);
            }
        }
    }

    private static double getAverageSalary(Employee[] employees) {
        double salary = 0;
        for (Employee employee1 : employees) {
            salary += employee1.getSalary();
        }
        return salary / employees.length;
    }

    private static double getAverageAge(Employee[] employees) {
        double age = 0;
        for (Employee employee1 : employees) {
            age += employee1.getAge();
        }
        return age / employees.length;
    }
}
