package socicalNetwork.model.dto;

public class ShareNewsRequest {
    private Long idAccount;
    private Long idNews;
    private String placeShare;

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

    public String getPlaceShare() {
        return placeShare;
    }

    public void setPlaceShare(String placeShare) {
        this.placeShare = placeShare;
    }

    public ShareNewsRequest() {
    }

    public ShareNewsRequest(Long idAccount, Long idNews, String placeShare) {
        this.idAccount = idAccount;
        this.idNews = idNews;
        this.placeShare = placeShare;
    }
}
