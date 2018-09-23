package com.ovo.bean;

public class Comments_like {
    
	private int actsId;

    private int commentsId;

    private String newsId;

    private String usersId;

    public int getActsId() {
		return actsId;
	}

	public void setActsId(int actsId) {
		this.actsId = actsId;
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
}