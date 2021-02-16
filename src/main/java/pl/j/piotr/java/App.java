package pl.j.piotr.java;

import pl.k.kamil.java.menu.MainMenu;

import java.awt.*;

public class App {


    public static void main(String[] args) {

        EventQueue.invokeLater(() -> new MainMenu().setVisible(true));

    }
}