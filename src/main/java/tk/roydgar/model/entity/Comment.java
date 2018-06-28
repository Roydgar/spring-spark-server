package tk.roydgar.model.entity;

import lombok.*;

@Data
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    private transient Integer id;
    private String name;
    private String text;
    private Integer mark;
}
