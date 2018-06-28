package tk.roydgar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.roydgar.model.entity.Client;
import tk.roydgar.model.entity.workTime.Day;
import tk.roydgar.model.entity.workTime.WorkTime;

import java.time.DayOfWeek;
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

    @Bean(name = "testWorkTime")
    public WorkTime testWorkTime() {
        return WorkTime.builder().from(Day.builder()
                .day(DayOfWeek.MONDAY).hour("9").minute("00").build()).to(
                Day.builder().day(DayOfWeek.FRIDAY).hour("19").minute("01").build()).build();
    }

}
