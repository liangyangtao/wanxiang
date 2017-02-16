package com.unbank.mybatis.entity;

import java.util.ArrayList;
import java.util.List;

public class UserSiteExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public UserSiteExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
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

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andSiteIdIsNull() {
			addCriterion("site_id is null");
			return (Criteria) this;
		}

		public Criteria andSiteIdIsNotNull() {
			addCriterion("site_id is not null");
			return (Criteria) this;
		}

		public Criteria andSiteIdEqualTo(Integer value) {
			addCriterion("site_id =", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdNotEqualTo(Integer value) {
			addCriterion("site_id <>", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdGreaterThan(Integer value) {
			addCriterion("site_id >", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("site_id >=", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdLessThan(Integer value) {
			addCriterion("site_id <", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdLessThanOrEqualTo(Integer value) {
			addCriterion("site_id <=", value, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdIn(List<Integer> values) {
			addCriterion("site_id in", values, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdNotIn(List<Integer> values) {
			addCriterion("site_id not in", values, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdBetween(Integer value1, Integer value2) {
			addCriterion("site_id between", value1, value2, "siteId");
			return (Criteria) this;
		}

		public Criteria andSiteIdNotBetween(Integer value1, Integer value2) {
			addCriterion("site_id not between", value1, value2, "siteId");
			return (Criteria) this;
		}

		public Criteria andDelIsNull() {
			addCriterion("del is null");
			return (Criteria) this;
		}

		public Criteria andDelIsNotNull() {
			addCriterion("del is not null");
			return (Criteria) this;
		}

		public Criteria andDelEqualTo(Integer value) {
			addCriterion("del =", value, "del");
			return (Criteria) this;
		}

		public Criteria andDelNotEqualTo(Integer value) {
			addCriterion("del <>", value, "del");
			return (Criteria) this;
		}

		public Criteria andDelGreaterThan(Integer value) {
			addCriterion("del >", value, "del");
			return (Criteria) this;
		}

		public Criteria andDelGreaterThanOrEqualTo(Integer value) {
			addCriterion("del >=", value, "del");
			return (Criteria) this;
		}

		public Criteria andDelLessThan(Integer value) {
			addCriterion("del <", value, "del");
			return (Criteria) this;
		}

		public Criteria andDelLessThanOrEqualTo(Integer value) {
			addCriterion("del <=", value, "del");
			return (Criteria) this;
		}

		public Criteria andDelIn(List<Integer> values) {
			addCriterion("del in", values, "del");
			return (Criteria) this;
		}

		public Criteria andDelNotIn(List<Integer> values) {
			addCriterion("del not in", values, "del");
			return (Criteria) this;
		}

		public Criteria andDelBetween(Integer value1, Integer value2) {
			addCriterion("del between", value1, value2, "del");
			return (Criteria) this;
		}

		public Criteria andDelNotBetween(Integer value1, Integer value2) {
			addCriterion("del not between", value1, value2, "del");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user_site
	 * @mbggenerated  Thu Feb 16 14:30:04 GMT+08:00 2017
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user_site
     *
     * @mbggenerated do_not_delete_during_merge Thu Feb 09 10:07:50 GMT+08:00 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}