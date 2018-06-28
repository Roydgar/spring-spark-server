package tk.roydgar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.roydgar.model.entity.Client;

import java.time.LocalDateTime;

@Configuration
public class TestConfig {

    @Bean(name = "testClient")
    public Client testClient() {
        return Client.builder()
                .name("sto").password("0000")
                .login("client").phone("88005555535")
                .registrationDate(LocalDateTime.now())
                .email("royd@mail.ru")
                .address("SDFSDF").build();
    }

}
