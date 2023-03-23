package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "holidays")
public class Holiday {
    @Id
    @Column(name="holiday_date")
    private Date holiday_date;

    @Column(name="holiday_day")
    private String holiday_day;

    @Column(name="holiday")
    private String holiday;

    public Date getHoliday_date() {
        return holiday_date;
    }

    public void setHoliday_date(Date holiday_date) {
        this.holiday_date = holiday_date;
    }

    public String getHoliday_day() {
        return holiday_day;
    }

    public void setHoliday_day(String holiday_day) {
        this.holiday_day = holiday_day;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }






}
