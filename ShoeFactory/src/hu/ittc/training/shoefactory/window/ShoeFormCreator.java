package hu.ittc.training.shoefactory.window;

import hu.ittc.training.shoefactory.model.Shoe;
import hu.ittc.training.shoefactory.persistence.DBConnector;

import java.sql.Connection;

public class ShoeFormCreator extends FormCreator {

    public ShoeFormCreator(Connection connection){
        super("Please add the name of the brand:", "Please add the size:", connection);
    }

    @Override
    public Object getCreatedObject() {

        Shoe shoe = new Shoe(Integer.parseInt(textField2.getText()), textField.getText(), false);
        DBConnector.saveShoe(connection, shoe);
        return shoe;
    }

}
