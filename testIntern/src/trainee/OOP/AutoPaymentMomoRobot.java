package trainee.OOP;

public class AutoPaymentMomoRobot extends RobotTemplate{
    private String name;

    public AutoPaymentMomoRobot(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public String confirmFormPayment()
    {
        return "Confirm payment with MOMO...";
    }

    public String makePayment()
    {
        return "In progress payment with MOMO...";
    }
    public String completePayment()
    {
        return "Complete payment with MOMO...";
    }
}
