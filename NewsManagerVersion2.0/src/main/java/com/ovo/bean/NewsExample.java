package com.ovo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNewsIdIsNull() {
            addCriterion("news_ID is null");
            return (Criteria) this;
        }

        public Criteria andNewsIdIsNotNull() {
            addCriterion("news_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNewsIdEqualTo(String value) {
            addCriterion("news_ID =", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotEqualTo(String value) {
            addCriterion("news_ID <>", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThan(String value) {
            addCriterion("news_ID >", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThanOrEqualTo(String value) {
            addCriterion("news_ID >=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThan(String value) {
            addCriterion("news_ID <", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThanOrEqualTo(String value) {
            addCriterion("news_ID <=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLike(String value) {
            addCriterion("news_ID like", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotLike(String value) {
            addCriterion("news_ID not like", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdIn(List<String> values) {
            addCriterion("news_ID in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotIn(List<String> values) {
            addCriterion("news_ID not in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdBetween(String value1, String value2) {
            addCriterion("news_ID between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotBetween(String value1, String value2) {
            addCriterion("news_ID not between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andRealseTimeIsNull() {
            addCriterion("realse_time is null");
            return (Criteria) this;
        }

        public Criteria andRealseTimeIsNotNull() {
            addCriterion("realse_time is not null");
            return (Criteria) this;
        }

        public Criteria andRealseTimeEqualTo(Date value) {
            addCriterion("realse_time =", value, "realseTime");
            return (Criteria) this;
        }

        public Criteria andRealseTimeNotEqualTo(Date value) {
            addCriterion("realse_time <>", value, "realseTime");
            return (Criteria) this;
        }

        public Criteria andRealseTimeGreaterThan(Date value) {
            addCriterion("realse_time >", value, "realseTime");
            return (Criteria) this;
        }

        public Criteria andRealseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("realse_time >=", value, "realseTime");
            return (Criteria) this;
        }

        public Criteria andRealseTimeLessThan(Date value) {
            addCriterion("realse_time <", value, "realseTime");
            return (Criteria) this;
        }

        public Criteria andRealseTimeLessThanOrEqualTo(Date value) {
            addCriterion("realse_time <=", value, "realseTime");
            return (Criteria) this;
        }

        public Criteria andRealseTimeIn(List<Date> values) {
            addCriterion("realse_time in", values, "realseTime");
            return (Criteria) this;
        }

        public Criteria andRealseTimeNotIn(List<Date> values) {
            addCriterion("realse_time not in", values, "realseTime");
            return (Criteria) this;
        }

        public Criteria andRealseTimeBetween(Date value1, Date value2) {
            addCriterion("realse_time between", value1, value2, "realseTime");
            return (Criteria) this;
        }

        public Criteria andRealseTimeNotBetween(Date value1, Date value2) {
            addCriterion("realse_time not between", value1, value2, "realseTime");
            return (Criteria) this;
        }

        public Criteria andNewsTypeIsNull() {
            addCriterion("news_type is null");
            return (Criteria) this;
        }

        public Criteria andNewsTypeIsNotNull() {
            addCriterion("news_type is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTypeEqualTo(Integer value) {
            addCriterion("news_type =", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeNotEqualTo(Integer value) {
            addCriterion("news_type <>", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeGreaterThan(Integer value) {
            addCriterion("news_type >", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_type >=", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeLessThan(Integer value) {
            addCriterion("news_type <", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("news_type <=", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeIn(List<Integer> values) {
            addCriterion("news_type in", values, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeNotIn(List<Integer> values) {
            addCriterion("news_type not in", values, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeBetween(Integer value1, Integer value2) {
            addCriterion("news_type between", value1, value2, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("news_type not between", value1, value2, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsContentIsNull() {
            addCriterion("news_content is null");
            return (Criteria) this;
        }

        public Criteria andNewsContentIsNotNull() {
            addCriterion("news_content is not null");
            return (Criteria) this;
        }

        public Criteria andNewsContentEqualTo(String value) {
            addCriterion("news_content =", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentNotEqualTo(String value) {
            addCriterion("news_content <>", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentGreaterThan(String value) {
            addCriterion("news_content >", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentGreaterThanOrEqualTo(String value) {
            addCriterion("news_content >=", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentLessThan(String value) {
            addCriterion("news_content <", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentLessThanOrEqualTo(String value) {
            addCriterion("news_content <=", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentLike(String value) {
            addCriterion("news_content like", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentNotLike(String value) {
            addCriterion("news_content not like", value, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentIn(List<String> values) {
            addCriterion("news_content in", values, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentNotIn(List<String> values) {
            addCriterion("news_content not in", values, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentBetween(String value1, String value2) {
            addCriterion("news_content between", value1, value2, "newsContent");
            return (Criteria) this;
        }

        public Criteria andNewsContentNotBetween(String value1, String value2) {
            addCriterion("news_content not between", value1, value2, "newsContent");
            return (Criteria) this;
        }

        public Criteria andLikesIsNull() {
            addCriterion("likes is null");
            return (Criteria) this;
        }

        public Criteria andLikesIsNotNull() {
            addCriterion("likes is not null");
            return (Criteria) this;
        }

        public Criteria andLikesEqualTo(Integer value) {
            addCriterion("likes =", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotEqualTo(Integer value) {
            addCriterion("likes <>", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesGreaterThan(Integer value) {
            addCriterion("likes >", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesGreaterThanOrEqualTo(Integer value) {
            addCriterion("likes >=", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesLessThan(Integer value) {
            addCriterion("likes <", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesLessThanOrEqualTo(Integer value) {
            addCriterion("likes <=", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesIn(List<Integer> values) {
            addCriterion("likes in", values, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotIn(List<Integer> values) {
            addCriterion("likes not in", values, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesBetween(Integer value1, Integer value2) {
            addCriterion("likes between", value1, value2, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotBetween(Integer value1, Integer value2) {
            addCriterion("likes not between", value1, value2, "likes");
            return (Criteria) this;
        }

        public Criteria andCollectonNumIsNull() {
            addCriterion("collecton_num is null");
            return (Criteria) this;
        }

        public Criteria andCollectonNumIsNotNull() {
            addCriterion("collecton_num is not null");
            return (Criteria) this;
        }

        public Criteria andCollectonNumEqualTo(Integer value) {
            addCriterion("collecton_num =", value, "collectonNum");
            return (Criteria) this;
        }

        public Criteria andCollectonNumNotEqualTo(Integer value) {
            addCriterion("collecton_num <>", value, "collectonNum");
            return (Criteria) this;
        }

        public Criteria andCollectonNumGreaterThan(Integer value) {
            addCriterion("collecton_num >", value, "collectonNum");
            return (Criteria) this;
        }

        public Criteria andCollectonNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("collecton_num >=", value, "collectonNum");
            return (Criteria) this;
        }

        public Criteria andCollectonNumLessThan(Integer value) {
            addCriterion("collecton_num <", value, "collectonNum");
            return (Criteria) this;
        }

        public Criteria andCollectonNumLessThanOrEqualTo(Integer value) {
            addCriterion("collecton_num <=", value, "collectonNum");
            return (Criteria) this;
        }

        public Criteria andCollectonNumIn(List<Integer> values) {
            addCriterion("collecton_num in", values, "collectonNum");
            return (Criteria) this;
        }

        public Criteria andCollectonNumNotIn(List<Integer> values) {
            addCriterion("collecton_num not in", values, "collectonNum");
            return (Criteria) this;
        }

        public Criteria andCollectonNumBetween(Integer value1, Integer value2) {
            addCriterion("collecton_num between", value1, value2, "collectonNum");
            return (Criteria) this;
        }

        public Criteria andCollectonNumNotBetween(Integer value1, Integer value2) {
            addCriterion("collecton_num not between", value1, value2, "collectonNum");
            return (Criteria) this;
        }

        public Criteria andSharingNumIsNull() {
            addCriterion("sharing_num is null");
            return (Criteria) this;
        }

        public Criteria andSharingNumIsNotNull() {
            addCriterion("sharing_num is not null");
            return (Criteria) this;
        }

        public Criteria andSharingNumEqualTo(Integer value) {
            addCriterion("sharing_num =", value, "sharingNum");
            return (Criteria) this;
        }

        public Criteria andSharingNumNotEqualTo(Integer value) {
            addCriterion("sharing_num <>", value, "sharingNum");
            return (Criteria) this;
        }

        public Criteria andSharingNumGreaterThan(Integer value) {
            addCriterion("sharing_num >", value, "sharingNum");
            return (Criteria) this;
        }

        public Criteria andSharingNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sharing_num >=", value, "sharingNum");
            return (Criteria) this;
        }

        public Criteria andSharingNumLessThan(Integer value) {
            addCriterion("sharing_num <", value, "sharingNum");
            return (Criteria) this;
        }

        public Criteria andSharingNumLessThanOrEqualTo(Integer value) {
            addCriterion("sharing_num <=", value, "sharingNum");
            return (Criteria) this;
        }

        public Criteria andSharingNumIn(List<Integer> values) {
            addCriterion("sharing_num in", values, "sharingNum");
            return (Criteria) this;
        }

        public Criteria andSharingNumNotIn(List<Integer> values) {
            addCriterion("sharing_num not in", values, "sharingNum");
            return (Criteria) this;
        }

        public Criteria andSharingNumBetween(Integer value1, Integer value2) {
            addCriterion("sharing_num between", value1, value2, "sharingNum");
            return (Criteria) this;
        }

        public Criteria andSharingNumNotBetween(Integer value1, Integer value2) {
            addCriterion("sharing_num not between", value1, value2, "sharingNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNull() {
            addCriterion("comment_num is null");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNotNull() {
            addCriterion("comment_num is not null");
            return (Criteria) this;
        }

        public Criteria andCommentNumEqualTo(Integer value) {
            addCriterion("comment_num =", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotEqualTo(Integer value) {
            addCriterion("comment_num <>", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThan(Integer value) {
            addCriterion("comment_num >", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_num >=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThan(Integer value) {
            addCriterion("comment_num <", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThanOrEqualTo(Integer value) {
            addCriterion("comment_num <=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumIn(List<Integer> values) {
            addCriterion("comment_num in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotIn(List<Integer> values) {
            addCriterion("comment_num not in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumBetween(Integer value1, Integer value2) {
            addCriterion("comment_num between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_num not between", value1, value2, "commentNum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}