package hu.ittc.training.shoefactory.window;

import hu.ittc.training.shoefactory.model.Shoe;

public class ShoeFormCreator extends FormCreator {

    public ShoeFormCreator(){
        super("Please add the name of the brand:", "Please add the size:");
    }

    @Override
    public Object getCreatedObject() {
        return new Shoe(Integer.parseInt(textField2.getText()), textField.getText(), false);
    }

}
