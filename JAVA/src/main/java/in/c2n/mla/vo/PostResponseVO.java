package in.c2n.mla.vo;

import java.util.ArrayList;
import java.util.List;

import in.c2n.mla.entities.PostLikesView;
import in.c2n.mla.entities.PostView;

public class PostResponseVO {
	private List<PostView> posts = new ArrayList<PostView>();
	private List<PostLikesView> likes = new ArrayList<PostLikesView>();

	public List<PostView> getPosts() {
		return posts;
	}

	public void setPosts(List<PostView> posts) {
		this.posts = posts;
	}

	public List<PostLikesView> getLikes() {
		return likes;
	}

	public void setLikes(List<PostLikesView> likes) {
		this.likes = likes;
	}
}