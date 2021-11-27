package trainee.socicalNetwork.model.dto;

import trainee.socicalNetwork.common.Reaction;

public class LikeRequest {
    private Long idAccount;
    private Long idNews;
    private Reaction reaction;
    private Long idComment;

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public Long getIdNews() {
        return idNews;
    }

    public void setIdNews(Long idNews) {
        this.idNews = idNews;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public LikeRequest() {
    }

    public LikeRequest(Long idAccount, Long idNews, Reaction reaction, Long idComment) {
        this.idAccount = idAccount;
        this.idNews = idNews;
        this.reaction = reaction;
        this.idComment = idComment;
    }
}
