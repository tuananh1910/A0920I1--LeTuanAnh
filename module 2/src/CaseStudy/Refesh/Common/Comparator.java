package CaseStudy.Refesh.Common;

public class Comparator implements java.util.Comparator<CaseStudy.Refesh.Models.Customer> {

    @Override
    public int compare(CaseStudy.Refesh.Models.Customer o1, CaseStudy.Refesh.Models.Customer o2) {
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
