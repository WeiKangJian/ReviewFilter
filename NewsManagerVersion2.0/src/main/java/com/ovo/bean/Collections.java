package com.ovo.bean;

import java.util.Date;

public class Collections {
    private int collectionsId;

    public int getCollectionsId() {
		return collectionsId;
	}

	public void setCollectionsId(int collectionsId) {
		this.collectionsId = collectionsId;
	}

	private String newsId;

    private String usersId;

    private Date conllectionsTime;

    

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

    public Date getConllectionsTime() {
        return conllectionsTime;
    }

    public void setConllectionsTime(Date conllectionsTime) {
        this.conllectionsTime = conllectionsTime;
    }
}