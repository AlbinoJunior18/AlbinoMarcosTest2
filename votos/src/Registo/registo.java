/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registo;
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Albino Junior
 */
public class registo {
  

public class RegistrationForm extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField emailField;
    private JButton registerButton;
    private List<String> registeredUsers;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de conteúdo
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Rótulos
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");

        // Campos de texto
        nameField = new JTextField();
        emailField = new JTextField();

        // Botão de registro
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        // Adiciona componentes ao painel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(registerButton);

        // Adiciona o painel ao frame
        add(panel);

        registeredUsers = new ArrayList<>();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();

        // Verificar se o usuário já está registrado
        if (registeredUsers.contains(email)) {
            JOptionPane.showMessageDialog(this, "O email já está registrado!");
        } else {
            // Registrar o usuário
            registeredUsers.add(email);
            JOptionPane.showMessageDialog(this, "Registro bem-sucedido!");
        }

        // Limpar campos de texto
        nameField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
}
