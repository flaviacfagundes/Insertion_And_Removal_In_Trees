package view;

import java.util.HashMap;
import java.awt.*;
import javax.swing.*;

public class TelaPrincipal extends JFrame {
    JLabel insertInputLabel;
    JTextField insertInputField;
    JLabel insertLogLabel;
    JLabel removeInputLabel;
    JTextField removeInputField;
    JLabel removeLogLabel;

    public TelaPrincipal(String title, int X, int Y) {
        setup(title, X, Y);

        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 20));

        // ---------------- Painel de Inputs ----------------
        JPanel inputsPanel = new JPanel(new GridLayout(8, 0));
        insertInputLabel = new JLabel("Inserir elemento na árvore:");
        insertInputField = new JTextField(20);
        JButton submitInsertionButton = new JButton("Inserir nó");
        submitInsertionButton.addActionListener(_ -> submitInsertionHandler());
        insertLogLabel = new JLabel("log: ");

        removeInputLabel = new JLabel("Remover elemento na árvore:");
        removeInputField = new JTextField(20);
        JButton submitRemovalButton = new JButton("Remover nó");
        submitRemovalButton.addActionListener(_ -> submitRemovalHandler());
        removeLogLabel = new JLabel("log: ");

        inputsPanel.add(insertInputLabel);
        inputsPanel.add(insertInputField);
        inputsPanel.add(submitInsertionButton);
        inputsPanel.add(insertLogLabel);
        inputsPanel.add(removeInputLabel);
        inputsPanel.add(removeInputField);
        inputsPanel.add(submitRemovalButton);
        inputsPanel.add(removeLogLabel);

        // ---------------- Painel de Árvore ----------------

        add(panel);
        setVisible(true);
    }

    public void setup(String title, int X, int Y) {
        HashMap<String, Integer> size = new HashMap<>();
        size.put("X", X);
        size.put("Y", Y);
        setTitle(title);
        setSize(size.get("X"), size.get("Y"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void submitInsertionHandler() {
        String inputText = insertInputField.getText();
        try {
            int intValue = Integer.parseInt(inputText);
            // TODO: inserir nó na árvore real
            insertLogLabel.setText("log: elemento " + intValue + " inserido com sucesso!");
        } catch (NumberFormatException nfe) {
            insertLogLabel.setText("log: valor Inteiro invalido!");
            JOptionPane.showMessageDialog(null, "Por favor insira um valor inteiro valido!");
        }
    }

    public void submitRemovalHandler() {
        String input = removeInputField.getText();
        try {
            int intValue = Integer.parseInt(input);
            // TODO: remover nó na árvore real
            removeLogLabel.setText("log: elemento " + intValue + " removido com sucesso!");
        } catch (NumberFormatException nfe) {
            removeLogLabel.setText("log: valor Inteiro invalido!");
            JOptionPane.showMessageDialog(null, "Por favor insira um valor inteiro valido!");
        }
    }
}
