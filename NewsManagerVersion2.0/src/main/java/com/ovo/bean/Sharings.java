package com.ovo.bean;

import java.util.Date;

public class Sharings {
    private int sharingsId;

    public int getSharingsId() {
		return sharingsId;
	}

	public void setSharingsId(int sharingsId) {
		this.sharingsId = sharingsId;
	}

	private String newsId;

    private Date sharingsTime;


    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId == null ? null : newsId.trim();
    }

    public Date getSharingsTime() {
        return sharingsTime;
    }

    public void setSharingsTime(Date sharingsTime) {
        this.sharingsTime = sharingsTime;
    }
}