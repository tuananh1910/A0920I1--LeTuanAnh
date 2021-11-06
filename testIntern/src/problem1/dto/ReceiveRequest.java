package problem1.dto;

import java.util.List;

public class ReceiveRequest {
    private  List listReq;

    public ReceiveRequest() {
    }

    public ReceiveRequest(List listReq) {
        this.listReq = listReq;
    }

    public List getListReq() {
        return listReq;
    }

    public void setListReq(List listReq) {
        this.listReq = listReq;
    }
}
