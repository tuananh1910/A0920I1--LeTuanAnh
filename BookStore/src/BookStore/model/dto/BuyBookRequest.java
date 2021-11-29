package BookStore.model.dto;

public class BuyBookRequest {
    private Long idBook;
    private Long idAccount;
    private Long idPayment;
    private String receivingAddress;

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public Long getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Long idPayment) {
        this.idPayment = idPayment;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public BuyBookRequest() {
    }

    public BuyBookRequest(Long idBook, Long idAccount, Long idPayment, String receivingAddress) {
        this.idBook = idBook;
        this.idAccount = idAccount;
        this.idPayment = idPayment;
        this.receivingAddress = receivingAddress;
    }
}
