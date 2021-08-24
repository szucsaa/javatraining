package hu.ittc.training.shoefactory.window;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.persistence.DBConnector;
import javafx.beans.property.IntegerPropertyBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class OwnerFormCreator extends FormCreator{

    public OwnerFormCreator(Connection connection){
        super("Please add the name of the owner:", "Please add the footsize:", connection);
    }

    @Override
    public Object getCreatedObject() {

        Owner owner = new Owner(textField.getText(), Integer.parseInt(textField2.getText()));
        DBConnector.saveOwner(connection, owner);
        return owner;
    }
}
