package in.c2n.mla.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POST_SHARES")
public class PostShares implements java.io.Serializable {

	private String postId;
	private int shareCount;

	@Id
	@Column(name = "POST_ID", nullable = false)
	public String getPostId() {
		return this.postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	@Column(name = "SHARE_COUNT", nullable = false)
	public int getShareCount() {
		return this.shareCount;
	}

	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}
}