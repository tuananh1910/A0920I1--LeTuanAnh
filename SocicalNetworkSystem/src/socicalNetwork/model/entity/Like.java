package socicalNetwork.model.entity;

import trainee.socicalNetwork.common.Reaction;

public class Like {
    private Long id;
    private Reaction reaction;

    // ManyToOne
    // @JoinColumn(name = "account_id" , referencedColumnName = "id")
    private Account account;

    // ManyToOne
    // @JoinColumn(name = "news_id" , referencedColumnName = "id")
    private News news;

    // ManyToOne
    // @JoinColumn(name = "comment_id" , referencedColumnName = "id")
    private Comment comment;


    // constructor
    public Like() {
    }

    public Like(Long id, Reaction reaction, Account account, News news, Comment comment) {
        this.id = id;
        this.reaction = reaction;
        this.account = account;
        this.news = news;
        this.comment = comment;
    }

    // getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }


}
