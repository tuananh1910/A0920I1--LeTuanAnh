package trainee.socicalNetwork.model.dto;

public class PostNewsRequest {
    private Long idAccount;
    private String content;

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostNewsRequest() {
    }

    public PostNewsRequest(Long idAccount, String content) {
        this.idAccount = idAccount;
        this.content = content;
    }
}
