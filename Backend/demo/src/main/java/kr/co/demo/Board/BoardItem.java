package kr.co.demo.Board;

import lombok.*;

import java.sql.Date;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardItem {
    private int no;
    private String title;
    private String content;
    private String name;
    private String pass;
    private Date writedate;
    private int readcount;
}
