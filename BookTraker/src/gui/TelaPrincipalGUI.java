package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaPrincipalGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtAno;
    private JTextField txtGenero;
    private JButton btnAdicionar;
    private JButton btnAtualizar;
    private JButton btnExcluir;
    private JTable table2;

    private DefaultTableModel modelo;

    public TelaPrincipalGUI() {
        setTitle("Book Tracker");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(mainPanel);

        JPanel formPanel = new JPanel(new GridLayout(2, 5, 10, 10));

        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        txtAno = new JTextField();
        txtGenero = new JTextField();




        formPanel.add(new JLabel("Título:"));
        formPanel.add(new JLabel("Autor:"));
        formPanel.add(new JLabel("Ano:"));
        formPanel.add(new JLabel("Gênero:"));


        formPanel.add(txtTitulo);
        formPanel.add(txtAutor);
        formPanel.add(txtAno);
        formPanel.add(txtGenero);


        mainPanel.add(formPanel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAdicionar = new JButton("Adicionar");
        btnAtualizar = new JButton("Atualizar");
        btnExcluir = new JButton("Excluir");
        buttonsPanel.add(btnAdicionar);
        buttonsPanel.add(btnAtualizar);
        buttonsPanel.add(btnExcluir);

        mainPanel.add(buttonsPanel, BorderLayout.CENTER);

        String[] colunas = {"ID", "Título", "Autor", "Ano", "Gênero"};
        modelo = new DefaultTableModel(colunas, 0);
        table2 = new JTable(modelo);
        table2.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table2);
        scrollPane.setPreferredSize(new Dimension(600, 200));
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        configurarBotoes();
        configurarSelecaoTabela();
    }

    private void configurarBotoes() {
        btnAdicionar.addActionListener(e -> {
            int id = modelo.getRowCount() + 1;
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            String ano = txtAno.getText();
            String genero = txtGenero.getText();


            if (titulo.isEmpty() || autor.isEmpty() || ano.isEmpty() || genero.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            modelo.addRow(new Object[]{id, titulo, autor, ano, genero});
            limparCampos();
        });

        btnAtualizar.addActionListener(e -> {
            int linha = table2.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um livro para atualizar!");
                return;
            }

            modelo.setValueAt(txtTitulo.getText(), linha, 1);
            modelo.setValueAt(txtAutor.getText(), linha, 2);
            modelo.setValueAt(txtAno.getText(), linha, 3);
            modelo.setValueAt(txtGenero.getText(), linha, 4);


            limparCampos();
        });

        btnExcluir.addActionListener(e -> {
            int linha = table2.getSelectedRow();
            if (linha == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um livro para excluir!");
                return;
            }
            modelo.removeRow(linha);
            limparCampos();
        });
    }

    private void configurarSelecaoTabela() {
        table2.getSelectionModel().addListSelectionListener(e -> {
            int linha = table2.getSelectedRow();
            if (linha != -1) {
                txtTitulo.setText((String) modelo.getValueAt(linha, 1));
                txtAutor.setText((String) modelo.getValueAt(linha, 2));
                txtAno.setText((String) modelo.getValueAt(linha, 3));
                txtGenero.setText((String) modelo.getValueAt(linha, 4));

            }
        });
    }

    private void limparCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtAno.setText("");
        txtGenero.setText("");

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipalGUI gui = new TelaPrincipalGUI();
            gui.setVisible(true);
        });
    }
}
