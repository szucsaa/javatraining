package hu.ittc.training.shoefactory.window;

import hu.ittc.training.shoefactory.model.Owner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerFormCreator extends FormCreator{

    public OwnerFormCreator(){
        super("Please add the name of the owner:", "Please add the footsize:");
    }

    @Override
    public Object getCreatedObject() {
        return new Owner(textField.getText(), Integer.parseInt(textField2.getText()));
    }
}
