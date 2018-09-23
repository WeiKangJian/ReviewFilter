package com.ovo.bean;

import java.util.ArrayList;
import java.util.List;

public class Comments_likeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Comments_likeExample() {
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

        public Criteria andActsIdIsNull() {
            addCriterion("acts_ID is null");
            return (Criteria) this;
        }

        public Criteria andActsIdIsNotNull() {
            addCriterion("acts_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActsIdEqualTo(String value) {
            addCriterion("acts_ID =", value, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdNotEqualTo(String value) {
            addCriterion("acts_ID <>", value, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdGreaterThan(String value) {
            addCriterion("acts_ID >", value, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdGreaterThanOrEqualTo(String value) {
            addCriterion("acts_ID >=", value, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdLessThan(String value) {
            addCriterion("acts_ID <", value, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdLessThanOrEqualTo(String value) {
            addCriterion("acts_ID <=", value, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdLike(String value) {
            addCriterion("acts_ID like", value, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdNotLike(String value) {
            addCriterion("acts_ID not like", value, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdIn(List<String> values) {
            addCriterion("acts_ID in", values, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdNotIn(List<String> values) {
            addCriterion("acts_ID not in", values, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdBetween(String value1, String value2) {
            addCriterion("acts_ID between", value1, value2, "actsId");
            return (Criteria) this;
        }

        public Criteria andActsIdNotBetween(String value1, String value2) {
            addCriterion("acts_ID not between", value1, value2, "actsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdIsNull() {
            addCriterion("comments_ID is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIdIsNotNull() {
            addCriterion("comments_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsIdEqualTo(String value) {
            addCriterion("comments_ID =", value, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdNotEqualTo(String value) {
            addCriterion("comments_ID <>", value, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdGreaterThan(String value) {
            addCriterion("comments_ID >", value, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdGreaterThanOrEqualTo(String value) {
            addCriterion("comments_ID >=", value, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdLessThan(String value) {
            addCriterion("comments_ID <", value, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdLessThanOrEqualTo(String value) {
            addCriterion("comments_ID <=", value, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdLike(String value) {
            addCriterion("comments_ID like", value, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdNotLike(String value) {
            addCriterion("comments_ID not like", value, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdIn(List<String> values) {
            addCriterion("comments_ID in", values, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdNotIn(List<String> values) {
            addCriterion("comments_ID not in", values, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdBetween(String value1, String value2) {
            addCriterion("comments_ID between", value1, value2, "commentsId");
            return (Criteria) this;
        }

        public Criteria andCommentsIdNotBetween(String value1, String value2) {
            addCriterion("comments_ID not between", value1, value2, "commentsId");
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