/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Registomunicipio;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

/**
 *
 * @author Albino Junior
 */
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class Registomunicipio {
    private String nome;
    private String estado;

    public Registomunicipio nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }

    Registomunicipio(String nome, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
}

class RegistroMunicipios {
    private List<Registomunicipio> municipios;

    public RegistroMunicipios() {
        municipios = new ArrayList<>();
    }

    public void adicionarMunicipio(String nome, String estado) {
        Registomunicipio municipio = new Registomunicipio(nome, estado);
        municipios.add(municipio);
        JOptionPane.showMessageDialog(null, "Município registrado com sucesso!");
    }

    public String exibirMunicipios() {
        StringBuilder municipiosRegistrados = new StringBuilder();
        if (municipios.isEmpty()) {
            municipiosRegistrados.append("Nenhum município registrado.");
        } else {
            municipiosRegistrados.append("Municípios registrados:\n");
            for (Registomunicipio municipio : municipios) {
                municipiosRegistrados.append("Nome: ").append(municipio.getNome()).append(", Estado: ").append(municipio.getEstado()).append("\n");
            }
        }
        return municipiosRegistrados.toString();
    }
}

public class Registomunicipio extends JFrame implements ActionListener {
    private JTextField nomeField;
    private JTextField estadoField;
    private JButton registerButton;
    private JTextArea municipiosArea;
    private RegistroMunicipios registro;

    public MunicipioRegistrationForm() {
        setTitle("Registro de Municípios");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de conteúdo
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        // Rótulos
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel estadoLabel = new JLabel("Estado:");

        // Campos de texto
        nomeField = new JTextField();
        estadoField = new JTextField();

        // Botão de registro
        registerButton = new JButton("Registrar");
        registerButton.addActionListener(this);

        // Área de texto para exibir os municípios registrados
        municipiosArea = new JTextArea();
        municipiosArea.setEditable(false);
        municipiosArea.setLineWrap(true);

        // Adiciona componentes ao painel
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(estadoLabel);
        panel.add(estadoField);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(registerButton);
        panel.add(new JLabel("Municípios Registrados:"));
        panel.add(new JScrollPane(municipiosArea));

        // Adiciona o painel ao frame
        add(panel);

        registro = new RegistroMunicipios();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String nome = nomeField.getText();
        String estado = estadoField.getText();

        registro.adicionarMunicipio(nome, estado);
        municipiosArea.setText(registro.exibirMunicipios());

        // Limpar campos de texto
        nomeField.setText("");
        estadoField.setText("");
    }

    public static void main(String[] args) {
        new MunicipioRegistrationForm();
    }
}
    

