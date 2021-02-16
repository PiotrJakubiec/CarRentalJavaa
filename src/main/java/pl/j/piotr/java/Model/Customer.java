package pl.j.piotr.java.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {


    @Id
    @Column(name="id")
    @GeneratedValue(generator="userSeq")
    @GenericGenerator(name="userSeq",strategy = "increment")
    private int id;


    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(name = "street")
    private String street;

    @Column(name="house_number")
    private String houseNumber;


    @Column(name="city")
    private String city;

    @Column(name="postal_code")
    private String postalCode;




    public Customer() {
    }

    public Customer(String firstName, String lastName, String street, String houseNumber, String city, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}