package com.maddtech.packagesorting;

public class PackageDetails {
    // Variable to store data corresponding
    // to firstname keyword in database
    private String name;

    // Variable to store data corresponding
    // to lastname keyword in database
    private String tracking;

    // Variable to store data corresponding
    // to age keyword in database
    private String location;

    // Mandatory empty constructor
    // for use of FirebaseUI
    public PackageDetails() {}

    // Getter and setter method
    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name = name;
    }
    public String gettracking()
    {
        return tracking;
    }
    public void settracking(String tracking)
    {
        this.tracking = tracking;
    }
    public String getlocation()
    {
        return location;
    }
    public void location(String location)
    {
        this.location = location;
    }
}
