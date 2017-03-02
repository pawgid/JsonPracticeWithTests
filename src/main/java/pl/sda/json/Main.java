package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        User user1 = new User();
        user1.setFirstName("Jan");
        user1.setLastName("Kowalski");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user1);

        System.out.println(json);
    }
}
