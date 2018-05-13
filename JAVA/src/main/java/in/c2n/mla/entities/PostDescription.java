package in.c2n.mla.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POST_DESCRIPTION")
public class PostDescription implements java.io.Serializable {

	private int postId;
	private String description;

	@Id
	@Column(name = "POST_ID", nullable = false)
	public int getPostId() {
		return this.postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Column(name = "DESCRIPTION", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}