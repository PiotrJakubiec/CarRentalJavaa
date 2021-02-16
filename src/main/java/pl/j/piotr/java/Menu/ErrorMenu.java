package pl.j.piotr.java.Menu;


import javax.swing.*;

public class ErrorMenu {

    public void emptyJTextField() {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Pola nie mogą być puste", "Uwaga", JOptionPane.WARNING_MESSAGE);

    }


    public void priceIsNotDigit(String price) {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Pole Cena za dzień : " + price + " - nie jest cyfrą", "Uwaga", JOptionPane.WARNING_MESSAGE);

    }
}