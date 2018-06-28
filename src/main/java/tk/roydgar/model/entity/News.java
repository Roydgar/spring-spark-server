package tk.roydgar.model.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {

    private transient Integer id;
    private String name;
    private String text;
    private String pictureURL;
    private LocalDateTime time;

}
