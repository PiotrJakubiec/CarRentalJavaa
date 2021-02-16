package pl.j.piotr.java.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "rent")
public class Rent {


    @Id
    @Column(name = "rent_id")
    @GeneratedValue(generator = "donationSeq")
    @GenericGenerator(name = "donationSeq", strategy = "increment")
    private int rentId;

    @Column(name = "rent_date")
    private LocalDate rentDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "real_return_date")
    private LocalDate realReturnDate;

    @Column(name = "prise")
    private BigDecimal price;

    @Column(name = "additional_cost")
    private BigDecimal additionalCost;

    @Column(name = "total_prise")
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "rent_status")
    private RentStatus rentStatus;



    @ManyToOne(targetEntity = Car.class)
    private Car car;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    public Rent() {
    }

    public Rent(LocalDate rent_date, LocalDate return_date, LocalDate realReturnDate, BigDecimal price, BigDecimal additionalCost, BigDecimal totalPrice, RentStatus rentStatus, Car car, Customer customer) {
        this.rentDate = rent_date;
        this.returnDate = return_date;
        this.realReturnDate = realReturnDate;
        this.price = price;
        this.additionalCost = additionalCost;
        this.totalPrice = totalPrice;
        this.rentStatus = rentStatus;
        this.car = car;
        this.customer = customer;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getRealReturnDate() {
        return realReturnDate;
    }

    public void setRealReturnDate(LocalDate realReturnDate) {
        this.realReturnDate = realReturnDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(BigDecimal additionalCost) {
        this.additionalCost = additionalCost;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public RentStatus getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(RentStatus rentStatus) {
        this.rentStatus = rentStatus;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return rentId == rent.rentId &&
                Objects.equals(rentDate, rent.rentDate) &&
                Objects.equals(returnDate, rent.returnDate) &&
                Objects.equals(realReturnDate, rent.realReturnDate) &&
                Objects.equals(price, rent.price) &&
                Objects.equals(additionalCost, rent.additionalCost) &&
                Objects.equals(totalPrice, rent.totalPrice) &&
                rentStatus == rent.rentStatus &&
                Objects.equals(car, rent.car) &&
                Objects.equals(customer, rent.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentId, rentDate, returnDate, realReturnDate, price, additionalCost, totalPrice, rentStatus, car, customer);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentId=" + rentId +
                ", rent_date=" + rentDate +
                ", return_date=" + returnDate +
                ", realReturnDate=" + realReturnDate +
                ", price=" + price +
                ", additionalCost=" + additionalCost +
                ", totalPrice=" + totalPrice +
                ", rentStatus=" + rentStatus +
                ", car=" + car +
                ", customer=" + customer +
                '}';
    }
}