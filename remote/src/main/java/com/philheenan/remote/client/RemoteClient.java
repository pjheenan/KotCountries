package com.philheenan.remote.client;

import java.util.Map;

import retrofit.client.Response;
import retrofit.http.*;

/**
 * @author phillip.heenan (phillip.heenan@viagogo.com)
 */
public interface RemoteClient {

    static final String BASE_URL_ID = "/{baseUrl}";
    static final String BASE_URL = "baseUrl";

    String AUTH_HEADER = "Authorization";

    @GET(BASE_URL_ID)
    Response getUrl(
            @Header(AUTH_HEADER) String header,
            @Path(value = BASE_URL, encode = false) String baseUrl,
            @QueryMap Map<String, String> params);

    @PATCH(BASE_URL_ID)
    Response patchUrl(
            @Header(AUTH_HEADER) String header,
            @Path(value = BASE_URL, encode = false) String baseUrl,
            @Body Object body);

    @POST(BASE_URL_ID)
    Response postUrl(
            @Header(AUTH_HEADER) String header,
            @Path(value = BASE_URL, encode = false) String baseUrl,
            @Body Object body,
            @QueryMap Map<String, String> params);

    @PUT(BASE_URL_ID)
    Response putUrl(
            @Header(AUTH_HEADER) String header,
            @Path(value = BASE_URL, encode = false) String baseUrl,
            @Body Object body,
            @QueryMap Map<String, String> params);

    @DELETE(BASE_URL_ID)
    Response deleteUrl(
            @Header(AUTH_HEADER) String header,
            @Path(value = BASE_URL, encode = false) String baseUrl);
}
