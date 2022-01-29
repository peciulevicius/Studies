package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Orders {
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty country;
    private StringProperty city;
    private StringProperty  address;
    private StringProperty  apartment;
    private StringProperty  postalCode;
    private StringProperty item;

    public Orders(){this(null,null,null,null,null, null,null,null);}

    public Orders(String firstName, String lastName, String country, String city, String address,String apartment, String postalCode, String item){
        this.firstName= new SimpleStringProperty(firstName);
        this.lastName= new SimpleStringProperty(lastName);
        this.country=new SimpleStringProperty(country);
        this.city=new SimpleStringProperty(city);
        this.address=new SimpleStringProperty(address);
        this.apartment=new SimpleStringProperty(apartment);
        this.postalCode=new SimpleStringProperty(postalCode);
        this.item=new SimpleStringProperty(item);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getApartment() {
        return apartment.get();
    }

    public StringProperty apartmentProperty() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment.set(apartment);
    }

    public String getPostalCode() {
        return postalCode.get();
    }

    public StringProperty postalCodeProperty() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }

    public String getItem() {
        return item.get();
    }

    public StringProperty itemProperty() {
        return item;
    }

    public void setItem(String item) {
        this.item.set(item);
    }
}
