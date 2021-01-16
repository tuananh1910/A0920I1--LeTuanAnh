package CaseStudy.Task_1.Controllers;

import CaseStudy.Task_1.Controllers.User_Exception.Birthday_Exception;
import CaseStudy.Task_1.Models.Customer.Customer;

public class Comparator implements java.util.Comparator<Customer> {
    Birthday_Exception birthday_exception = new Birthday_Exception();
    @Override
    public int compare(Customer o1, Customer o2) {
        String date_1;
        String date_2;
        date_1=o1.getDate();
        date_2=o2.getDate();
        String[] getYear1;
        String[] getYear2;
        int getYear_1 = 0;
        int getYear_2 = 0;
        if (date_1.contains("/")){
           getYear1= date_1.split("/");
           getYear_1 = Integer.parseInt(getYear1[2]);
           getYear2=date_2.split("/");
           getYear_2=Integer.parseInt(getYear2[2]);
        }
        if (date_1.contains("-")){
            getYear1= date_1.split("/");
            getYear_1 = Integer.parseInt(getYear1[2]);
            getYear2=date_2.split("/");
            getYear_2=Integer.parseInt(getYear2[2]);
        }
        if (date_1.contains(".")){
            getYear1= date_1.split("/");
            getYear_1 = Integer.parseInt(getYear1[2]);
            getYear2=date_2.split("/");
            getYear_2=Integer.parseInt(getYear2[2]);
        }
        System.out.println(getYear_1);
        System.out.println(getYear_2);
        if (o1.getName().equals(o2.getName())){
            return getYear_1-getYear_2;
        }
        return o1.getName().compareTo(o2.getName());
    }

}
