package com.ovo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LikesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LikesExample() {
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

        public Criteria andLikesIdIsNull() {
            addCriterion("likes_ID is null");
            return (Criteria) this;
        }

        public Criteria andLikesIdIsNotNull() {
            addCriterion("likes_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLikesIdEqualTo(String value) {
            addCriterion("likes_ID =", value, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdNotEqualTo(String value) {
            addCriterion("likes_ID <>", value, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdGreaterThan(String value) {
            addCriterion("likes_ID >", value, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdGreaterThanOrEqualTo(String value) {
            addCriterion("likes_ID >=", value, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdLessThan(String value) {
            addCriterion("likes_ID <", value, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdLessThanOrEqualTo(String value) {
            addCriterion("likes_ID <=", value, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdLike(String value) {
            addCriterion("likes_ID like", value, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdNotLike(String value) {
            addCriterion("likes_ID not like", value, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdIn(List<String> values) {
            addCriterion("likes_ID in", values, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdNotIn(List<String> values) {
            addCriterion("likes_ID not in", values, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdBetween(String value1, String value2) {
            addCriterion("likes_ID between", value1, value2, "likesId");
            return (Criteria) this;
        }

        public Criteria andLikesIdNotBetween(String value1, String value2) {
            addCriterion("likes_ID not between", value1, value2, "likesId");
            return (Criteria) this;
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

        public Criteria andUsersIdIsNull() {
            addCriterion("users_ID is null");
            return (Criteria) this;
        }

        public Criteria andUsersIdIsNotNull() {
            addCriterion("users_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUsersIdEqualTo(String value) {
            addCriterion("users_ID =", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdNotEqualTo(String value) {
            addCriterion("users_ID <>", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdGreaterThan(String value) {
            addCriterion("users_ID >", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdGreaterThanOrEqualTo(String value) {
            addCriterion("users_ID >=", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdLessThan(String value) {
            addCriterion("users_ID <", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdLessThanOrEqualTo(String value) {
            addCriterion("users_ID <=", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdLike(String value) {
            addCriterion("users_ID like", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdNotLike(String value) {
            addCriterion("users_ID not like", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdIn(List<String> values) {
            addCriterion("users_ID in", values, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdNotIn(List<String> values) {
            addCriterion("users_ID not in", values, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdBetween(String value1, String value2) {
            addCriterion("users_ID between", value1, value2, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdNotBetween(String value1, String value2) {
            addCriterion("users_ID not between", value1, value2, "usersId");
            return (Criteria) this;
        }

        public Criteria andLikesTimeIsNull() {
            addCriterion("likes_time is null");
            return (Criteria) this;
        }

        public Criteria andLikesTimeIsNotNull() {
            addCriterion("likes_time is not null");
            return (Criteria) this;
        }

        public Criteria andLikesTimeEqualTo(Date value) {
            addCriterion("likes_time =", value, "likesTime");
            return (Criteria) this;
        }

        public Criteria andLikesTimeNotEqualTo(Date value) {
            addCriterion("likes_time <>", value, "likesTime");
            return (Criteria) this;
        }

        public Criteria andLikesTimeGreaterThan(Date value) {
            addCriterion("likes_time >", value, "likesTime");
            return (Criteria) this;
        }

        public Criteria andLikesTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("likes_time >=", value, "likesTime");
            return (Criteria) this;
        }

        public Criteria andLikesTimeLessThan(Date value) {
            addCriterion("likes_time <", value, "likesTime");
            return (Criteria) this;
        }

        public Criteria andLikesTimeLessThanOrEqualTo(Date value) {
            addCriterion("likes_time <=", value, "likesTime");
            return (Criteria) this;
        }

        public Criteria andLikesTimeIn(List<Date> values) {
            addCriterion("likes_time in", values, "likesTime");
            return (Criteria) this;
        }

        public Criteria andLikesTimeNotIn(List<Date> values) {
            addCriterion("likes_time not in", values, "likesTime");
            return (Criteria) this;
        }

        public Criteria andLikesTimeBetween(Date value1, Date value2) {
            addCriterion("likes_time between", value1, value2, "likesTime");
            return (Criteria) this;
        }

        public Criteria andLikesTimeNotBetween(Date value1, Date value2) {
            addCriterion("likes_time not between", value1, value2, "likesTime");
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