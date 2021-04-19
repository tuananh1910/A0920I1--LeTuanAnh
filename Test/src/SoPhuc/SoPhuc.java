package SoPhuc;

public class SoPhuc {
        private double number_1_of_complex_1;
    private double number_2_of_complex_1;
    private double number_1_of_complex_2;
    private double number_2_of_complex_2;

    public SoPhuc(){}
    public SoPhuc(double number_1_of_complex_1, double number_2_of_complex_1, double number_1_of_complex_2, double number_2_of_complex_2) {
        this.number_1_of_complex_1 = number_1_of_complex_1;
        this.number_2_of_complex_1 = number_2_of_complex_1;
        this.number_1_of_complex_2 = number_1_of_complex_2;
        this.number_2_of_complex_2 = number_2_of_complex_2;
    }

    public double getNumber_1_of_complex_1() {
        return number_1_of_complex_1;
    }

    public void setNumber_1_of_complex_1(double number_1_of_complex_1) {
        this.number_1_of_complex_1 = number_1_of_complex_1;
    }

    public double getNumber_2_of_complex_1() {
        return number_2_of_complex_1;
    }

    public void setNumber_2_of_complex_1(double number_2_of_complex_1) {
        this.number_2_of_complex_1 = number_2_of_complex_1;
    }

    public double getNumber_1_of_complex_2() {
        return number_1_of_complex_2;
    }

    public void setNumber_1_of_complex_2(double number_1_of_complex_2) {
        this.number_1_of_complex_2 = number_1_of_complex_2;
    }

    public double getNumber_2_of_complex_2() {
        return number_2_of_complex_2;
    }

    public void setNumber_2_of_complex_2(double number_2_of_complex_2) {
        this.number_2_of_complex_2 = number_2_of_complex_2;
    }

    public String addComplex(double number_1_of_complex_1,double number_2_of_complex_1,
                            double number_1_of_complex_2, double number_2_of_complex_2){
        return (number_1_of_complex_1+number_1_of_complex_2)+"+"+(number_2_of_complex_1+number_2_of_complex_2)+"i";
    }
}
