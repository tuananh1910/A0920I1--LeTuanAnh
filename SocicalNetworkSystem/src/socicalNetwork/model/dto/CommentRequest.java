package socicalNetwork.model.dto;

public class CommentRequest {
    private Long idAccount;
    private String content;
    private Long idNews;
    private Long idComment;

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

    public Long getIdNews() {
        return idNews;
    }

    public void setIdNews(Long idNews) {
        this.idNews = idNews;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public CommentRequest(Long idAccount, String content, Long idNews, Long idComment) {
        this.idAccount = idAccount;
        this.content = content;
        this.idNews = idNews;
        this.idComment = idComment;
    }

    public CommentRequest() {
    }
}
