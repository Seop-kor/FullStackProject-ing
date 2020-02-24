package kr.co.demo.ToDoItem;

import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoItem {
    private int num;
    private String imgaddr;
    private String summary;
    private String content;
    private String title;
}
