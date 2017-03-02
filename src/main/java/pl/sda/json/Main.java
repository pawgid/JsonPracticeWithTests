package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        User user1 = new User();
        user1.setFirstName("Jan");
        user1.setLastName("Kowalski");

        Address address1 = new Address();
        address1.setStreet("Baraniaka");
        address1.setCode("11-111");
        address1.setCity("Poznan");

        Address address2 = new Address();
        address2.setStreet("Mokotowska");
        address2.setCode("00-111");
        address2.setCity("Warszawa");

        Map<String, Address> adresses = new HashMap<>();
        adresses.put("Home", address1);
        adresses.put("Work", address2);

        user1.setAddresses(adresses);

        List<String> childrenNames = Arrays.asList("Marek", "Zosia");

        user1.setChildrenNames(childrenNames);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user1);

        System.out.println(json);
    }
}
