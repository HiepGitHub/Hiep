package com.sss.linkboard.service.network;

import com.android.volley.ParseError;

public class PlainTextParserError extends ParseError{
    private String jsonResponse;

    public PlainTextParserError(Throwable cause, String jsonResponse) {
        super(cause);
        this.jsonResponse = jsonResponse;
    }

    public String getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }
}
