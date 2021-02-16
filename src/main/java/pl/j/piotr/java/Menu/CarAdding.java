package pl.j.piotr.java.Menu;


import pl.p.piotr.java.Dao.CarDao;
import pl.p.piotr.java.Logic.IsNumber;
import pl.p.piotr.java.Logic.ListToTableModel;
import pl.p.piotr.java.Logic.SearchMenuFunction;
import pl.p.piotr.java.Logic.ToUpdateEdit;
import pl.p.piotr.java.Model.Car;
import pl.p.piotr.java.Model.CarStatus;

import javax.persistence.PersistenceException;
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class CarAddUpdateMenu extends JFrame{

    private JTextField jTextFieldColor;
    private JTextField jTextFieldMark;
    private JTextField jTextFieldModel;
    private JTextField jTextFieldPrice;
    private JTextField jTextFieldRegNumber;


    public CarAddUpdateMenu(SearchMenuFunction searchMenuFunction) {
        initComponents(searchMenuFunction,new Car());
    }

    public CarAddUpdateMenu(SearchMenuFunction searchMenuFunction,Car car) {
        initComponents(searchMenuFunction,car);
    }

    private void initComponents(SearchMenuFunction searchMenuFunction,Car car) {


        ButtonGroup buttonGroupStatus = new ButtonGroup();
        JLabel jLabelRegNumber = new JLabel();
        JLabel jLabelMark = new JLabel();
        JLabel jLabelTitle = new JLabel();
        JLabel jLabelModel = new JLabel();
        JLabel jLabelColor = new JLabel();
        JLabel jLabelPrice = new JLabel();
        jTextFieldRegNumber = new JTextField();
        jTextFieldMark = new JTextField();
        jTextFieldModel = new JTextField();
        jTextFieldColor = new JTextField();
        jTextFieldPrice = new JTextField();
        JButton jButtonAction = new JButton();
        JLabel jLabelCurrency = new JLabel();
        JRadioButton jRadioButtonFREE = new JRadioButton();
        JRadioButton jRadioButtonDAMAGED = new JRadioButton();
        JRadioButton jRadioButtonRENTED = new JRadioButton();
        JLabel jLabel1 = new JLabel();


        jLabelRegNumber.setText("Numer rejestracyjny : ");
        jLabelMark.setText("Marka:");

        jLabelModel.setText("Model:");
        jLabelColor.setText("Kolor:");
        jLabelPrice.setText("Cena za dzień:");

        jLabelCurrency.setText("zł");
        jButtonAction.addActionListener(evt -> jButton1ActionPerformed(searchMenuFunction, car));



        jLabel1.setText("Stan:");


        jRadioButtonFREE.setText("Wolny");
        jRadioButtonFREE.addActionListener(evt -> car.setCarStatus(CarStatus.FREE));

        jRadioButtonDAMAGED.setText("Uszkodzony");
        jRadioButtonDAMAGED.addActionListener(evt -> car.setCarStatus(CarStatus.DAMAGED));

        jRadioButtonRENTED.setText("Wynajęty");


        buttonGroupStatus.add(jRadioButtonFREE);
        buttonGroupStatus.add(jRadioButtonDAMAGED);
        buttonGroupStatus.add(jRadioButtonRENTED);




        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAction)
                                .addGap(201, 201, 201))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(199, 199, 199)
                                                .addComponent(jLabelTitle))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelMark)
                                                        .addComponent(jLabelRegNumber)
                                                        .addComponent(jLabelModel)
                                                        .addComponent(jLabelColor)
                                                        .addComponent(jLabelPrice)
                                                        .addComponent(jLabel1))
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextFieldPrice, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabelCurrency))
                                                        .addComponent(jTextFieldMark, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldRegNumber, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldModel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldColor, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jRadioButtonFREE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jRadioButtonDAMAGED)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jRadioButtonRENTED)))))
                                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabelTitle)
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelRegNumber)
                                        .addComponent(jTextFieldRegNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelMark)
                                        .addComponent(jTextFieldMark, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelModel)
                                        .addComponent(jTextFieldModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelColor)
                                        .addComponent(jTextFieldColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPrice)
                                        .addComponent(jTextFieldPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelCurrency))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jRadioButtonFREE)
                                        .addComponent(jRadioButtonDAMAGED)
                                        .addComponent(jRadioButtonRENTED))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(jButtonAction)
                                .addGap(36, 36, 36))
        );

        pack();

        switch (searchMenuFunction) {
            case ADD:
                jLabelTitle.setText("Dodaj samochód:");
                jButtonAction.setText("Dodaj");
                jRadioButtonFREE.setSelected(true);
                jRadioButtonRENTED.setEnabled(false);
                jRadioButtonRENTED.setVisible(false);


                break;
            case EDIT:
                jLabelTitle.setText("Uaktualnij dane o samochodzie:");
                jButtonAction.setText("Uaktualnij dane o samochodzie");
                jTextFieldRegNumber.setText(car.getRegNumber());
                jTextFieldRegNumber.setEditable(false);
                jTextFieldMark.setText(car.getMark());
                jTextFieldModel.setText(car.getModel());
                jTextFieldColor.setText(car.getColor());
                jTextFieldPrice.setText(String.valueOf(car.getPrice()));

                switch (car.getCarStatus()) {
                    case FREE:
                        jRadioButtonFREE.setSelected(true);
                        jRadioButtonRENTED.setEnabled(false);
                        break;
                    case DAMAGED:
                        jRadioButtonRENTED.setEnabled(false);
                        jRadioButtonDAMAGED.setSelected(true);
                        break;
                    case RENTED:
                        jRadioButtonFREE.setEnabled(false);
                        jRadioButtonDAMAGED.setEnabled(false);
                        jRadioButtonRENTED.setSelected(true);
                        break;
                }


                break;
            case SEARCH:
                jLabelTitle.setText("Wyszukaj samochód:");
                jButtonAction.setText("Wyszukaj");
                break;

        }
    }
    private void jButton1ActionPerformed(SearchMenuFunction searchMenuFunction,Car car) {
        switch (searchMenuFunction) {
            case ADD:
                if (jTextFieldRegNumber.getText().equals("") || jTextFieldMark.getText().equals("") || jTextFieldModel.getText().equals("") || jTextFieldColor.getText().equals("") || jTextFieldPrice.getText().equals("")) {
                    new ErrorMenu().emptyJTextField();
                } else if (!IsNumber.isNumeric(jTextFieldPrice.getText())) {
                    new ErrorMenu().priceIsNotDigit(jTextFieldPrice.getText());
                } else {

                    try {
                        new CarDao().add(new Car(jTextFieldRegNumber.getText(), jTextFieldMark.getText(), jTextFieldModel.getText(), jTextFieldColor.getText(), BigDecimal.valueOf(Long.parseLong(jTextFieldPrice.getText())), CarStatus.FREE));
                        JOptionPane.showMessageDialog(this, "Dodano samochód :\n" + jTextFieldRegNumber.getText() + " " + jTextFieldMark.getText(),"Dodano samochód", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (PersistenceException e) {
                        JOptionPane.showMessageDialog(this, "Samochód już istnieje", "Uwaga", JOptionPane.ERROR_MESSAGE);
                    }
                    this.dispose();
                    new SearchAll(new ListToTableModel().allCarTable(new CarDao().findAll()), ToUpdateEdit.CAR).setVisible(true);
                }

                break;
            case EDIT:
                if (jTextFieldRegNumber.getText().equals("") || jTextFieldMark.getText().equals("") || jTextFieldModel.getText().equals("") || jTextFieldColor.getText().equals("") || jTextFieldPrice.getText().equals("")) {
                    new ErrorMenu().emptyJTextField();
                } else if (!IsNumber.isNumeric(jTextFieldPrice.getText())) {
                    new ErrorMenu().priceIsNotDigit(jTextFieldPrice.getText());
                } else {
                    car.setModel(jTextFieldModel.getText());
                    car.setMark(jTextFieldMark.getText());
                    car.setColor(jTextFieldColor.getText());
                    car.setPrice(BigDecimal.valueOf(Double.parseDouble(jTextFieldPrice.getText())));

                    try {
                        new CarDao().update(car);
                        JOptionPane.showMessageDialog(this, "Uaktualniono dane o samochodzie :\n" + jTextFieldRegNumber.getText() + " " + jTextFieldMark.getText(), "Uaktualniono dane o samochodzie", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (PersistenceException e) {
                        JOptionPane.showMessageDialog(this, "Samochód już istnieje", "Uwaga", JOptionPane.ERROR_MESSAGE);
                    }
                    this.dispose();
                    new SearchAll(new ListToTableModel().allCarTable(new CarDao().findAll()), ToUpdateEdit.CAR).setVisible(true);
                }


                break;
            case SEARCH:

                break;

        }


    }
}
