package com.beathim.caocao.dump.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class Token {

    private static final String payload =
            "{\n" +
                    "\t\"username\": \"juno\",\n" +
                    "\t\"password\": \"1\",\n" +
                    "\t\"app_code\": \"a7454b46-3332-11e8-b467-0ed5f89f718b\"\n" +
                    "}";

    private String value;

    public Token() throws IOException {
        String response = Jsoup.connect("http://sdk.vedulab.tech/wfs/sdk/account/login").timeout(60000).ignoreContentType(true)
                .method(Connection.Method.POST).requestBody(payload)
                .header("Content-Type", "application/json")
                .execute()
                .body();

        TokenResponse tokenResponse = new ObjectMapper().readValue(response, TokenResponse.class);

        value = tokenResponse.getData().getToken();
    }

    public static void main(String[] args) throws IOException {
        Token t = new Token();
        System.out.println(t.getValue());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
