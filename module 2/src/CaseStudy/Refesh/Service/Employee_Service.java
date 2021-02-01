package CaseStudy.Refesh.Service;

import CaseStudy.Refesh.Common.Read_Write_File;
import CaseStudy.Refesh.Models.Employee;

import java.util.Map;
import java.util.TreeMap;

public class Employee_Service {
     static Map<Integer, Employee> employeeMap = new TreeMap<>();
     static final String PATH = "E:\\DATA\\A0920I1--LeTuanAnh\\module 2\\src\\CaseStudy\\Refesh\\Data\\Employee.csv";
   public static void show_Information_Of_Employee() {
        employeeMap.put(1,new Employee("Le A",20,"DN"));
        employeeMap.put(2,new Employee("Le B",20,"DN"));
        employeeMap.put(3,new Employee("Le C",20,"DN"));
        employeeMap.put(4,new Employee("Le D",20,"DN"));
        employeeMap.put(5,new Employee("Le F",20,"DN"));
        employeeMap.put(6,new Employee("Le G",20,"DN"));
        employeeMap.put(7,new Employee("Le H",20,"DN"));
        employeeMap.put(8,new Employee("Le I",20,"DN"));
        employeeMap.put(9,new Employee("Le K",20,"DN"));
        employeeMap.put(10,new Employee("Le L",20,"DN"));
        for (Integer value : employeeMap.keySet()){
             System.out.println(value+" " + employeeMap.get(value));
             Read_Write_File.write_File(PATH,employeeMap.get(value).toString());
        }
        System.out.println("---------------");

    }
}
