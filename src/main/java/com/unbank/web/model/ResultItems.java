package com.unbank.web.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultItems {

	private Map<String, Object> fields = new LinkedHashMap<String, Object>();

	public <T> T getField(String key) {
		Object o = fields.get(key);
		if (o == null) {
			return null;
		}
		return (T) fields.get(key);
	}

	public Map<String, Object> getAll() {
		return fields;
	}

	public <T> ResultItems putFields(String key, T value) {
		fields.put(key, value);
		return this;
	}
}
