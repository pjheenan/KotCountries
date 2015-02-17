package com.philheenan.remote.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import retrofit.client.*;
import retrofit.mime.TypedInput;

/**
 * @author zsiegel
 */
public class LocalApiClient implements Client {

    private String scenario = "";

    public LocalApiClient() {
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    @Override
    public Response execute(Request request) throws IOException {

        if (null == scenario || "".equals(scenario)) {

            URL requestedUrl = new URL(request.getUrl());
            String path = requestedUrl.getPath();
            String requestedMethod = request.getMethod().toLowerCase();

            scenario += requestedMethod + path.replace("/", "_") + ".json";
        }

        InputStream inputStream = LocalApiClient.class.getResourceAsStream("/" + this.scenario);

        String mimeType = URLConnection.guessContentTypeFromStream(inputStream);
        if (mimeType == null) {
            mimeType = "application/json";
        }

        TypedInput body = new TypedInputStream(mimeType, inputStream.available(), inputStream);

        return new Response(
                request.getUrl(),
                200,
                "Content from res/raw/" + this.scenario,
                new ArrayList<Header>(),
                body);
    }

    private static class TypedInputStream implements TypedInput {
        private final String mimeType;
        private final long length;
        private final InputStream stream;

        private TypedInputStream(String mimeType, long length, InputStream stream) {
            this.mimeType = mimeType;
            this.length = length;
            this.stream = stream;
        }

        @Override
        public String mimeType() {
            return mimeType;
        }

        @Override
        public long length() {
            return length;
        }

        @Override
        public InputStream in() throws IOException {
            return stream;
        }
    }
}
