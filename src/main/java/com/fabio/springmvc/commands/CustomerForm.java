package com.fabio.springmvc.commands;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class CustomerForm {
    private Integer userId;
    private Integer userVersion;
    private Integer customerId;
    private Integer customerVersion;
    @NotEmpty
    @Size(min = 2, max = 75)
    private String userName;
    @NotEmpty
    private String passwordText;
    @NotEmpty
    private String passwordTextConf;
    private String firstName;
    private String lastName;
    @NotEmpty
    @Email
    private String email;
    private String phoneNumber;
    // added
    private String addressAddressLine1;
    private String addressAddressLine2;
    private String addressCity;
    private String addressState;
    private String addressZipCode;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserVersion() {
        return userVersion;
    }

    public void setUserVersion(Integer userVersion) {
        this.userVersion = userVersion;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerVersion() {
        return customerVersion;
    }

    public void setCustomerVersion(Integer customerVersion) {
        this.customerVersion = customerVersion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordText() {
        return passwordText;
    }

    public void setPasswordText(String passwordText) {
        this.passwordText = passwordText;
    }

    public String getPasswordTextConf() {
        return passwordTextConf;
    }

    public void setPasswordTextConf(String passwordTextConf) {
        this.passwordTextConf = passwordTextConf;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressAddressLine1() {
        return addressAddressLine1;
    }

    public void setAddressAddressLine1(String addressAddressLine1) {
        this.addressAddressLine1 = addressAddressLine1;
    }

    public String getAddressAddressLine2() {
        return addressAddressLine2;
    }

    public void setAddressAddressLine2(String addressAddressLine2) {
        this.addressAddressLine2 = addressAddressLine2;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }
}
