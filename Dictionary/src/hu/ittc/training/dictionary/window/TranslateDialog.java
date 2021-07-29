package hu.ittc.training.dictionary.window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranslateDialog extends JDialog {

    private String word;
    private JTextField textField;

    public TranslateDialog(String word) {
        this.word = word;
        JLabel label = new JLabel("Please type the translated word for "+word+" :");
        this.setModal(true);
        this.getContentPane().setLayout(null);
        this.add(label);
        label.setBounds(10,0,400,20);
        this.setSize(400,150);
        textField = new JTextField();
        this.add(textField);
        textField.setBounds(10, 30, 200, 20);
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TranslateDialog.super.setVisible(false);
            }
        });
        this.getContentPane().add(button);
        this.getRootPane().setDefaultButton(button);
        button.requestFocus();
        button.setBounds(80,60,60,40);

        this.setLocationRelativeTo(null);
    }

    public String getTranslatedWord() {
        return textField.getText();
    }
}
