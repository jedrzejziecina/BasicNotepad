package Notepad;

public class Main {

    public static void main(String[] args) {
        String filename = "Bez Tytułu";
        Layout layout = new Layout("Prosty Edytor - " + filename);
        layout.setSize(500,500);
        layout.setVisible(true);
    }
}