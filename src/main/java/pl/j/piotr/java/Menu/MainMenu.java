package pl.j.piotr.java.Menu;

import pl.j.piotr.java.Dao.CustomerDao;
import pl.j.piotr.java.Logic.ListToTableModel;
import pl.j.piotr.java.Model.CarStatus;
import pl.j.piotr.java.Model.RentStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

    public MainMenu() {
        initComponents();
    }

    private void initComponents() {

        JButton rent = new JButton();
        JButton carReturn = new JButton();
        JButton searchEdit = new JButton();
        JLabel jLabelTitle = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("Wypożyczalnia samochodów");
        jLabelTitle.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 24)); // NOI18N
        jLabelTitle.setText("Wypożyczalnia samochodów");


        rent.setText("Nowe wypożyczenie");
        rent.addActionListener(this::rentActionPerformed);

        carReturn.setText("Zwrot");
        carReturn.addActionListener(this::carReturnActionPerformed);

        searchEdit.setText("Edycja / Wyszukiwanie");
        searchEdit.addActionListener(this::searchEditActionPerformed);



        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(searchEdit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(carReturn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(rent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addComponent(jLabelTitle)))
                                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabelTitle)
                                .addGap(62, 62, 62)
                                .addComponent(rent)
                                .addGap(49, 49, 49)
                                .addComponent(carReturn)
                                .addGap(59, 59, 59)
                                .addComponent(searchEdit)
                                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }



    private void rentActionPerformed(ActionEvent evt) {
        new RentMenu((new ListToTableModel().allCarTableByStatus(CarStatus.FREE)), (new ListToTableModel().allCustomerTable(new CustomerDao().findAll()))).setVisible(true);
    }

    private void carReturnActionPerformed(ActionEvent evt) {
        new ReturnCarMenu(new ListToTableModel().allRentTableByStatus(RentStatus.ACTIVE)).setVisible(true);
    }

    private void searchEditActionPerformed(ActionEvent evt) {
        new SearchMenu().setVisible(true);
    }


}
