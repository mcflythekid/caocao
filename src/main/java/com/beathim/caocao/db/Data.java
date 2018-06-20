package com.beathim.caocao.db;

import javax.persistence.*;

@Entity
@Table(name = "data")
public class Data {

    private @Id String id;
    private @Column(name = "external_id") String externalId;
    private @Lob String data;
    private Integer status;


    private @Lob String s01;
    private @Lob String s02;
    private @Lob String s03;
    private @Lob String s04;
    private @Lob String s05;
    private @Lob String s06;
    private @Lob String s07;
    private @Lob String s08;
    private @Lob String s09;
    private @Lob String s10;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getS01() {
        return s01;
    }

    public void setS01(String s01) {
        this.s01 = s01;
    }

    public String getS02() {
        return s02;
    }

    public void setS02(String s02) {
        this.s02 = s02;
    }

    public String getS03() {
        return s03;
    }

    public void setS03(String s03) {
        this.s03 = s03;
    }

    public String getS04() {
        return s04;
    }

    public void setS04(String s04) {
        this.s04 = s04;
    }

    public String getS05() {
        return s05;
    }

    public void setS05(String s05) {
        this.s05 = s05;
    }

    public String getS06() {
        return s06;
    }

    public void setS06(String s06) {
        this.s06 = s06;
    }

    public String getS07() {
        return s07;
    }

    public void setS07(String s07) {
        this.s07 = s07;
    }

    public String getS08() {
        return s08;
    }

    public void setS08(String s08) {
        this.s08 = s08;
    }

    public String getS09() {
        return s09;
    }

    public void setS09(String s09) {
        this.s09 = s09;
    }

    public String getS10() {
        return s10;
    }

    public void setS10(String s10) {
        this.s10 = s10;
    }
}
