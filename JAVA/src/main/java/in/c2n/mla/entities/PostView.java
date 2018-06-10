package in.c2n.mla.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POST_VIEW")
public class PostView implements java.io.Serializable {

	private int id;
	private String description;
	private String imageUrls;
	private String videoUrls;
	private Date postTime;
	private long totalLikesCount;
	private long totalDislikesCount;

	@Id
	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "DESCRIPTION", nullable = false, length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "IMAGE_URLS", nullable = false, length = 65535)
	public String getImageUrls() {
		return this.imageUrls;
	}

	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}

	@Column(name = "VIDEO_URLS", nullable = false, length = 65535)
	public String getVideoUrls() {
		return this.videoUrls;
	}

	public void setVideoUrls(String videoUrls) {
		this.videoUrls = videoUrls;
	}

	@Column(name = "POST_TIME", nullable = false, length = 19)
	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
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

}