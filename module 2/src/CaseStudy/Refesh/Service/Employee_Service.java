package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Read_Write_File;
import CaseStudy.Task.Models.Employee;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Employee_Service {
     final static String PATH = "E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\Employee.csv";
     static Map<Integer, Employee> employee_List = new TreeMap<>();
   public static void show_Information_Of_Employee( ) {
        employee_List.put(1,new Employee("Le A",20,"DN"));
        employee_List.put(2,new Employee("Le B",20,"DN"));
        employee_List.put(3,new Employee("Le C",20,"DN"));
        employee_List.put(4,new Employee("Le D",20,"DN"));
        employee_List.put(5,new Employee("Le F",20,"DN"));
        employee_List.put(6,new Employee("Le G",20,"DN"));
        employee_List.put(7,new Employee("Le H",20,"DN"));
        employee_List.put(8,new Employee("Le I",20,"DN"));
        employee_List.put(9,new Employee("Le K",20,"DN"));
        employee_List.put(10,new Employee("Le L",20,"DN"));
        System.out.println(PATH );
        Read_Write_File.write_File(PATH, employee_List.toString());
        System.out.println(Read_Write_File.read_File(PATH ));
        System.out.println("---------------");
    }
}
