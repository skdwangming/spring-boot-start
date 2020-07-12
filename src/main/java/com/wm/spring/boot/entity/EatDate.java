package com.wm.spring.boot.entity;

import java.util.Date;

public class EatDate {
    private Integer id;

    private Integer rId;

    private Date eatDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Date getEatDate() {
        return eatDate;
    }

    public void setEatDate(Date eatDate) {
        this.eatDate = eatDate;
    }
}