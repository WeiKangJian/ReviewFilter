package com.ovo.bean;

import java.util.ArrayList;
import java.util.List;

public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersExample() {
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

        public Criteria andUserIsNull() {
            addCriterion("USER is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("USER is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("USER =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("USER <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("USER >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("USER >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("USER <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("USER <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("USER like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("USER not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("USER in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("USER not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("USER between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("USER not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsIsNull() {
            addCriterion("CURRENT_CONNECTIONS is null");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsIsNotNull() {
            addCriterion("CURRENT_CONNECTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsEqualTo(Long value) {
            addCriterion("CURRENT_CONNECTIONS =", value, "currentConnections");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsNotEqualTo(Long value) {
            addCriterion("CURRENT_CONNECTIONS <>", value, "currentConnections");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsGreaterThan(Long value) {
            addCriterion("CURRENT_CONNECTIONS >", value, "currentConnections");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsGreaterThanOrEqualTo(Long value) {
            addCriterion("CURRENT_CONNECTIONS >=", value, "currentConnections");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsLessThan(Long value) {
            addCriterion("CURRENT_CONNECTIONS <", value, "currentConnections");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsLessThanOrEqualTo(Long value) {
            addCriterion("CURRENT_CONNECTIONS <=", value, "currentConnections");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsIn(List<Long> values) {
            addCriterion("CURRENT_CONNECTIONS in", values, "currentConnections");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsNotIn(List<Long> values) {
            addCriterion("CURRENT_CONNECTIONS not in", values, "currentConnections");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsBetween(Long value1, Long value2) {
            addCriterion("CURRENT_CONNECTIONS between", value1, value2, "currentConnections");
            return (Criteria) this;
        }

        public Criteria andCurrentConnectionsNotBetween(Long value1, Long value2) {
            addCriterion("CURRENT_CONNECTIONS not between", value1, value2, "currentConnections");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsIsNull() {
            addCriterion("TOTAL_CONNECTIONS is null");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsIsNotNull() {
            addCriterion("TOTAL_CONNECTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsEqualTo(Long value) {
            addCriterion("TOTAL_CONNECTIONS =", value, "totalConnections");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsNotEqualTo(Long value) {
            addCriterion("TOTAL_CONNECTIONS <>", value, "totalConnections");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsGreaterThan(Long value) {
            addCriterion("TOTAL_CONNECTIONS >", value, "totalConnections");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_CONNECTIONS >=", value, "totalConnections");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsLessThan(Long value) {
            addCriterion("TOTAL_CONNECTIONS <", value, "totalConnections");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_CONNECTIONS <=", value, "totalConnections");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsIn(List<Long> values) {
            addCriterion("TOTAL_CONNECTIONS in", values, "totalConnections");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsNotIn(List<Long> values) {
            addCriterion("TOTAL_CONNECTIONS not in", values, "totalConnections");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsBetween(Long value1, Long value2) {
            addCriterion("TOTAL_CONNECTIONS between", value1, value2, "totalConnections");
            return (Criteria) this;
        }

        public Criteria andTotalConnectionsNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_CONNECTIONS not between", value1, value2, "totalConnections");
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