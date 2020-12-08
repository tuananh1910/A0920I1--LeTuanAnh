package _04_class_object.rectangle.quadraticEquation;

public class QuadraticEquation {
    private double a,b,c;
    public QuadraticEquation(double a, double b, double c){
        this.a =a;
        this.b=b;
        this.c=c;
    }
    public double getA(){
        return this.a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant(){
        double delta = (b*b) - (4*a*c);
        return delta;
    }
    public double getRoot1(){
        double r1= ((-b+Math.sqrt
                (b*b-(4*a*c)))/2*a);

        return r1;
    }
    public double getRoot2(){
        double r2= ((-b-Math.sqrt
                (b*b-(4*a*c)))/2*a);
        return r2;
    }

    public double get(){
        double g = -(this.b/2*this.a);
        return g;
    }
}
