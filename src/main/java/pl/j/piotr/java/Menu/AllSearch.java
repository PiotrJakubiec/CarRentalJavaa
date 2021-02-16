package pl.j.piotr.java.Menu;



import pl.j.piotr.java.Dao.CarDao;
import pl.j.piotr.java.Dao.CustomerDao;
import pl.j.piotr.java.Dao.RentDao;
import pl.j.piotr.java.Logic.ListToTableModel;
import pl.j.piotr.java.Logic.SearchMenuFunction;
import pl.j.piotr.java.Logic.ToUpdateEdit;
import pl.j.piotr.java.Model.*;


import javax.persistence.PersistenceException;
import javax.swing.*;
import javax.swing.table.TableModel;


public class SearchAll extends JFrame {

    private JTable jTable1;


    public SearchAll(TableModel tableModel, ToUpdateEdit toUpdateEdit) {
        initComponents(tableModel, toUpdateEdit);
    }


    private void initComponents(TableModel tableModel, ToUpdateEdit toUpdateEdit) {

        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        JButton jButtonEdit = new JButton();
        JButton jButtonDelete = new JButton();
        JButton jButtonAdd = new JButton();

        JButton jButtonSearch = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(tableModel);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Wyszukiwanie / Edycja");





        jTable1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jButtonEdit.setText("Zmień zaznaczony");
        jButtonEdit.addActionListener(evt -> jButtonEditActionPerformed(toUpdateEdit));

        jButtonDelete.setText("Usuń zaznaczony");
        jButtonDelete.addActionListener(evt -> jButtonDeleteActionPerformed(toUpdateEdit));

        jButtonAdd.setText("Dodaj nowy");
        jButtonAdd.addActionListener(evt -> jButtonAddActionPerformed(toUpdateEdit));

        jButtonSearch.setText("Wyszukiwanie");
        jButtonSearch.addActionListener(evt -> jButtonSearchActionPerformed(toUpdateEdit));
        jButtonSearch.setVisible(false);


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButtonEdit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(1126, Short.MAX_VALUE)

                                .addGap(301, 301, 301))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 897, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(174, 174, 174)
                                                .addComponent(jButtonEdit)
                                                .addGap(102, 102, 102)
                                                .addComponent(jButtonDelete)
                                                .addGap(95, 95, 95)
                                                .addComponent(jButtonAdd)
                                                .addGap(75, 75, 75)
                                                .addComponent(jButtonSearch)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)

                                .addGap(30, 30, 30))
        );

        pack();
    }




    private void jButtonDeleteActionPerformed(ToUpdateEdit toUpdateEdit) {
        try {

            if (jTable1.getSelectedRow() < 0) {
                JOptionPane.showMessageDialog(this, "Nic nie wybrano!!", "Uwaga", JOptionPane.WARNING_MESSAGE);
            } else {

                switch (toUpdateEdit) {
                    case CAR:
                        int carOptionsPane = JOptionPane.showConfirmDialog(this, "Czy napewno chcesz usunąć samochód \n o numerze rejestracyjnym :" + jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                        if (carOptionsPane == JOptionPane.YES_OPTION) {
                            new CarDao().deleteCarById((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                            jTable1.setModel(new ListToTableModel().allCarTable(new CarDao().findAll()));
                        }
                        System.out.println(toUpdateEdit);
                        break;

                    case CUSTOMER:
                        int customerOptionsPane = JOptionPane.showConfirmDialog(this, "Czy napewno chcesz usunąć klienta:\n ID :"
                                + jTable1.getValueAt(jTable1.getSelectedRow(), 0) + " "
                                + jTable1.getValueAt(jTable1.getSelectedRow(), 1) + " "
                                + jTable1.getValueAt(jTable1.getSelectedRow(), 2));
                        if (customerOptionsPane == JOptionPane.YES_OPTION) {
                            new CustomerDao().deleteById(Integer.parseInt((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                            jTable1.setModel(new ListToTableModel().allCustomerTable(new CustomerDao().findAll()));
                        }
                        break;

                    case RENT:
                        Rent rent = (Rent) new RentDao().findById(Integer.parseInt((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                        if (rent.getRentStatus() == RentStatus.ACTIVE) {
                            JOptionPane.showMessageDialog(this, "Nie możesz edytować trwającego wypożyczenia", "Uwaga", JOptionPane.WARNING_MESSAGE);
                        } else {


                            int rentOptionsPane = JOptionPane.showConfirmDialog(this, "Czy napewno chcesz usunąć wypożyczenie :\n ID: "
                                    + jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                            if (rentOptionsPane == JOptionPane.YES_OPTION) {
                                new RentDao().deleteById(Integer.parseInt((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                                jTable1.setModel(new ListToTableModel().allRentTable(new RentDao().findAll()));
                            }}
                        break;
                }
            }
        } catch (PersistenceException e) {
            switch (toUpdateEdit) {
                case CAR:
                    JOptionPane.showMessageDialog(this, "Nie można usunąć samochodu który był wypożyczany", "Uwaga", JOptionPane.ERROR_MESSAGE);
                    break;
                case CUSTOMER:
                    JOptionPane.showMessageDialog(this, "Nie można usunąć kilenta który wypożyczł samochody.", "Uwaga", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
        jTable1.repaint();
    }

    private void jButtonEditActionPerformed(ToUpdateEdit toUpdateEdit) {

        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Nic nie wybrano!!", "Uwaga", JOptionPane.WARNING_MESSAGE);
        } else {
            switch (toUpdateEdit) {
                case CAR:

                    Car car = new CarDao().findCarById((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                    this.dispose();
                    new CarAddUpdateMenu(SearchMenuFunction.EDIT, car).setVisible(true);


                    break;

                case CUSTOMER:

                    Customer customer = (Customer) new CustomerDao().findById(Integer.parseInt((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                    this.dispose();
                    new CustomerAddUpdateMenu(SearchMenuFunction.EDIT, customer).setVisible(true);


                    break;

                case RENT:
                    Rent rent = (Rent) new RentDao().findById(Integer.parseInt((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                    if (rent.getRentStatus() == RentStatus.ACTIVE) {
                        JOptionPane.showMessageDialog(this, "Nie możesz edytować trwającego wypożyczenia", "Uwaga", JOptionPane.WARNING_MESSAGE);
                    } else {
                        this.dispose();
                        new RentCarUpdateMenu(rent).setVisible(true);
                    }
                    break;

            }
        }
        jTable1.repaint();
    }

    private void jButtonAddActionPerformed(ToUpdateEdit toUpdateEdit) {

        switch (toUpdateEdit) {
            case CAR:
                this.dispose();
                new CarAddUpdateMenu(SearchMenuFunction.ADD).setVisible(true);
                break;
            case CUSTOMER:
                this.dispose();
                new CustomerAddUpdateMenu(SearchMenuFunction.ADD).setVisible(true);
                break;

            case RENT:
                new RentMenu((new ListToTableModel().allCarTableByStatus(CarStatus.FREE)), (new ListToTableModel().allCustomerTable(new CustomerDao().findAll()))).setVisible(true);
                break;


        }
        jTable1.repaint();
    }

    private void jButtonSearchActionPerformed(ToUpdateEdit toUpdateEdit) {
        switch (toUpdateEdit) {
            case CAR:
                //   new NewCarMenu().setVisible(true);
                jTable1.setModel(new ListToTableModel().allCarTable(new CarDao().findAll()));
                break;
            case CUSTOMER:
                this.dispose();
                new CustomerAddUpdateMenu(SearchMenuFunction.SEARCH).setVisible(true);
                break;

            case RENT:
                //    new RentMenu((new SearchLogic().allCarTableByStatus(CarStatus.FREE)), (new SearchLogic().allCustomerTable())).setVisible(true);
                break;
        }


    }
}