package com.sss.linkboard.service.client.tweet;

import java.io.Serializable;

/**
 * Created by trongnhan on 3/17/15.
 */
public class TweetMetaData implements Serializable{

    private String result_type;
    private String iso_language_code;

    public void setResult_type(String result_type) {
        this.result_type = result_type;
    }

    public void setIso_language_code(String iso_language_code) {
        this.iso_language_code = iso_language_code;
    }

    public String getResult_type() {
        return result_type;
    }

    public String getIso_language_code() {
        return iso_language_code;
    }
}
