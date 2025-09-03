import gui.TelaPrincipalGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipalGUI tela = new TelaPrincipalGUI();
            tela.setVisible(true);
        });
    }
}