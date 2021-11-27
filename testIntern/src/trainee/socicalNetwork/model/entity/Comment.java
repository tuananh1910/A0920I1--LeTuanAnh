package trainee.socicalNetwork.model.entity;

import java.util.List;

public class Comment {
    private Long id;
    private String content;

    // OneToOne
    private Account account;

    // ManyToOne
    // @JoinColumn(name = "news_id" , referencedColumnName = "id")
    private News news;

    // OneToMany (mappedBy = likes)
    private List<Like> likes;

    // constructor
    public Comment() {
    }

    public Comment(Long id, String content, Account account, News news, List<Like> likes) {
        this.id = id;
        this.content = content;
        this.account = account;
        this.news = news;
        this.likes = likes;
    }

    //getter setter
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

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
}
