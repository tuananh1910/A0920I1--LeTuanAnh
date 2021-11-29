package BookStore.service;

public interface IPaymentService {
    void payment(); // return QR code
    boolean confirmPayment();  // confirm payment with scan QR code
}
