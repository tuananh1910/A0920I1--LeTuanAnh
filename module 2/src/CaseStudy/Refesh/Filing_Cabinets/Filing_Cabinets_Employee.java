package CaseStudy.Refesh.Filing_Cabinets;

import CaseStudy.Refesh.Models.Employee;

import java.util.Scanner;
import java.util.Stack;

public class Filing_Cabinets_Employee {
    static Stack<Employee> employees = new Stack<>();

    public static void main(String[] args) {
//        System.out.println("Enter name you would like to find : ");
        Employee employee = new Employee("A", 18, "zxc");
        Employee employee1 = new Employee("B", 20, "qweqew");
        employees.push(employee);
        employees.push(employee1);
//        Scanner  scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        Stack<Employee> employeeStack = search(new Employee(name,0,"zxczxc"));
//        System.out.println(employeeStack.pop());
        search(employee);
    }

    public static void search(Employee e) {
        int index = employees.search(e); // tra ve index tinh từ đỉnh.
        if (index == -1) {
            System.out.println("Employee is not exist ");
        } else {
            int i = 1;
            while (!employees.isEmpty()) {
                if (i==index){
                    System.out.println(employees.pop());
                    break;
                }
                employees.pop();
                i++;
            }
        }
    }
}
