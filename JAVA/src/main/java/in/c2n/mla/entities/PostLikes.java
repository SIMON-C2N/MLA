package in.c2n.mla.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POST_LIKES")
public class PostLikes implements java.io.Serializable {

	private int postId;
	private int userId;
	private byte upDownVote;

	@Id
	@Column(name = "POST_ID", nullable = false)
	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Column(name = "USER_ID", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "UP_DOWN_VOTE", nullable = false)
	public byte getUpDownVote() {
		return this.upDownVote;
	}

	public void setUpDownVote(byte upDownVote) {
		this.upDownVote = upDownVote;
	}
}