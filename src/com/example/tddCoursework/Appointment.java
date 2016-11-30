package com.example.tddCoursework;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a patient's appointment at a doctor's surgery.
 *
 * The only difference between this class and the design specified in Task 1 is the addition of
 * a 'toString' method for neatly displaying the details of an Appointment.
 */
public class Appointment
{
    private Date date;
    private String description;

    /**
     * Create an Appointment with the specified parameters.
     * @param date The date of the appointment
     * @param description Any notes about the appointment.
     */
    public Appointment(Date date, String description)
    {
        if (date == null)
            throw new IllegalArgumentException("Appointment date must not be null.");
        if (description == null) // Allowing empty strings here as some appointments may not require notes.
            throw new IllegalArgumentException("Appointment notes must not be null.");
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

    @Override
    public String toString()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("Appointment Date: %s - Note: %s\n", dateFormat.format(date), description);
    }
}
