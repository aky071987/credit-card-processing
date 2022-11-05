package com.aky.ccp.validation;

import java.util.Map;

public interface Validator<T> {
    public Map<String, String> validate(T entity);
}
