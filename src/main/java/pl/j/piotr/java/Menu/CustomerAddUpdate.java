package pl.j.piotr.java.Menu;

import pl.j.piotr.java.Dao.CustomerDao;
import pl.j.piotr.java.Logic.ListToTableModel;
import pl.j.piotr.java.Logic.SearchMenuFunction;
import pl.j.piotr.java.Logic.ToUpdateEdit;
import pl.j.piotr.java.Model.Customer;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CustomerAddUpdateMenu extends JFrame {


    private JTextField jTextFieldStreet;
    private JTextField jTextFieldCity;
    private JTextField jTextFieldFirstName;
    private JTextField jTextFieldHouseNumber;
    private JTextField jTextFieldLastName;
    private JTextField jTextFieldPostalCode;


    public CustomerAddUpdateMenu(SearchMenuFunction searchMenuFunction) {
        initComponents(searchMenuFunction,new Customer());
    }

    public CustomerAddUpdateMenu(SearchMenuFunction searchMenuFunction, Customer customer) {
        initComponents(searchMenuFunction,customer);
    }



    private void initComponents(SearchMenuFunction searchMenuFunction,Customer customer) {


        JLabel jLabel1 = new JLabel();
        JLabel jLabelFirstName = new JLabel();
        JLabel jLabelLastName = new JLabel();
        JLabel jLabelStreet = new JLabel();
        JLabel jLabelHouseNumber = new JLabel();
        JLabel jLabelPostalCode = new JLabel();
        JLabel jLabelCity = new JLabel();
        jTextFieldFirstName = new JTextField();
        jTextFieldLastName = new JTextField();
        jTextFieldStreet = new JTextField();
        jTextFieldHouseNumber = new JTextField();
        jTextFieldPostalCode = new JTextField();
        jTextFieldCity = new JTextField();
        JButton jButtonAction = new JButton();
        JLabel jLabelID = new JLabel();
        JTextField jTextFieldID = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        jLabelFirstName.setText("Imię:");
        jLabelLastName.setText("Nazwisko:");
        jLabelStreet.setText("Ulica:");
        jLabelHouseNumber.setText("Numer domu:");
        jLabelPostalCode.setText("Kod pocztowy:");
        jLabelCity.setText("Miasto:");
        jLabelID.setVisible(false);
        jTextFieldID.setVisible(false);






        jButtonAction.addActionListener(evt ->jButtonActionActionPerformed(searchMenuFunction,customer));




        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonAction)
                                .addGap(90, 90, 90))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(115, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelFirstName)
                                        .addComponent(jLabelLastName)
                                        .addComponent(jLabelStreet)
                                        .addComponent(jLabelHouseNumber)
                                        .addComponent(jLabelPostalCode)
                                        .addComponent(jLabelCity)
                                        .addComponent(jLabelID))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldCity)
                                        .addComponent(jTextFieldLastName)
                                        .addComponent(jTextFieldStreet)
                                        .addComponent(jTextFieldHouseNumber)
                                        .addComponent(jTextFieldPostalCode)
                                        .addComponent(jTextFieldFirstName)
                                        .addComponent(jTextFieldID))
                                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelID)
                                        .addComponent(jTextFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelFirstName)
                                        .addComponent(jTextFieldFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelLastName)
                                        .addComponent(jTextFieldLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelStreet)
                                        .addComponent(jTextFieldStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelHouseNumber)
                                        .addComponent(jTextFieldHouseNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPostalCode)
                                        .addComponent(jTextFieldPostalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCity)
                                        .addComponent(jTextFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addComponent(jButtonAction)
                                .addGap(26, 26, 26))
        );

        pack();

        switch (searchMenuFunction) {
            case ADD:
                jLabel1.setText("Dodaj klienta");
                jButtonAction.setText("Dodaj");
                break;
            case EDIT:
                jLabelID.setVisible(true);
                jLabelID.setText("ID:");
                jTextFieldID.setVisible(true);
                jTextFieldID.setText(String.valueOf(customer.getId()));
                jTextFieldID.setEditable(false);
                jTextFieldFirstName.setText(customer.getFirstName());
                jTextFieldLastName.setText(customer.getLastName());
                jTextFieldStreet.setText(customer.getStreet());
                jTextFieldHouseNumber.setText(customer.getHouseNumber());
                jTextFieldPostalCode.setText(customer.getPostalCode());
                jTextFieldCity.setText(customer.getCity());

                jLabel1.setText("Uaktualnij dane klienta");
                jButtonAction.setText("Uaktualnij");
                break;
            case SEARCH:
                jLabel1.setText("Wyszukaj klienta");
                jButtonAction.setText("Wyszukaj");
                break;
        }



    }

    private void jButtonActionActionPerformed(SearchMenuFunction searchMenuFunction,Customer customer) {
        switch (searchMenuFunction) {
            case ADD:
                if (jTextFieldFirstName.getText().equals("") || jTextFieldLastName.getText().equals("") || jTextFieldStreet.getText().equals("") || jTextFieldCity.getText().equals("") || jTextFieldHouseNumber.getText().equals("") || jTextFieldPostalCode.getText().equals("")) {
                    new ErrorMenu().emptyJTextField();
                } else {
                    new CustomerDao().add(new Customer(jTextFieldFirstName.getText(), jTextFieldLastName.getText(), jTextFieldStreet.getText(),
                            jTextFieldHouseNumber.getText(), jTextFieldCity.getText(), jTextFieldPostalCode.getText()));
                    JOptionPane.showMessageDialog(this, "Dodano :" + jTextFieldFirstName.getText() + " " + jTextFieldLastName.getText());
                    this.dispose();
                    new SearchAll(new ListToTableModel().allCustomerTable(new CustomerDao().findAll()), ToUpdateEdit.CUSTOMER).setVisible(true);
                }
                break;
            case EDIT:
                if (jTextFieldFirstName.getText().equals("") || jTextFieldLastName.getText().equals("") || jTextFieldStreet.getText().equals("") || jTextFieldCity.getText().equals("") || jTextFieldHouseNumber.getText().equals("") || jTextFieldPostalCode.getText().equals("")) {
                    new ErrorMenu().emptyJTextField();
                } else {
                    customer.setFirstName(jTextFieldFirstName.getText());
                    customer.setLastName(jTextFieldLastName.getText());
                    customer.setStreet(jTextFieldStreet.getText());
                    customer.setHouseNumber(jTextFieldHouseNumber.getText());
                    customer.setCity(jTextFieldCity.getText());
                    customer.setPostalCode(jTextFieldPostalCode.getText());
                    new CustomerDao().update(customer);
                    JOptionPane.showMessageDialog(this, "Uaktualniono klienta :\n" + jTextFieldFirstName.getText() + " " + jTextFieldLastName.getText(),"Aktualizacja", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new SearchAll(new ListToTableModel().allCustomerTable(new CustomerDao().findAll()), ToUpdateEdit.CUSTOMER).setVisible(true);
                }


                break;
            case SEARCH:

                List<Customer> customers = new CustomerDao().findCustomerByAll(0,"*","*","*","*","*","*");
                System.out.println(customers);
                new SearchAll(new ListToTableModel().allCustomerTable(customers), ToUpdateEdit.CUSTOMER).setVisible(true);

                break;
        }

    }
}