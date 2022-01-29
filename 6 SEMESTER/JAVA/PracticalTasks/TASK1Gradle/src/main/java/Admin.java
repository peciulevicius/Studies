import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Admin {
    private StringProperty admin_code;
    private StringProperty password;

    public Admin(){this(null,null);};
    public Admin(String username, String password) {
        this.admin_code = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public String getAdmin_code() {
        return admin_code.get();
    }

    public StringProperty admin_codeProperty() {
        return admin_code;
    }

    public void setAdmin_code(String admin_code) {
        this.admin_code.set(admin_code);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}