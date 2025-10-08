
package view;

import controller.ArvoreController;
import model.service.ArvoreService;
import view.component.PainelArvore;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    private JTextField insertInputField;
    private JLabel insertLogLabel;
    private JTextField removeInputField;
    private JLabel removeLogLabel;
    private JCheckBox balancedTreeCheckbox;
    private PainelArvore painelArvore;
    private final ArvoreController controller;
    public TelaPrincipal(String title, int width, int height) {
        super(title);
        this.controller = new ArvoreController(new ArvoreService());
        setup(width, height);
        initComponents();
        setVisible(true);
    }
    private void setup(int width, int height) {
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }
    private void initComponents() {
        JPanel controlPanel = new JPanel(new GridBagLayout());
        controlPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Controles"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Padding interno
        ));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5); // Aumenta o espaçamento vertical
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        controlPanel.add(new JLabel("Inserir elemento:"), gbc);
        gbc.gridy = 1;
        insertInputField = new JTextField(15); // Aumenta um pouco o tamanho
        controlPanel.add(insertInputField, gbc);
        gbc.gridy = 2;
        JButton submitInsertionButton = new JButton("Inserir");
        submitInsertionButton.addActionListener(_ -> submitInsertionHandler());
        controlPanel.add(submitInsertionButton, gbc);
        gbc.gridy = 3;
        insertLogLabel = new JLabel("Log:");
        controlPanel.add(insertLogLabel, gbc);
        gbc.gridy = 4;
        controlPanel.add(new JSeparator(), gbc);
        gbc.gridy = 5;
        controlPanel.add(new JLabel("Remover elemento:"), gbc);
        gbc.gridy = 6;
        removeInputField = new JTextField(15);
        controlPanel.add(removeInputField, gbc);
        gbc.gridy = 7;
        JButton submitRemovalButton = new JButton("Remover");
        submitRemovalButton.addActionListener(_ -> submitRemovalHandler());
        controlPanel.add(submitRemovalButton, gbc);
        gbc.gridy = 8;
        removeLogLabel = new JLabel("Log:");
        controlPanel.add(removeLogLabel, gbc);
        gbc.gridy = 9;
        controlPanel.add(new JSeparator(), gbc);
        gbc.gridy = 10;
        balancedTreeCheckbox = new JCheckBox("Usar Árvore Balanceada (AVL)");
        controlPanel.add(balancedTreeCheckbox, gbc);
        painelArvore = new PainelArvore();
        add(new JScrollPane(painelArvore), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.WEST);
    }
    private void submitInsertionHandler() {
        try {
            int value = Integer.parseInt(insertInputField.getText());
            boolean isBalanced = balancedTreeCheckbox.isSelected();
            controller.inserirNumero(value, isBalanced);
            painelArvore.setRaiz(controller.getRaiz(isBalanced));
            insertLogLabel.setText("Log: " + value + " inserido.");
            insertInputField.setText("");
        } catch (NumberFormatException e) {
            insertLogLabel.setText("Log: Valor inválido.");
            JOptionPane.showMessageDialog(this, "Por favor, insira um número inteiro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void submitRemovalHandler() {
        try {
            int value = Integer.parseInt(removeInputField.getText());
            boolean isBalanced = balancedTreeCheckbox.isSelected();
            controller.removerNumero(value, isBalanced);
            painelArvore.setRaiz(controller.getRaiz(isBalanced));
            removeLogLabel.setText("Log: " + value + " removido.");
            removeInputField.setText("");
        } catch (NumberFormatException e) {
            removeLogLabel.setText("Log: Valor inválido.");
            JOptionPane.showMessageDialog(this, "Por favor, insira um número inteiro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
