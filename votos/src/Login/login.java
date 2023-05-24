/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Login;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Albino Junior
 */
public class login {

    /**
     * @param args the command line arguments
     */
        // TODO code application logic here
        public class LoginForm extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de conteúdo
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Rótulos
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        // Campos de texto
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        // Botão de login
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener((ActionListener) this);

        // Adiciona componentes ao painel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(loginButton);

        // Adiciona o painel ao frame
        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        // Verificar credenciais
        if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
        } else {
            JOptionPane.showMessageDialog(this, "Credenciais inválidas. Tente novamente.");
        }

        // Limpar campos de texto
        usernameField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
    }
}
        
    }
    

