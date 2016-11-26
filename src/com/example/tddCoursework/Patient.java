package com.example.tddCoursework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient
{
    private final int ID;
    private static int nextId = 0;
    private String name;
    private String address;
    private Date dateOfBirth;
    private List<Appointment> appointments;

    public Patient(String name, String addr, Date dob)
    {
        // Uses a static int to ensure a unique ID.
        this.ID = nextId;
        nextId++;

        this.name = name;
        this.address = addr;
        this.dateOfBirth = dob;

        appointments = new ArrayList<Appointment>();
    }

    public int getId()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Date getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public void addAppointment(Date date, String desc)
    {
        Appointment a = new Appointment(date, desc);
        appointments.add(a);
    }

    public List<Appointment> getAppointments()
    {
        return this.appointments;
    }
}
