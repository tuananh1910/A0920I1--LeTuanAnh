package trainee.socicalNetwork.service;

import trainee.socicalNetwork.model.dto.LikeRequest;

public interface ILikeService {
    void likeNewsRequest(LikeRequest likeRequest);

    void likeCommentRequest(LikeRequest likeRequest);
}
