package pl.j.piotr.java.Menu;

import pl.j.piotr.java.Dao.CarDao;
import pl.j.piotr.java.Dao.CustomerDao;
import pl.j.piotr.java.Dao.RentDao;
import pl.j.piotr.java.Logic.DateConvert;
import pl.j.piotr.java.Model.*;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class RentMenu extends JFrame {


    private com.toedter.calendar.JDateChooser jDateRentCar;
    private com.toedter.calendar.JDateChooser jDateReturnCar;
    private JTable carTable;
    private JTable customerTabale;
    private JTextField tPrice;
    private JTextField tCity;
    private JTextField tColor;
    private JTextField tFirstName;
    private JTextField tHouseNumber;
    private JTextField tLastName;
    private JTextField tMark;
    private JTextField tModel;
    private JTextField tPostalCode;
    private JTextField tRegNumber;
    private JTextField tStreet;
    private JTextField jTextFieldID;


    public RentMenu(TableModel carTableModel, TableModel customerTableModel) {
        initComponents(carTableModel, customerTableModel);
    }


    private void initComponents(TableModel carTableModel, TableModel customerTableModel) {

        JScrollPane carScrollPane = new JScrollPane();
        carTable = new JTable();
        JScrollPane customerScrollPane2 = new JScrollPane();
        customerTabale = new JTable();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        tRegNumber = new JTextField();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();
        JLabel jLabel9 = new JLabel();
        JLabel jLabel10 = new JLabel();
        JLabel jLabel11 = new JLabel();
        JLabel jLabel12 = new JLabel();
        JLabel jLabel13 = new JLabel();
        JLabel jLabel14 = new JLabel();
        JLabel jLabel15 = new JLabel();
        JLabel jLabel16 = new JLabel();
        JLabel jLabel17 = new JLabel();
        JLabel jLabel18 = new JLabel();

        JButton jButtonOk = new JButton();
        JLabel jLabelCustomerID = new JLabel();
        jTextFieldID = new JTextField();
        tMark = new JTextField();
        tModel = new JTextField();
        tColor = new JTextField();
        tPrice = new JTextField();
        tFirstName = new JTextField();
        tLastName = new JTextField();
        tStreet = new JTextField();
        tHouseNumber = new JTextField();
        tPostalCode = new JTextField();
        tCity = new JTextField();
        //JButton jButton2 = new JButton();
        jDateRentCar = new com.toedter.calendar.JDateChooser();
        jDateReturnCar = new com.toedter.calendar.JDateChooser();


        jTextFieldID.setEditable(false);
        tFirstName.setEditable(false);
        tLastName.setEditable(false);
        tStreet.setEditable(false);
        tHouseNumber.setEditable(false);
        tPostalCode.setEditable(false);
        tCity.setEditable(false);

        tRegNumber.setEditable(false);
        tMark.setEditable(false);
        tModel.setEditable(false);
        tColor.setEditable(false);
        tPrice.setEditable(false);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nowe wypożyczenie");


        carTable.setModel(carTableModel);
        carScrollPane.setViewportView(carTable);
        ListSelectionModel selectCar = carTable.getSelectionModel();
        selectCar.addListSelectionListener(evt -> carTableSelectedActionPerformed(carTableModel));


        customerTabale.setModel(customerTableModel);
        customerScrollPane2.setViewportView(customerTabale);
        customerTabale.getSelectionModel().addListSelectionListener(evt -> customerTableSelectedActionPerformed(customerTableModel));

        jLabel1.setText("Wybierz samochód");
        jLabel2.setText("Wybierz klienta");
        jLabel3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jLabel3.setText("Nowe wypożyczenie");
        jLabel4.setText("Samochód");
        jLabel5.setText("Numer rejestracyjny:");
        jLabel6.setText("Marka :");
        jLabel7.setText("Model:");
        jLabel8.setText("Kolor:");
        jLabel9.setText("Cena za dzień: ");
        jLabel10.setText("Wypożyczony przez:");
        jLabel11.setText("Imię:");
        jLabel12.setText("Nazwisko:");
        jLabel13.setText("Ulica:");
        jLabel14.setText("Numer domu:");
        jLabel15.setText("Kod pocztowy:");
        jLabel16.setText("Miasto:");
        jLabel17.setText("Data wypożyczenia:");
        jLabel18.setText("Data zwrotu:");
        jLabelCustomerID.setText("ID :");

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(this::jButtonOKActionPerformed);


        jDateRentCar.setDateFormatString("yyyy-MM-dd");
        jDateReturnCar.setDateFormatString("yyy-MM-dd");


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel4)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel17)
                                                                                        .addComponent(jLabel18))
                                                                                .addGap(32, 32, 32)
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jDateRentCar, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                                                                        .addComponent(jDateReturnCar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(31, 31, 31)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel10)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel11)
                                                                                        .addComponent(jLabel14)
                                                                                        .addComponent(jLabel15)
                                                                                        .addComponent(jLabel16)
                                                                                        .addComponent(jLabel12)
                                                                                        .addComponent(jLabel13)
                                                                                        .addComponent(jLabelCustomerID))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(tFirstName)
                                                                                        .addComponent(tLastName)
                                                                                        .addComponent(tStreet)
                                                                                        .addComponent(tHouseNumber)
                                                                                        .addComponent(tPostalCode, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                                                                        .addComponent(tCity)
                                                                                        .addComponent(jTextFieldID)))))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel9))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(tRegNumber, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                                                        .addComponent(tMark)
                                                                        .addComponent(tModel)
                                                                        .addComponent(tColor)
                                                                        .addComponent(tPrice))))
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(carScrollPane, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(customerScrollPane2)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(419, 419, 419)
                                                .addComponent(jLabel1)
                                                .addGap(347, 347, 347)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(321, 321, 321)
                                .addComponent(jButtonOk, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 564, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel4)
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tRegNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(tMark, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(tModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(tColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(tPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(carScrollPane, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelCustomerID)
                                                        .addComponent(jTextFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(tFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(6, 6, 6)
                                                                .addComponent(tLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel11)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel12)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(tStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel13, GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(tHouseNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel14, GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel15)
                                                        .addComponent(tPostalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel16)
                                                        .addComponent(tCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(123, 123, 123)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jDateReturnCar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel17, GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jDateRentCar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel18))))
                                        .addComponent(customerScrollPane2, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(jButtonOk)
                                .addGap(19, 19, 19))
        );


        pack();
    }

    private void customerTableSelectedActionPerformed(TableModel customerTableModel) {
        jTextFieldID.setText((String) customerTableModel.getValueAt(customerTabale.getSelectedRow(), 0));
        tFirstName.setText((String) customerTableModel.getValueAt(customerTabale.getSelectedRow(), 1));
        tLastName.setText((String) customerTableModel.getValueAt(customerTabale.getSelectedRow(), 2));
        tStreet.setText((String) customerTableModel.getValueAt(customerTabale.getSelectedRow(), 3));
        tHouseNumber.setText((String) customerTableModel.getValueAt(customerTabale.getSelectedRow(), 4));
        tPostalCode.setText((String) customerTableModel.getValueAt(customerTabale.getSelectedRow(), 5));
        tCity.setText((String) customerTableModel.getValueAt(customerTabale.getSelectedRow(), 6));
    }

    private void carTableSelectedActionPerformed(TableModel carTableModel) {
        tRegNumber.setText((String) carTableModel.getValueAt(carTable.getSelectedRow(), 0));
        tMark.setText((String) carTableModel.getValueAt(carTable.getSelectedRow(), 1));
        tModel.setText((String) carTableModel.getValueAt(carTable.getSelectedRow(), 2));
        tColor.setText((String) carTableModel.getValueAt(carTable.getSelectedRow(), 3));
        tPrice.setText((String) carTableModel.getValueAt(carTable.getSelectedRow(), 4));
    }

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {

        if (carTable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Musisz wybrać Samochód", "Uwaga", JOptionPane.WARNING_MESSAGE);
        } else if (customerTabale.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Musisz wybrać klienta", "Uwaga", JOptionPane.WARNING_MESSAGE);
        } else if (jDateRentCar.getDate() == null ||
                jDateReturnCar.getDate() == null
                || DateConvert.convertToLocalDate(jDateReturnCar.getDate()).compareTo(DateConvert.convertToLocalDate(jDateRentCar.getDate())) <= 0) {
            JOptionPane.showMessageDialog(this, "Daty są niepoprawne", "Uwaga", JOptionPane.WARNING_MESSAGE);
        } else {

            LocalDate rentCarDate = DateConvert.convertToLocalDate(jDateRentCar.getDate());
            LocalDate returnCarDate = DateConvert.convertToLocalDate(jDateReturnCar.getDate());
            Period period = Period.between(rentCarDate, returnCarDate);
            BigDecimal totalPrice = BigDecimal.valueOf(Double.parseDouble(tPrice.getText())).multiply(new BigDecimal(period.getDays()));
            StringBuilder message = new StringBuilder()
                    .append("Dodano wypożyczenie:\n Samochód:   ")
                    .append(tRegNumber.getText())
                    .append(" ")
                    .append(tModel.getText())
                    .append("\n Klient:   ")
                    .append(tFirstName.getText())
                    .append(" ")
                    .append(tLastName.getText())
                    .append("\n Okres:   ")
                    .append(period.getDays())
                    .append(" dni x ")
                    .append(tPrice.getText())
                    .append(" zł")
                    .append("\n------------------------------------")
                    .append("\n cena za wynajem:    ")
                    .append(totalPrice)
                    .append("zł");
            JOptionPane.showMessageDialog(this, message);
            Car car = new CarDao().findCarById(tRegNumber.getText());
            Customer customer = (Customer) new CustomerDao().findById(Integer.parseInt(jTextFieldID.getText()));
            car.setCarStatus(CarStatus.RENTED);
            new RentDao().add(new Rent(rentCarDate,
                    returnCarDate,
                    null,
                    totalPrice,
                    null,
                    totalPrice,
                    RentStatus.ACTIVE,
                    car,
                    customer));
            new CarDao().update(car);
            this.dispose();


        }
    }


}