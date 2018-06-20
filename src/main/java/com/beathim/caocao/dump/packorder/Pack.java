package com.beathim.caocao.dump.packorder;

import com.beathim.caocao.dump.token.Token;
import com.beathim.caocao.util.TextFileUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class Pack {

    private String getPayload(String orderId) throws IOException {
        String payload = TextFileUtil.readFromClassPath("dump.json");
        payload = payload.replace("[token_flag]", new Token().getValue());
        payload = payload.replace("[origin_flag]", orderId);
        return payload;
    }

    public String getSql(){
        final String format = "update saleorder set deliveryid = '%s' where id = '%s';";
        String sql = String.format(format, deliveryId, orderId);
        if (deliveryId == null){
            sql = "--" + sql;
        }
        return sql;
    }

    private String orderId;
    private Integer deliveryId;

    public Pack(String orderId) throws IOException{
        this.orderId = orderId;
        String response= Jsoup.connect("http://sdk.vedulab.tech/wfs/sdk/outbound/create").timeout(60000).ignoreContentType(true)
                .method(Connection.Method.POST).requestBody(this.getPayload(orderId))
                .header("Content-Type", "application/json")
                .execute()
                .body();
        System.out.println(response);
        PackResponse packResponse = new ObjectMapper().readValue(response, PackResponse.class);
        deliveryId = packResponse.getDeliveryId();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }
}
