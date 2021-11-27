package trainee.OOP;

public class main {
    public static void main(String[] args) {
        RobotTemplate autoPaymentMomoRobot = new AutoPaymentMomoRobot("Robot Payment Momo");
        RobotTemplate autoPaymentVNPayRobot = new AutoPaymentVNPayRobot("Robot Payment VNPay");
        autoPaymentMomoRobot.payment();
        autoPaymentVNPayRobot.payment();
    }
}
