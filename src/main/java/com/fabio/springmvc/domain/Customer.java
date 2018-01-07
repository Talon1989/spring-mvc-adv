package com.fabio.springmvc.domain;

import javax.persistence.*;

@Entity
public class Customer extends AbstractDomainClass{

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "addressLine1",
                    column = @Column(name = "billing_address_address_line1")
            ),
            @AttributeOverride(
                    name = "addressLine2",
                    column = @Column(name = "billing_address_address_line2")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "billing_address_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "billing_address_state")
            ),
            @AttributeOverride(
                    name = "zipCode",
                    column = @Column(name = "billing_address_zipcode")
            )
        }
    )
    private Address billingAddress = new Address();
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "addressLine1",
                    column = @Column(name = "shipping_address_address_line1")
            ),
            @AttributeOverride(
                    name = "addressLine2",
                    column = @Column(name = "shipping_address_address_line2")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "shipping_address_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "shipping_address_state")
            ),
            @AttributeOverride(
                    name = "zipCode",
                    column = @Column(name = "shipping_address_zipcode")
            )
        }
    )
    private Address shippingAddress = new Address();
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private User user;

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

    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
