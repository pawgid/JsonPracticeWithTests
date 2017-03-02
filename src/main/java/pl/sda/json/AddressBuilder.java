package pl.sda.json;

public class AddressBuilder {
    private Address address = new Address();

    public AddressBuilder withStreet(String street) {
        address.setStreet(street);
        return this;
    }

    public AddressBuilder withCode(String code) {
        address.setCode(code);
        return this;
    }

    public AddressBuilder withCity(String city) {
        address.setCity(city);
        return this;
    }

    public Address build() {
        return address;
    }
}
