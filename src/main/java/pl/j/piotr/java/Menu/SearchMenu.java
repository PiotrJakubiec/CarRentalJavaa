package pl.j.piotr.java.Menu;

import pl.j.piotr.java.Dao.CarDao;
import pl.j.piotr.java.Dao.CustomerDao;
import pl.j.piotr.java.Dao.RentDao;
import pl.j.piotr.java.Logic.ListToTableModel;
import pl.j.piotr.java.Logic.ToUpdateEdit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class SearchMenu extends JFrame {

    public SearchMenu() {
        initComponents();
    }



    private void initComponents() {

        JButton car = new JButton();
        JButton customer = new JButton();
        JButton rent = new JButton();
        JLabel jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setTitle("Wyszukiwanie edycja");

        car.setText("Samochody");
        car.addActionListener(this::carActionPerformed);

        customer.setText("Klienci");
        customer.addActionListener(this::customerActionPerformed);

        rent.setText("Wypożyczenia");
        rent.addActionListener(this::rentActionPerformed);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
        jLabel1.setText("Wyszukiwanie /dodawanie nowych / Edycja");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(rent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(customer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(car, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addComponent(jLabel1)))
                                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addGap(62, 62, 62)
                                .addComponent(car)
                                .addGap(49, 49, 49)
                                .addComponent(customer)
                                .addGap(59, 59, 59)
                                .addComponent(rent)
                                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }



    private void carActionPerformed(ActionEvent evt) {
        new SearchAll(new ListToTableModel().allCarTable(new CarDao().findAll()), ToUpdateEdit.CAR).setVisible(true);

    }

    private void customerActionPerformed(ActionEvent evt) {
        new SearchAll(new ListToTableModel().allCustomerTable(new CustomerDao().findAll()), ToUpdateEdit.CUSTOMER).setVisible(true);
    }

    private void rentActionPerformed(ActionEvent evt) {
        new SearchAll(new ListToTableModel().allRentTable(new RentDao().findAll()), ToUpdateEdit.RENT).setVisible(true);
    }



}