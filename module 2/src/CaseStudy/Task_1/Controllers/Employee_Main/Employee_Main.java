package CaseStudy.Task_1.Controllers.Employee_Main;

import CaseStudy.Task_1.Controllers.Write_Read_File.Write_Read_File;
import CaseStudy.Task_1.Models.Employee;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Employee_Main {
    Write_Read_File write_read_file = new Write_Read_File();
   public void show_Information_Of_Employee( Map<Integer, Employee> employees,final String PATH) throws IOException {
        employees.put(1,new Employee("Le A",20,"DN"));
        employees.put(2,new Employee("Le B",20,"DN"));
        employees.put(3,new Employee("Le C",20,"DN"));
        employees.put(4,new Employee("Le D",20,"DN"));
        employees.put(5,new Employee("Le F",20,"DN"));
        employees.put(6,new Employee("Le G",20,"DN"));
        employees.put(7,new Employee("Le H",20,"DN"));
        employees.put(8,new Employee("Le I",20,"DN"));
        employees.put(9,new Employee("Le K",20,"DN"));
        employees.put(10,new Employee("Le L",20,"DN"));
        System.out.println(PATH + "\\Employee.csv");
        write_read_file.write_File(PATH + "\\Employee.csv", employees.toString());
//        System.out.println(PATH + "\\Employee.csv");
        System.out.println(write_read_file.read_File(PATH + "\\Employee.csv"));
        System.out.println("---------------");
    }
}
