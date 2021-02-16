package pl.j.piotr.java.Menu;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooser;
import pl.j.piotr.java.Dao.CarDao;
import pl.j.piotr.java.Dao.RentDao;
import pl.j.piotr.java.Logic.DateConvert;
import pl.j.piotr.java.Model.Car;
import pl.j.piotr.java.Model.CarStatus;
import pl.j.piotr.java.Model.Rent;
import pl.j.piotr.java.Model.RentStatus;


import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class ReturnCarMenu extends JFrame {


    private JDateChooser jDateChooserRealReturnDate;
    private JLabel jLabelCarID;
    private JTable jTableRentedCar;
    private JTextField jTextFieldDateRentCar;
    private JTextField jTextFieldDateReturnCar;
    private JTextField jTextFieldDelayFee;
    private JTextField jTextFieldID;
    private JTextField jTextFieldRepairFee;
    private JTextField jTextFieldTotalPrice;
    private JTextField tCity;
    private JTextField tColor;
    private JTextField tFirstName;
    private JTextField tHouseNumber;
    private JTextField tLastName;
    private JTextField tMark;
    private JTextField tModel;
    private JTextField tPostalCode;
    private JTextField tPrice;
    private JTextField tRegNumber;
    private JTextField tStreet;
    private BigDecimal delayFee = BigDecimal.valueOf(0);
    private BigDecimal repairFee = BigDecimal.valueOf(0);
    private BigDecimal totalPrice = BigDecimal.valueOf(0);
    private BigDecimal rentPrice = BigDecimal.valueOf(0);
    private CarStatus carStatus = CarStatus.FREE;
    private Rent rent;


    public ReturnCarMenu(TableModel rentTableModel) {
        initComponents(rentTableModel);
    }


    private void initComponents(TableModel rentTableModel) {


        ButtonGroup buttonGroupCarStatus = new ButtonGroup();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTableRentedCar = new JTable();
        jLabelCarID = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabelRegNumber = new JLabel();
        JLabel jLabelMark = new JLabel();
        JLabel jLabelModel = new JLabel();
        JLabel jLabelColor = new JLabel();
        JLabel jLabelPrice = new JLabel();
        tPrice = new JTextField();
        tColor = new JTextField();
        tModel = new JTextField();
        tMark = new JTextField();
        tRegNumber = new JTextField();
        JLabel jLabel10 = new JLabel();
        JLabel jLabelCustomerID = new JLabel();
        JLabel jLabelFirstName = new JLabel();
        JLabel jLabelLastName = new JLabel();
        JLabel jLabelStreet = new JLabel();
        JLabel jLabelHouseNumber = new JLabel();
        JLabel jLabelPostalCode = new JLabel();
        JLabel jLabelCity = new JLabel();
        tCity = new JTextField();
        tPostalCode = new JTextField();
        tHouseNumber = new JTextField();
        tStreet = new JTextField();
        tLastName = new JTextField();
        tFirstName = new JTextField();
        jTextFieldID = new JTextField();
        JLabel jLabel1 = new JLabel();
        jDateChooserRealReturnDate = new com.toedter.calendar.JDateChooser();
        JLabel jLabel2 = new JLabel();
        JLabel jLabelCarStatus = new JLabel();
        JLabel jLabelDelayFee = new JLabel();
        jTextFieldDelayFee = new JTextField();
        JLabel jLabel19 = new JLabel();
        JLabel jLabel20 = new JLabel();
        jTextFieldRepairFee = new JTextField();
        JLabel jLabel21 = new JLabel();
        JLabel jLabelTotalPrice = new JLabel();
        jTextFieldTotalPrice = new JTextField();
        JLabel jLabel23 = new JLabel();
        JLabel jLabelDateRentCar = new JLabel();
        JLabel jLabelDateReturnCar = new JLabel();
        jTextFieldDateRentCar = new JTextField();
        jTextFieldDateReturnCar = new JTextField();
        JButton jButtonOk = new JButton();
        JLabel jLabel5 = new JLabel();
        JRadioButton jRadioButtonCarStatusFree = new JRadioButton();
        JRadioButton jRadioButtonCarStatusDAMAGED = new JRadioButton();
        jRadioButtonCarStatusFree.setSelected(true);
        buttonGroupCarStatus.add(jRadioButtonCarStatusFree);
        buttonGroupCarStatus.add(jRadioButtonCarStatusDAMAGED);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Zwrot samochodu");

        jTableRentedCar.setModel(rentTableModel);
        jTableRentedCar.getTableHeader().setReorderingAllowed(false);
        if (jTableRentedCar.getColumnModel().getColumnCount() > 0) {
            jTableRentedCar.getColumnModel().getColumn(0).setPreferredWidth(30);
        }
        jScrollPane1.setViewportView(jTableRentedCar);
        jTableRentedCar.getSelectionModel().addListSelectionListener(evt -> rentTableSelectedActionPerformed(rentTableModel));

        jLabelCarID.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        jLabelCarID.setText("Zwrot samochodu: ");

        jLabel4.setText("Samochód");

        jLabelRegNumber.setText("Numer rejestracyjny:");

        jLabelMark.setText("Marka :");

        jLabelModel.setText("Model:");

        jLabelColor.setText("Kolor:");

        jLabelPrice.setText("Cena za dzień: ");


        jLabel10.setText("Wypożyczony przez:");

        jLabelCustomerID.setText("ID :");

        jLabelFirstName.setText("Imię:");

        jLabelLastName.setText("Nazwisko:");

        jLabelStreet.setText("Ulica:");

        jLabelHouseNumber.setText("Numer domu:");

        jLabelPostalCode.setText("Kod pocztowy:");

        jLabelCity.setText("Miasto:");


        jLabel1.setText("Wybierz samochód do zwrotu:");

        jLabel2.setText("Realna data zwrotu: ");

        jLabelCarStatus.setText("Stan samochodu :");

        jLabelDelayFee.setText("Opłata za opóźnienie:");

        jTextFieldDelayFee.setText("0");


        jLabel19.setText("zł");

        jLabel20.setText("Koszty naprawy:");

        jTextFieldRepairFee.setText("0");
        jTextFieldRepairFee.addActionListener(this::jTextFieldRepairFeeActionPerformed);


        jLabel21.setText("zł");

        jLabelTotalPrice.setText("Całkowity koszt wynajmu:");

        jTextFieldTotalPrice.setText("0");
        jTextFieldTotalPrice.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));

        jLabel23.setText("zł");

        jLabelDateRentCar.setText("Data wynajęcia:");

        jLabelDateReturnCar.setText("Przewidywana data zwrotu:");

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(this::jButtonOkActionPerformed);

        jLabel5.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLabel5.setText("Zwrot samochodu");

        jRadioButtonCarStatusFree.setText("Sprawny");
        jRadioButtonCarStatusFree.addActionListener(this::jRadioButtonCarStatusFreeActionPerformed);

        jRadioButtonCarStatusDAMAGED.setText("Uszkodzony");
        jRadioButtonCarStatusDAMAGED.addActionListener(this::jRadioButtonCarStatusDAMAGEDActionPerformed);

        jDateChooserRealReturnDate.setDateFormatString("yyyy-MM-dd");
        jDateChooserRealReturnDate.getDateEditor().addPropertyChangeListener(this::RealReturnDateActionPerformed);

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
        jTextFieldDateRentCar.setEditable(false);
        jTextFieldDateReturnCar.setEditable(false);
        jTextFieldRepairFee.setEditable(false);
        jTextFieldDelayFee.setEditable(false);
        jTextFieldTotalPrice.setEditable(false);


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel10)
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
                                                                        .addComponent(jLabelCity)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabelCarStatus)
                                                        .addComponent(jLabel20)
                                                        .addComponent(jLabelDateRentCar)
                                                        .addComponent(jLabelTotalPrice)
                                                        .addComponent(jLabelDelayFee)
                                                        .addComponent(jLabelDateReturnCar))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
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
                                                                .addComponent(jDateChooserRealReturnDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(tStreet, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jTextFieldDelayFee, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel19))
                                                                .addComponent(jTextFieldDateReturnCar, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                                                .addComponent(jTextFieldDateRentCar)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jTextFieldTotalPrice, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                        .addComponent(jTextFieldRepairFee, GroupLayout.Alignment.LEADING))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel21)
                                                                        .addComponent(jLabel23)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jRadioButtonCarStatusFree)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jRadioButtonCarStatusDAMAGED)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonOk, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(jLabelCarID, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(107, 107, 107)
                                        .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(662, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addComponent(jLabel4)
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
                                                .addComponent(jLabel10)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
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
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelDateRentCar)
                                                        .addComponent(jTextFieldDateRentCar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(6, 6, 6)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelDateReturnCar)
                                                        .addComponent(jTextFieldDateReturnCar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jDateChooserRealReturnDate, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(31, Short.MAX_VALUE)
                                                .addComponent(jLabelCarID)
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDelayFee)
                                        .addComponent(jTextFieldDelayFee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCarStatus)
                                        .addComponent(jRadioButtonCarStatusFree)
                                        .addComponent(jRadioButtonCarStatusDAMAGED))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(jTextFieldRepairFee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTotalPrice)
                                        .addComponent(jTextFieldTotalPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonOk)
                                .addContainerGap(18, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel5)
                                        .addContainerGap(721, Short.MAX_VALUE)))
        );

        pack();
    }

    private void RealReturnDateActionPerformed(PropertyChangeEvent e) {
        if ("date".equals(e.getPropertyName())) {
            if (DateConvert.convertToLocalDate(jDateChooserRealReturnDate.getDate()).compareTo(LocalDate.parse(jTextFieldDateReturnCar.getText())) > 0) {
                Period delayPeriod = Period.between(LocalDate.parse(jTextFieldDateReturnCar.getText()), DateConvert.convertToLocalDate(jDateChooserRealReturnDate.getDate()));
                System.out.println(delayPeriod.getDays());
                totalPrice = BigDecimal.valueOf(Double.parseDouble(tPrice.getText()));
                delayFee = BigDecimal.valueOf(Double.parseDouble(tPrice.getText())).multiply(new BigDecimal(delayPeriod.getDays()));
            } else {
                delayFee = BigDecimal.valueOf(0);
            }
            jTextFieldDelayFee.setText(String.valueOf(delayFee));
            totalPrice = rentPrice.add(delayFee).add(repairFee);
            jTextFieldTotalPrice.setText(String.valueOf(totalPrice));
        }
    }

    private void rentTableSelectedActionPerformed(TableModel rentTableModel) {
        rent = (Rent) new RentDao().findById(Integer.parseInt((String) rentTableModel.getValueAt(jTableRentedCar.getSelectedRow(), 0)));
        jLabelCarID.setText(rent.getCar().getRegNumber());
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
        jTextFieldDateRentCar.setText(String.valueOf(rent.getRentDate()));
        jTextFieldDateReturnCar.setText(String.valueOf(rent.getReturnDate()));
        rentPrice = rent.getPrice();
        totalPrice = rentPrice;
        jTextFieldTotalPrice.setText(String.valueOf(rent.getPrice()));

    }


    private void jTextFieldRepairFeeActionPerformed(java.awt.event.ActionEvent evt) {
        if (!jTextFieldRepairFee.getText().chars().allMatch(Character::isDigit)) {
            JOptionPane.showMessageDialog(this, "Pole koszt naprawy nie jest cyfrą", "Uwaga", JOptionPane.WARNING_MESSAGE);
        } else {
            repairFee = BigDecimal.valueOf(Double.parseDouble(jTextFieldRepairFee.getText()));
            totalPrice = rentPrice.add(delayFee).add(repairFee);
            jTextFieldTotalPrice.setText(String.valueOf(totalPrice));

        }
    }

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {

        if (jTableRentedCar.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Musisz wybrać Samochód do zwrotu", "Uwaga", JOptionPane.WARNING_MESSAGE);
        } else if (jDateChooserRealReturnDate.getDate() == null ||
                DateConvert.convertToLocalDate(jDateChooserRealReturnDate.getDate()).compareTo(LocalDate.parse(jTextFieldDateRentCar.getText())) < 0) {
            JOptionPane.showMessageDialog(this, "Realna data zwrotu jest niepoprawna", "Uwaga", JOptionPane.WARNING_MESSAGE);
        } else {


            rent.setRentStatus(RentStatus.FINISHED);
            rent.setTotalPrice(totalPrice);
            rent.setRealReturnDate(DateConvert.convertToLocalDate(jDateChooserRealReturnDate.getDate()));
            rent.setAdditionalCost(delayFee.add(repairFee));
            Car car = rent.getCar();
            car.setCarStatus(carStatus);
            StringBuilder message = new StringBuilder()
                    .append("Oddano samochód:   ")
                    .append(tRegNumber.getText())
                    .append("  ")
                    .append(tModel.getText())
                    .append("\n")
                    .append("Opłata za wynajem :               ")
                    .append(rentPrice)
                    .append(" zł\n");
            if (!(delayFee.compareTo(BigDecimal.valueOf(0)) == 0)) {
                message.append("Opłata za opóźnienie :             ")
                        .append(delayFee)
                        .append(" zł\n");
            }
            if (!(repairFee.compareTo(BigDecimal.valueOf(0)) == 0)) {
                message.append("Opłata za uszkodzenia :          ")
                        .append(repairFee)
                        .append(" zł\n");
            }
            message.append("-------------------------------------------")
                    .append("\n Całkowity koszt wynajmu:    ")
                    .append(totalPrice)
                    .append("zł");
            JOptionPane.showMessageDialog(this, message);
            new RentDao().update(rent);
            new CarDao().update(car);
            this.dispose();
        }

    }

    private void jRadioButtonCarStatusDAMAGEDActionPerformed(java.awt.event.ActionEvent evt) {
        carStatus = CarStatus.DAMAGED;
        jTextFieldRepairFee.setEditable(true);
    }

    private void jRadioButtonCarStatusFreeActionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldRepairFee.setText("0");
        repairFee = BigDecimal.valueOf(Double.parseDouble(jTextFieldRepairFee.getText()));
        totalPrice = rentPrice.add(delayFee).add(repairFee);
        jTextFieldTotalPrice.setText(String.valueOf(totalPrice));
        jTextFieldRepairFee.setEditable(false);
        carStatus = CarStatus.FREE;
    }


}