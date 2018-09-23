package com.ovo.bean;

import java.util.Date;

public class News {
    private String newsId;

    private String title;

    private Date realseTime;

    private Integer newsType;

    private String newsContent;

    private Integer likes;

    private Integer collectonNum;

    private Integer sharingNum;

    private Integer commentNum;
    
    private String newsType1;
    
    private String realseTime1;

    public String getRealseTime1() {
		return realseTime1;
	}

	public void setRealseTime1(String realseTime1) {
		this.realseTime1 = realseTime1;
	}

	public String getNewsType1() {
		return newsType1;
	}

	public void setNewsType1(String newsType1) {
		this.newsType1 = newsType1;
	}

	public String getNewsId() {
        return newsId;
    }
    
    public void setNewsId(String newsId) {
        this.newsId = newsId == null ? null : newsId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getRealseTime() {
        return realseTime;
    }

    public void setRealseTime(Date realseTime) {
        this.realseTime = realseTime;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getCollectonNum() {
        return collectonNum;
    }

    public void setCollectonNum(Integer collectonNum) {
        this.collectonNum = collectonNum;
    }

    public Integer getSharingNum() {
        return sharingNum;
    }

    public void setSharingNum(Integer sharingNum) {
        this.sharingNum = sharingNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
}