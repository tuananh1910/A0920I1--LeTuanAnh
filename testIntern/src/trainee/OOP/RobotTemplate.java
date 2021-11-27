package trainee.OOP;

public abstract class RobotTemplate {
    public void payment()
    {
        this.start();
        this.confirmFormPayment();
        this.makePayment();
        this.completePayment();
        this.stop();
    }

    public String start()
    {
        return "Starting ...";
    }

    public String confirmFormPayment()
    {
        return "Confirm Payment...";
    }

    public String makePayment()
    {
        return "In progress payment...";
    }

    public String completePayment()
    {
        return "Complete payment...";
    }

    public String stop()
    {
        return "Stopping...";
    }
}
