package in.c2n.mla.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POST_LIKES_VIEW")
public class PostLikesView implements java.io.Serializable {

	private int id;
	private long totalLikesCount;
	private long totalDislikesCount;
	private Date postTime;

	@Id
	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TOTAL_LIKES_COUNT", nullable = false)
	public long getTotalLikesCount() {
		return this.totalLikesCount;
	}

	public void setTotalLikesCount(long totalLikesCount) {
		this.totalLikesCount = totalLikesCount;
	}

	@Column(name = "TOTAL_DISLIKES_COUNT", nullable = false)
	public long getTotalDislikesCount() {
		return this.totalDislikesCount;
	}

	public void setTotalDislikesCount(long totalDislikesCount) {
		this.totalDislikesCount = totalDislikesCount;
	}

	@Column(name = "POST_TIME", nullable = false, length = 19)
	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
}