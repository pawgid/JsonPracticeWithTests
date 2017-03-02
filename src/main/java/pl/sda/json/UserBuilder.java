package pl.sda.json;

import java.util.List;
import java.util.Map;

public class UserBuilder {
    private User user = new User();

    public UserBuilder withFirstName(String firstName) {
        user.setFirstName(firstName);
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        user.setLastName(lastName);
        return this;
    }

    public UserBuilder withAddress(Map<String, Address> adressess) {
        user.setAddresses(adressess);
        return this;
    }

    public UserBuilder withAdress(String adressName, Address adress) {
        user.getAddresses().put(adressName, adress);
        return this;
    }

    public UserBuilder withChildrenNames(List<String> names) {
        user.setChildrenNames(names);
        return this;
    }

    public User build() {
        return user;
    }
}
