
package com.example.serviciosweb.model;

public class Usuario {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String country;
    private String city;
    private String address;
    private double annualIncome;
    private int creditScore;
    private boolean hasUnpaidDebt;
    private double unpaidDebtAmount;
    private String status;

    public Usuario(int id, String firstName, String lastName,
                   String email, String phone, String dateOfBirth,
                   String country, String city, String address,
                   double annualIncome, int creditScore,
                   boolean hasUnpaidDebt, double unpaidDebtAmount,
                   String status) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.city = city;
        this.address = address;
        this.annualIncome = annualIncome;
        this.creditScore = creditScore;
        this.hasUnpaidDebt = hasUnpaidDebt;
        this.unpaidDebtAmount = unpaidDebtAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public boolean isHasUnpaidDebt() {
        return hasUnpaidDebt;
    }

    public double getUnpaidDebtAmount() {
        return unpaidDebtAmount;
    }

    public String getStatus() {
        return status;
    }
}
