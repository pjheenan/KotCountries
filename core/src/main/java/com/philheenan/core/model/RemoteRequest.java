package com.philheenan.core.model;

import java.util.Map;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class RemoteRequest<T> {

    public HttpType type;
    public String urlPath;
    public String authHeader;
    public T bodyEntity;
    public Map<String, String> queryParams;

}
