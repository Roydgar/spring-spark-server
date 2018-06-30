package tk.roydgar.model.entity.workTime;

import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
@ToString
@Builder
public class WorkTime {

    private Integer id;
    private Day from;
    private Day to;

}
