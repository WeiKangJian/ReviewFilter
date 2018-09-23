package com.ovo.bean;

import java.util.Date;

public class Comments {
    private int commentsId;
    private String commentsTd1;

    public String getCommentsTd1() {
		return commentsTd1;
	}

	public void setCommentsTd1(String commentsTd1) {
		this.commentsTd1 = commentsTd1;
	}
	
	private String newstitle;
	
	public String getNewstitle() {
		return newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public String getCommentTime1() {
		return commentTime1;
	}

	public void setCommentTime1(String commentTime1) {
		this.commentTime1 = commentTime1;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String commentTime1;
	
	private String username;
	
	private String newsId;

    private String commentContent;

    private String usersId;

    private Date commentTime;

    private Integer likes;
    
    private String commentType;

    public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

	public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public int getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(int commentsId) {
        this.commentsId = commentsId;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId == null ? null : newsId.trim();
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId == null ? null : usersId.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
