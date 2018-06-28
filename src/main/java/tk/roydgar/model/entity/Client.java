package tk.roydgar.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(exclude = "password")
@EqualsAndHashCode(exclude = {"id", "registrationDate"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    private transient Integer id;
    private String login;
    private transient String password;
    private String name;
    private String phone;
    private String email;
    private LocalDateTime registrationDate;
    private String address;

}
