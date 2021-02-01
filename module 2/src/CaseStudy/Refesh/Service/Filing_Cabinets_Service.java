package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Models.Employee;

import java.util.Scanner;
import java.util.Stack;

public class Filing_Cabinets_Service {
    static Stack<Employee> employees = new Stack<>();

    public static void main(String[] args) {
        System.out.println("Enter name you would like to find : ");
        employees.push(new Employee("A",18,"zxc"));
        employees.push(new Employee("B",20,"qweqew"));
        Scanner  scanner = new Scanner(System.in);
        String name = scanner.nextLine();
//        Stack<Employee> employeeStack = search(new Employee(name,0,"zxczxc"));
//        System.out.println(employeeStack.pop());
        search(new Employee(name,18,"zxczxc"));

    }
    public static void search(Employee e){
        Stack<Employee> employeeStack = new Stack<>();
        Employee employee;
        int index = employees.search(e.getName()); // tra ve index tinh từ đỉnh.
        if (index==-1){
            System.out.println("Employee is not exist ");
        }else {
            int i=0;
            while (!employees.isEmpty()){
                employees.pop();
                if (index==i){
                    employee = employees.pop();
                    employeeStack.push(employee);
                    System.out.println(employeeStack.pop());
                }
                i++;
            }
        }
    }
}
