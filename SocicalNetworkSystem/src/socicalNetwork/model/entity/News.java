package socicalNetwork.model.entity;

import trainee.socicalNetwork.common.PlaceShare;

import java.util.List;

public class News {
    private Long id;
    private String content;

    // OneToOne
    private Account account;

    // OneToMany (mappedBy = news)
    private List<Like> likes;

    // OneToMany (mappedBy = news)
    private List<Comment> comments;

    private PlaceShare placeShare;

    private Account shareByAccount;

    // constructor
    public News() {
    }

    public News(Long id, String content, Account account,
                List<Like> likes, List<Comment> comments,
                PlaceShare placeShare, Account shareByAccount) {
        this.id = id;
        this.content = content;
        this.account = account;
        this.likes = likes;
        this.comments = comments;
        this.placeShare = placeShare;
        this.shareByAccount = shareByAccount;
    }

    // getter setter

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public PlaceShare getPlaceShare() {
        return placeShare;
    }

    public void setPlaceShare(PlaceShare placeShare) {
        this.placeShare = placeShare;
    }

    public Account getShareByAccount() {
        return shareByAccount;
    }

    public void setShareByAccount(Account shareByAccount) {
        this.shareByAccount = shareByAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
