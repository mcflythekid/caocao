package com.beathim.caocao.dump.token;

import com.beathim.caocao.dump.token.TokenData;

public class TokenResponse {
    private int errorCode;
    private TokenData data;
    private String message;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public TokenData getData() {
        return data;
    }

    public void setData(TokenData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
