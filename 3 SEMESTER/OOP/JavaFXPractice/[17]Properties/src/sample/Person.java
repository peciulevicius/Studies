package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    //String property is abstract class
    //SimpleStringProperty is a class which we can read and write to.
    //3 parameters (this - whole object), first name, and default value of nothing ""
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    //Returns the StringProperty object (returns an object)
    public StringProperty firstNameProperty() {
        return firstName;
    }

    //return first name value
    public String getFirstName() {
        return firstName.get();
    }


    //set the first name value
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

}
