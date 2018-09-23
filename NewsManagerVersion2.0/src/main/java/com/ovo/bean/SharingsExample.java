package com.ovo.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SharingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SharingsExample() {
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

        public Criteria andSharingsIdIsNull() {
            addCriterion("sharings_ID is null");
            return (Criteria) this;
        }

        public Criteria andSharingsIdIsNotNull() {
            addCriterion("sharings_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSharingsIdEqualTo(String value) {
            addCriterion("sharings_ID =", value, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdNotEqualTo(String value) {
            addCriterion("sharings_ID <>", value, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdGreaterThan(String value) {
            addCriterion("sharings_ID >", value, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdGreaterThanOrEqualTo(String value) {
            addCriterion("sharings_ID >=", value, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdLessThan(String value) {
            addCriterion("sharings_ID <", value, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdLessThanOrEqualTo(String value) {
            addCriterion("sharings_ID <=", value, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdLike(String value) {
            addCriterion("sharings_ID like", value, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdNotLike(String value) {
            addCriterion("sharings_ID not like", value, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdIn(List<String> values) {
            addCriterion("sharings_ID in", values, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdNotIn(List<String> values) {
            addCriterion("sharings_ID not in", values, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdBetween(String value1, String value2) {
            addCriterion("sharings_ID between", value1, value2, "sharingsId");
            return (Criteria) this;
        }

        public Criteria andSharingsIdNotBetween(String value1, String value2) {
            addCriterion("sharings_ID not between", value1, value2, "sharingsId");
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

        public Criteria andSharingsTimeIsNull() {
            addCriterion("sharings_time is null");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeIsNotNull() {
            addCriterion("sharings_time is not null");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeEqualTo(Date value) {
            addCriterion("sharings_time =", value, "sharingsTime");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeNotEqualTo(Date value) {
            addCriterion("sharings_time <>", value, "sharingsTime");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeGreaterThan(Date value) {
            addCriterion("sharings_time >", value, "sharingsTime");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sharings_time >=", value, "sharingsTime");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeLessThan(Date value) {
            addCriterion("sharings_time <", value, "sharingsTime");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeLessThanOrEqualTo(Date value) {
            addCriterion("sharings_time <=", value, "sharingsTime");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeIn(List<Date> values) {
            addCriterion("sharings_time in", values, "sharingsTime");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeNotIn(List<Date> values) {
            addCriterion("sharings_time not in", values, "sharingsTime");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeBetween(Date value1, Date value2) {
            addCriterion("sharings_time between", value1, value2, "sharingsTime");
            return (Criteria) this;
        }

        public Criteria andSharingsTimeNotBetween(Date value1, Date value2) {
            addCriterion("sharings_time not between", value1, value2, "sharingsTime");
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