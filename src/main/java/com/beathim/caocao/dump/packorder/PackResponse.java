package com.beathim.caocao.dump.packorder;

public class PackResponse {
    private int errorCode;
    private PackData data;
    private String message;

    public Integer getDeliveryId(){
        if (data != null){
            return data.getId();
        }
        return null;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public PackData getData() {
        return data;
    }

    public void setData(PackData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
