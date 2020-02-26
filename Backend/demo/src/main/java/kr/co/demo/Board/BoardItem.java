package kr.co.demo.Board;

import lombok.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
    private String salt;
}
