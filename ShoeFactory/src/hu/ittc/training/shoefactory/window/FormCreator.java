package hu.ittc.training.shoefactory.window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class FormCreator extends JDialog {

    JTextField textField;
    JTextField textField2;

    public FormCreator(String labelText1, String labelText2) {
        JLabel label = new JLabel(labelText1);
        JLabel label2 = new JLabel(labelText2);
        this.setModal(true);
        this.getContentPane().setLayout(null);
        this.add(label);
        this.add(label2);
        label.setBounds(10,0,400,20);
        label2.setBounds(10,60,400,20);
        this.setSize(280,220);
        textField = new JTextField();
        textField2 = new JTextField();
        this.add(textField);
        this.add(textField2);
        textField.setBounds(10, 30, 200, 20);
        textField2.setBounds(10, 90, 200, 20);
        JButton button = new JButton("Ok");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        this.getContentPane().add(button);
        this.getRootPane().setDefaultButton(button);
        button.requestFocus();
        button.setBounds(80,120,60,40);

        this.setLocationRelativeTo(null);
    }

    public abstract Object getCreatedObject();

}
