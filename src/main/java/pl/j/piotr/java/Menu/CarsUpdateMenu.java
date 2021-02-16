package pl.j.piotr.java.Menu;

import com.toedter.calendar.JDateChooser;

import com.toedter.calendar.JDateChooser;
import pl.j.piotr.java.Dao.RentDao;
import pl.j.piotr.java.Logic.DateConvert;
import pl.j.piotr.java.Logic.IsNumber;
import pl.j.piotr.java.Logic.ListToTableModel;
import pl.j.piotr.java.Logic.ToUpdateEdit;
import pl.j.piotr.java.Model.CarStatus;
import pl.j.piotr.java.Model.Rent;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class RentCarUpdateMenu extends JFrame {

    private JDateChooser jDateChooserRentDate;
    private JDateChooser jDateChooserReturnDate;
    private JDateChooser jDateChooserRealReturnDate;
    private JTextField jTextFieldAdditionalCost;
    private JTextField jTextFieldTotalPrice;
    private BigDecimal additionalCost;
    private BigDecimal rentPrice;
    private BigDecimal totalPrice;


    public RentCarUpdateMenu(Rent rent) {
        initComponents(rent);
    }


    private void initComponents(Rent rent) {

        ButtonGroup buttonGroupCarStatus = new ButtonGroup();
        JLabel jLabelTitle = new JLabel();
        JLabel jLabelCar = new JLabel();
        JLabel jLabelRegNumber = new JLabel();
        JLabel jLabelMark = new JLabel();
        JLabel jLabelModel = new JLabel();
        JLabel jLabelColor = new JLabel();
        JLabel jLabelPrice = new JLabel();
        JTextField tPrice = new JTextField();
        JTextField tColor = new JTextField();
        JTextField tModel = new JTextField();
        JTextField tMark = new JTextField();
        JTextField tRegNumber = new JTextField();
        JLabel jLabelRentBy = new JLabel();
        JLabel jLabelCustomerID = new JLabel();
        JLabel jLabelFirstName = new JLabel();
        JLabel jLabelLastName = new JLabel();
        JLabel jLabelStreet = new JLabel();
        JLabel jLabelHouseNumber = new JLabel();
        JLabel jLabelPostalCode = new JLabel();
        JLabel jLabelCity = new JLabel();
        JTextField tCity = new JTextField();
        JTextField tPostalCode = new JTextField();
        JTextField tHouseNumber = new JTextField();
        JTextField tStreet = new JTextField();
        JTextField tLastName = new JTextField();
        JTextField tFirstName = new JTextField();
        JTextField jTextFieldID = new JTextField();
        jDateChooserRealReturnDate = new com.toedter.calendar.JDateChooser();
        JLabel jLabelRealDateReturnCar = new JLabel();
        JLabel jLabelCarStatus = new JLabel();
        JLabel jLabelRentPrice = new JLabel();
        JTextField jTextFieldRentPrice = new JTextField();
        JLabel jLabel19 = new JLabel();
        JLabel jLabelRepairFee = new JLabel();
        jTextFieldAdditionalCost = new JTextField();
        JLabel jLabel21 = new JLabel();
        JLabel jLabelTotalPrice = new JLabel();
        jTextFieldTotalPrice = new JTextField();
        JLabel jLabel23 = new JLabel();
        JLabel jLabelDateRentCar = new JLabel();
        JLabel jLabelDateReturnCar = new JLabel();
        JButton jButtonOk = new JButton();
        jDateChooserRentDate = new com.toedter.calendar.JDateChooser();
        jDateChooserReturnDate = new com.toedter.calendar.JDateChooser();
        JRadioButton jRadioButtonCarStatusFree = new JRadioButton();
        JRadioButton jRadioButtonCarStatusDAMAGED = new JRadioButton();


        jRadioButtonCarStatusFree.setText("Sprawny");
        jRadioButtonCarStatusDAMAGED.setText("Uszkodzony");
        buttonGroupCarStatus.add(jRadioButtonCarStatusFree);
        buttonGroupCarStatus.add(jRadioButtonCarStatusDAMAGED);
        CarStatus carStatus = rent.getCar().getCarStatus();
        if (carStatus == CarStatus.FREE) {
            jRadioButtonCarStatusFree.setSelected(true);
            jRadioButtonCarStatusDAMAGED.setEnabled(false);
        } else {
            jRadioButtonCarStatusDAMAGED.setSelected(true);
            jRadioButtonCarStatusFree.setEnabled(false);
        }



        jLabelTitle.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLabelTitle.setText("Aktualizacja wypożyczenia ID:" + rent.getRentId());

        jLabelCar.setText("Samochód");
        jLabelRegNumber.setText("Numer rejestracyjny:");
        jLabelMark.setText("Marka :");
        jLabelModel.setText("Model:");
        jLabelColor.setText("Kolor:");
        jLabelPrice.setText("Cena za dzień: ");
        jLabelRentBy.setText("Wypożyczony przez:");
        jLabelCustomerID.setText("ID :");
        jLabelFirstName.setText("Imię:");
        jLabelLastName.setText("Nazwisko:");
        jLabelStreet.setText("Ulica:");
        jLabelHouseNumber.setText("Numer domu:");
        jLabelPostalCode.setText("Kod pocztowy:");
        jLabelCity.setText("Miasto:");
        jLabelRealDateReturnCar.setText("Realna data zwrotu: ");
        jLabelCarStatus.setText("Stan samochodu :");
        jLabelRentPrice.setText("Koszt wynajmu:");
        rentPrice = rent.getPrice();
        jTextFieldRentPrice.setText(String.valueOf(rent.getPrice()));
        jLabel19.setText("zł");
        jLabelRepairFee.setText("Opłaty dodatkowe:");
        jLabel21.setText("zł");
        jLabelTotalPrice.setText("Całkowity koszt wynajmu:");
        jLabel23.setText("zł");
        jLabelDateRentCar.setText("Data wynajęcia:");
        jLabelDateReturnCar.setText("Przewidywana data zwrotu:");

        jTextFieldAdditionalCost.setText(String.valueOf(rent.getAdditionalCost()));
        additionalCost = rent.getAdditionalCost();
        jTextFieldAdditionalCost.addActionListener(this::jTextFieldAdditionalCostActionPerformed);

        jTextFieldTotalPrice.setText(String.valueOf(rent.getTotalPrice()));
        totalPrice = rent.getTotalPrice();



        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(evt -> jButtonOkActionPerformed(rent));






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
        jTextFieldRentPrice.setEditable(false);
        jTextFieldTotalPrice.setEditable(false);



        tPrice.setText(String.valueOf(rent.getCar().getPrice()));
        tColor.setText(rent.getCar().getColor());
        tModel.setText(rent.getCar().getModel());
        tMark.setText(rent.getCar().getMark());
        tRegNumber.setText(rent.getCar().getRegNumber());
        tCity.setText(rent.getCustomer().getCity());
        tPostalCode.setText(rent.getCustomer().getPostalCode());
        tHouseNumber.setText(rent.getCustomer().getHouseNumber());
        tStreet.setText(rent.getCustomer().getStreet());
        tLastName.setText(rent.getCustomer().getLastName());
        tFirstName.setText(rent.getCustomer().getFirstName());
        jTextFieldID.setText(String.valueOf(rent.getCustomer().getId()));

        jDateChooserRentDate.setDateFormatString("yyyy-MM-dd");
        jDateChooserRealReturnDate.setDateFormatString("yyyy-MM-dd");
        jDateChooserReturnDate.setDateFormatString("yyyy-MM-dd");
        jDateChooserRentDate.setDate(DateConvert.convertToDate(rent.getRentDate()));
        jDateChooserReturnDate.setDate(DateConvert.convertToDate(rent.getReturnDate()));
        jDateChooserRealReturnDate.setDate(DateConvert.convertToDate(rent.getRealReturnDate()));




        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelCar)
                                        .addComponent(jLabelRentBy)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelMark)
                                                        .addComponent(jLabelRegNumber)
                                                        .addComponent(jLabelModel)
                                                        .addComponent(jLabelColor)
                                                        .addComponent(jLabelPrice)
                                                        .addComponent(jLabelCustomerID)
                                                        .addComponent(jLabelFirstName)
                                                        .addComponent(jLabelLastName)
                                                        .addComponent(jLabelStreet)
                                                        .addComponent(jLabelHouseNumber)
                                                        .addComponent(jLabelPostalCode)
                                                        .addComponent(jLabelCity)
                                                        .addComponent(jLabelDateRentCar)
                                                        .addComponent(jLabelDateReturnCar)
                                                        .addComponent(jLabelRealDateReturnCar)
                                                        .addComponent(jLabelRentPrice)
                                                        .addComponent(jLabelCarStatus)
                                                        .addComponent(jLabelRepairFee)
                                                        .addComponent(jLabelTotalPrice))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jTextFieldTotalPrice, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldAdditionalCost, GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 147, Short.MAX_VALUE)
                                                                .addComponent(jButtonOk, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(50, 50, 50))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel21)
                                                                        .addComponent(jLabel23))
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tFirstName)
                                                        .addComponent(tLastName)
                                                        .addComponent(tHouseNumber)
                                                        .addComponent(tPostalCode)
                                                        .addComponent(tCity)
                                                        .addComponent(jTextFieldID, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                                        .addComponent(tRegNumber)
                                                        .addComponent(tMark)
                                                        .addComponent(tModel)
                                                        .addComponent(tColor)
                                                        .addComponent(tPrice, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                                        .addComponent(jDateChooserRealReturnDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(tStreet, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextFieldRentPrice, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel19))
                                                        .addComponent(jDateChooserReturnDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jDateChooserRentDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButtonCarStatusFree)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButtonCarStatusDAMAGED)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabelTitle, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabelTitle)
                                .addGap(51, 51, 51)
                                .addComponent(jLabelCar)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tRegNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelRegNumber))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelMark)
                                        .addComponent(tMark, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelModel)
                                        .addComponent(tModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelColor)
                                        .addComponent(tColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPrice)
                                        .addComponent(tPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelRentBy)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabelCustomerID)
                                                                        .addComponent(jTextFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabelFirstName)
                                                                        .addComponent(tFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabelLastName)
                                                                        .addComponent(tLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabelStreet)
                                                                        .addComponent(tStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(1, 1, 1)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabelHouseNumber)
                                                                        .addComponent(tHouseNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabelPostalCode)
                                                                        .addComponent(tPostalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabelCity)
                                                                        .addComponent(tCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                                                .addComponent(jLabelDateRentCar))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jDateChooserRentDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelDateReturnCar))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jDateChooserReturnDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelRealDateReturnCar, GroupLayout.Alignment.TRAILING)
                                        .addComponent(jDateChooserRealReturnDate, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelRentPrice)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextFieldRentPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel19)))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCarStatus)
                                        .addComponent(jRadioButtonCarStatusFree)
                                        .addComponent(jRadioButtonCarStatusDAMAGED))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelRepairFee)
                                        .addComponent(jTextFieldAdditionalCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTotalPrice)
                                        .addComponent(jTextFieldTotalPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonOk)
                                .addGap(32, 32, 32))
        );

        pack();
    }

    private void jTextFieldAdditionalCostActionPerformed(java.awt.event.ActionEvent evt) {
        if (!IsNumber.isNumeric(jTextFieldAdditionalCost.getText())) {
            JOptionPane.showMessageDialog(this, "Pole Dodatkowy koszt nie jest cyfrą", "Uwaga", JOptionPane.WARNING_MESSAGE);
        } else {
            additionalCost = BigDecimal.valueOf(Double.parseDouble(jTextFieldAdditionalCost.getText()));
            totalPrice = rentPrice.add(additionalCost);
            jTextFieldTotalPrice.setText(String.valueOf(totalPrice));

        }
    }



    private void jButtonOkActionPerformed(Rent rent) {


        if (jDateChooserRentDate.getDate() == null || jDateChooserRealReturnDate.getDate() == null || jDateChooserReturnDate.getDate() == null ||
                DateConvert.convertToLocalDate(jDateChooserRealReturnDate.getDate()).compareTo(DateConvert.convertToLocalDate(jDateChooserRentDate.getDate())) < 0 ||
                DateConvert.convertToLocalDate(jDateChooserReturnDate.getDate()).compareTo(DateConvert.convertToLocalDate(jDateChooserRentDate.getDate())) < 0) {
            JOptionPane.showMessageDialog(this, "Daty są niepoprawne", "Uwaga", JOptionPane.WARNING_MESSAGE);
        } else {

            rent.setTotalPrice(totalPrice);
            rent.setRealReturnDate(DateConvert.convertToLocalDate(jDateChooserRealReturnDate.getDate()));
            rent.setRentDate(DateConvert.convertToLocalDate(jDateChooserRentDate.getDate()));
            rent.setReturnDate(DateConvert.convertToLocalDate(jDateChooserReturnDate.getDate()));
            rent.setAdditionalCost(additionalCost);
            //car.setCarStatus(carStatus);
            JOptionPane.showMessageDialog(this, "Zaktualizowano Wypożyczenie ID:" + rent.getRentId(), "Aktualizacja", JOptionPane.INFORMATION_MESSAGE);
            new RentDao().update(rent);
            this.dispose();
            new SearchAll(new ListToTableModel().allRentTable(new RentDao().findAll()), ToUpdateEdit.RENT).setVisible(true);
        }
    }
}