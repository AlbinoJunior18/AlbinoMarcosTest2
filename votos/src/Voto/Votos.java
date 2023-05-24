/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Voto;
    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Albino Junior
 */
public class Votos {

public class VotingApp extends JFrame implements ActionListener {
    private JLabel candidateLabel;
    private JButton voteButton;
    private JLabel resultLabel;

    private int candidate1Votes;
    private int candidate2Votes;

    public VotingApp() {
        setTitle("Voting App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel de conteúdo
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Rótulo do candidato
        candidateLabel = new JLabel("Vote for your favorite candidate");

        // Botão de voto
        voteButton = new JButton("Vote");
        voteButton.addActionListener(this);

        // Rótulo de resultado
        resultLabel = new JLabel("Candidate 1: " + candidate1Votes + " votes | Candidate 2: " + candidate2Votes + " votes");

        // Adiciona componentes ao painel
        panel.add(candidateLabel);
        panel.add(voteButton);
        panel.add(resultLabel);

        // Adiciona o painel ao frame
        add(panel);

        candidate1Votes = 0;
        candidate2Votes = 0;

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == voteButton) {
            int choice = JOptionPane.showOptionDialog(this, "Select your candidate", "Vote", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, new String[]{"Candidate 1", "Candidate 2"}, null);

            if (choice == 0) {
                candidate1Votes++;
            } else if (choice == 1) {
                candidate2Votes++;
            }

            resultLabel.setText("Candidate 1: " + candidate1Votes + " votes | Candidate 2: " + candidate2Votes + " votes");
        }
    }

    public static void main(String[] args) {
        new VotingApp();
    }
}

public class FileWritingExample {
   
    public static void main(String[] args) {
        String content = "Este é um exemplo de texto a ser gravado em um arquivo.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("arquivo.txt"))) {
            writer.write(content);
            System.out.println("Informações gravadas com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gravar as informações no arquivo: " + e.getMessage());
        }
    }
}
}
