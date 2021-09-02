package hu.ittc.training.shoefactory.window;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.persistence.DBConnector;

import java.util.ArrayList;
import java.util.List;

public class OwnerFormCreator extends FormCreator{

    public OwnerFormCreator(DBConnector dbConnector){
        super("Please add the name of the owner:", "Please add the footsize:", dbConnector);
    }

    @Override
    public Object getCreatedObject() {

        Owner owner = new Owner(textField.getText(), Integer.parseInt(textField2.getText()));
        dbConnector.saveOwner(owner);
        return owner;
    }

    @Override
    public ArrayList getObjectList(Integer size) {
        return dbConnector.readShoes(size);
    }
}
