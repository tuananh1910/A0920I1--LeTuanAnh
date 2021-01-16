package CaseStudy.Task_1.Controllers.User_Exception;

public class Gender_Exception {


    public boolean gender_Exeption(String gender)  {
        String format_Gender = gender.toLowerCase();
        String female = "female";
        String male = "male";
        String unknow = "unknow";
        return (format_Gender.equals(female)) ||
                (format_Gender.equals(male)) ||
                (format_Gender.equals(unknow));
    }
}
