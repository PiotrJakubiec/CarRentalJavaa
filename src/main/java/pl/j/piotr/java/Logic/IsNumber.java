package pl.j.piotr.java.Logic;

public class IsNumber {

    public static boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
