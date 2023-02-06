import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.test.Application;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
public class TestApp {
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;;

    @org.junit.Test
    public void test() throws Exception {
       this.restTemplate.getForObject("http://localhost:" + port + "/jdbc-test", String.class);
       assertThatExceptionOfType(StackOverflowError.class);
    }

}
