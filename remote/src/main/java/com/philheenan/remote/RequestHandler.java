package com.philheenan.remote;

import com.philheenan.core.model.RemoteRequest;
import com.philheenan.remote.client.RemoteClient;

import retrofit.client.Response;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class RequestHandler {

    private RemoteClient client;

    public RequestHandler(RemoteClient client) {
        this.client = client;
    }

    public Response process(RemoteRequest request) {
        switch (request.type) {
            case GET:
                return client.getUrl(request.authHeader, request.urlPath, request.queryParams);
            case PUT:
                return client.putUrl(request.authHeader, request.urlPath, request.bodyEntity, request.queryParams);
            case PATCH:
                return client.patchUrl(request.authHeader, request.urlPath, request.bodyEntity);
            case POST:
                return client.postUrl(request.authHeader, request.urlPath, request.bodyEntity, request.queryParams);
            case DELETE:
                return client.deleteUrl(request.authHeader, request.urlPath);
            default:
                return null;
        }
    }

}
