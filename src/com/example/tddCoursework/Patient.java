package com.example.tddCoursework;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Represents a Patient at a doctor's surgery.
 */
public class Patient
{
    private final int ID;
    private static int nextId = 0;
    private String name;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private List<Appointment> appointments;

    /**
     * Creates a Patient with the specified parameters.
     * @param name Full name of the patient
     * @param phoneNumber Phone Number of the Patient
     * @param addr Address of the patient
     * @param dob Date of Birth of the patient
     */
    public Patient(String name, String addr, String phoneNumber, Date dob)
    {
        Pattern phoneNoPattern = Pattern.compile("(\\+[0-9]{1,3})?[0-9]*");
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name must not be null or empty.");
        if (addr == null || addr.isEmpty())
            throw new IllegalArgumentException("Address must not be null or empty.");
        if (phoneNumber == null || phoneNumber.isEmpty())
            throw new IllegalArgumentException("Phone Number must not be null or empty.");
        if (!phoneNoPattern.matcher(phoneNumber).matches())
            throw new IllegalArgumentException("Phone Number is malformed.");
        if (dob == null)
            throw new IllegalArgumentException("Date of birth must not be null.");
        if (dob.after(Calendar.getInstance().getTime()))
            throw new IllegalArgumentException("Date of birth must be in the past.");

        // Uses a static int to ensure a unique ID.
        this.ID = nextId;
        nextId++;

        this.name = name;
        this.address = addr;
        this.phoneNumber = phoneNumber;
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
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name must not be null or empty.");
        this.name = name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        if (address == null || address.isEmpty())
            throw new IllegalArgumentException("Address must not be null or empty.");
        this.address = address;
    }

    public Date getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public void addAppointment(Appointment appointment)
    {
        if (appointment == null)
            throw new IllegalArgumentException("Appointment must not be null.");
        appointments.add(appointment);
    }

    public void addAppointment(Date date, String desc)
    {
        Appointment a = new Appointment(date, desc);    // Error checking is in Appointment constructor.
        appointments.add(a);
    }

    public List<Appointment> getAppointments()
    {
        return this.appointments;
    }
}
