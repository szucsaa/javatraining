package hu.ittc.training.shoefactory.window;

import hu.ittc.training.shoefactory.model.Shoe;
import hu.ittc.training.shoefactory.persistence.DBConnector;

public class ShoeFormCreator extends FormCreator {

    public ShoeFormCreator(DBConnector dbConnector){
        super("Please add the name of the brand:", "Please add the size:", dbConnector);
    }

    @Override
    public Object getCreatedObject() {

        Shoe shoe = new Shoe(Integer.parseInt(textField2.getText()), textField.getText(), false);
        dbConnector.saveShoe(shoe);
        return shoe;
    }

}
