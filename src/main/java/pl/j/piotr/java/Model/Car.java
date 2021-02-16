package pl.j.piotr.java.Model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "car")
public class Car {


    @Id
    @Column (name = "reg_number")
    private String regNumber;

    @Column (name = "mark")
    private String mark;

    @Column (name = "model")
    private String model;

    @Column (name = "color")
    private String color;

    @Column (name = "price")
    private BigDecimal price;

    @Column (name = "car_status")
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;


    public Car() {
    }

    public Car(String regNumber, String mark, String model, String color, BigDecimal price, CarStatus carStatus) {
        this.regNumber = regNumber;
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.price = price;
        this.carStatus = carStatus;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(regNumber, car.regNumber) &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color) &&
                Objects.equals(price, car.price) &&
                carStatus == car.carStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, mark, model, color, price, carStatus);
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", carStatus=" + carStatus +
                '}';
    }
}