package pl.j.piotr.java.Logic;

import pl.j.piotr.java.Dao.CarDao;
import pl.j.piotr.java.Dao.RentDao;
import pl.j.piotr.java.Model.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class ListToTableModel {


    public TableModel allCustomerTable(List<Customer> customers) {

        List<String[]> values = new ArrayList<>();
        for (Customer e : customers) {
            values.add(new String[]{String.valueOf(e.getId()), e.getFirstName(), e.getLastName(), e.getStreet(), e.getHouseNumber(), e.getPostalCode(), e.getCity()});
        }
        String[] column = {"ID", "Imię", "Nazwisko", "Ulica", "Numer domu", "Kod pocztowy", "Miasto"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }




    public TableModel allCarTable(List<Car> cars) {

        List<String[]> values = new ArrayList<>();
        for (Car e : cars) {
            values.add(new String[]{e.getRegNumber(), e.getMark(), e.getModel(), e.getColor(), String.valueOf(e.getPrice()), String.valueOf(e.getCarStatus())});
        }
        String[] column = {"Numer rejestracyjny", "Marka", "Model", "Kolor", "Cena-dzień", "Status"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }




    public TableModel allCarTableByStatus(CarStatus carStatus) {

        List<String[]> values = new ArrayList<>();
        List<Car> cars = new CarDao().findAllCarByStatus(carStatus);
        for (Car e : cars) {
            values.add(new String[]{e.getRegNumber(), e.getMark(), e.getModel(), e.getColor(), String.valueOf(e.getPrice()), String.valueOf(e.getCarStatus())});
        }
        String[] column = {"Numer rejestracyjny", "Marka", "Model", "Kolor", "Cena-dzień", "Status"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }




    public TableModel allRentTableByStatus(RentStatus rentStatus) {

        List<String[]> values = new ArrayList<>();
        List<Rent> rents = new RentDao().findAllRentByStatus(rentStatus);
        for (Rent e : rents) {
            values.add(new String[]{String.valueOf(e.getRentId()), e.getCar().getRegNumber(), e.getCar().getMark(), String.valueOf(e.getCustomer().getId()), e.getCustomer().getFirstName(), e.getCustomer().getLastName(), String.valueOf(e.getRentDate())});
        }
        String[] column = {"ID", "Numer rejestracyjny", "Marka", "ID Klienta", "Imię", "Nazwisko", "Data wypożyczenia"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }





    public TableModel allRentTable(List<Rent> rents) {

        List<String[]> values = new ArrayList<>();
        for (Rent e : rents) {
            values.add(new String[]{String.valueOf(e.getRentId()),
                    e.getCar().getRegNumber(),
                    e.getCar().getMark(),
                    String.valueOf(e.getCustomer().getId()),
                    e.getCustomer().getFirstName(),
                    e.getCustomer().getLastName(),
                    String.valueOf(e.getRentDate()),
                    String.valueOf(e.getReturnDate()),
                    String.valueOf(e.getRealReturnDate()),
                    String.valueOf(e.getPrice()),
                    String.valueOf(e.getAdditionalCost()),
                    String.valueOf(e.getTotalPrice()),
                    String.valueOf(e.getRentStatus())});
        }
        String[] column = {"ID", "Numer rejestracyjny", "Marka", "ID Klienta", "Imię", "Nazwisko", "Data wypożyczenia", "Data zwrotu", "Właściwa data zwrotu", "Cena", "dodatkowe koszty", "cena końcowa", "status"};

        return new DefaultTableModel(values.toArray(new Object[][]{}), column);
    }


}
