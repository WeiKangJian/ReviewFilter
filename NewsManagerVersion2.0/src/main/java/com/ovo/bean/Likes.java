package com.ovo.bean;

import java.util.Date;

public class Likes {
	private int likesId;

    private String newsId;

    private String usersId;

    private Date likesTime;

    public int getLikesId() {
		return likesId;
	}

	public void setLikesId(int likesId) {
		this.likesId = likesId;
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

    public Date getLikesTime() {
        return likesTime;
    }

    public void setLikesTime(Date likesTime) {
        this.likesTime = likesTime;
    }
}