package tk.roydgar.model.entity;

import lombok.*;
import tk.roydgar.model.entity.workTime.WorkTime;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "password")
@EqualsAndHashCode(exclude = {"id", "registrationDate"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    private Integer id;
    private transient String login;
    private transient String password;
    private String name;
    private String phone;
    private String email;
    private LocalDateTime registrationDate;
    private String address;
    private List<WorkTime> workDays;
}
