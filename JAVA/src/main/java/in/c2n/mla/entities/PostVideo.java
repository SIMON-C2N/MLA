package in.c2n.mla.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POST_VIDEO")
public class PostVideo implements java.io.Serializable {

	private int postId;
	private String videoUrl;

	@Id
	@Column(name = "POST_ID", nullable = false)
	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Column(name = "VIDEO_URL", nullable = false, length = 500)
	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
}