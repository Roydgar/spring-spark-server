package tk.roydgar.model.entity.workTime;

import lombok.*;

import java.time.DayOfWeek;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Day {

    private DayOfWeek day;
    private String hour;
    private String minute;

}
