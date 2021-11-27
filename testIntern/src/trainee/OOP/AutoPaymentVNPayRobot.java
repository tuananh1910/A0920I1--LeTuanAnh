package trainee.OOP;

public class AutoPaymentVNPayRobot extends RobotTemplate{
    private String name;

    public AutoPaymentVNPayRobot(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public String confirmFormPayment()
    {
        return "Confirm payment with VNPay...";
    }

    public String makePayment()
    {
        return "In progress payment with VNPay...";
    }
    public String completePayment()
    {
        return "Complete payment with VNPay...";
    }
}
