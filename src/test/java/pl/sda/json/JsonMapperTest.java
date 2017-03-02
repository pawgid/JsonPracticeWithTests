package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class JsonMapperTest {

    @Test
    public void test1() throws IOException {
        String jsonToDeserialize = "{\"firstName\":\"Jan\",\"lastName\":\"Kowalski\",\"addresses\":{\"Work\":{\"street\":\"Mokotowska\",\"code\":\"00-111\",\"city\":\"Warszawa\"},\"Home\":{\"street\":\"Baraniaka\",\"code\":\"11-111\",\"city\":\"Poznan\"}},\"childrenNames\":[\"Marek\",\"Zosia\"]}";

        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(jsonToDeserialize, User.class);

        Assert.assertEquals("Jan", user.getFirstName());
        Assert.assertNotNull(user.getChildrenNames());
        Assert.assertTrue(user.getChildrenNames().size() == 2);
        Assert.assertEquals(Arrays.asList("Marek", "Zosia"), user.getChildrenNames());
    }

    @Test
    public void test2() throws IOException {
        User user = new UserBuilder().withFirstName("Jan").withLastName("Kowalski")
                .withAdress("Work", new AddressBuilder().withCity("Poznan").withCode("60-111").withStreet("Baraniaka").build())
                .withAdress("Home", new AddressBuilder().withCity("Warszawa").withCode("00-111").withStreet("Mokotowska").build())
                .withChildrenNames(Arrays.asList("Marek", "Zosia")).build();


        ObjectMapper mapper = new ObjectMapper();

        String serializedObject = mapper.writeValueAsString(user);

        Assert.assertTrue(serializedObject.contains("\"firstName\":\"Jan\""));
        Assert.assertTrue(serializedObject.contains("Kowalski"));
        Assert.assertTrue(serializedObject.contains("Zosia"));
    }

    @Test
    public void test3() throws IOException {
        User user = new UserBuilder().withFirstName("Jan").withLastName("Kowalski")
                .withAdress("Work", new AddressBuilder().withCity("Poznan").withCode("60-111").withStreet("Baraniaka").build())
                .withAdress("Home", new AddressBuilder().withCity("Warszawa").withCode("00-111").withStreet("Mokotowska").build())
                .withChildrenNames(null).build();


        ObjectMapper mapper = new ObjectMapper();

        String serializedObject = mapper.writeValueAsString(user);

        System.out.println(serializedObject);
    }
}
