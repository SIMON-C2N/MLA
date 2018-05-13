package in.c2n.mla.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POST_IMAGE")
public class PostImage implements java.io.Serializable {

	private int postId;
	private String imageUrl;

	@Id
	@Column(name = "POST_ID", nullable = false)
	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Column(name = "IMAGE_URL", nullable = false, length = 500)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
