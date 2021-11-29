package socicalNetwork.service;

import trainee.socicalNetwork.model.dto.CommentRequest;

public interface ICommentService {
    void commentNews(CommentRequest cmtReq);

    void replyComment(CommentRequest cmtReq);
}
