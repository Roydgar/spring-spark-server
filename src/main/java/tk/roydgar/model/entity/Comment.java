package tk.roydgar.model.entity;

import lombok.*;

@Data
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    private Integer id;
    private String text;
    private Integer mark;
    private Integer usefulness;

}
