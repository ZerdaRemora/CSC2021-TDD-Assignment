package com.example.tddCoursework;

import java.util.Date;

public class Appointment
{
    private Date date;
    private String description;

    public Appointment(Date date, String description)
    {
        this.date = date;
        this.description = description;
    }

    public Date getDate()
    {
        return this.date;
    }

    public String getDescription()
    {
        return this.description;
    }
}
