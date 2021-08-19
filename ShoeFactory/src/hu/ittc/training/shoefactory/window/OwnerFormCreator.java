package hu.ittc.training.shoefactory.window;

import hu.ittc.training.shoefactory.model.Owner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerFormCreator extends FormCreator{

    JTextField textField;
    JTextField textField2;

    public OwnerFormCreator() {
        JLabel label = new JLabel("Please add the name of the owner:");
        JLabel label2 = new JLabel("Please add the footsize:");
        this.setModal(true);
        this.getContentPane().setLayout(null);
        this.add(label);
        this.add(label2);
        label.setBounds(10,0,400,20);
        label2.setBounds(10,60,400,20);
        this.setSize(400,400);
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
                OwnerFormCreator.super.setVisible(false);
            }
        });
        this.getContentPane().add(button);
        this.getRootPane().setDefaultButton(button);
        button.requestFocus();
        button.setBounds(80,120,60,40);

        this.setLocationRelativeTo(null);
    }

    @Override
    public Object getCreatedObject() {
        return new Owner(textField.getText(), Integer.parseInt(textField2.getText()));
    }
}
