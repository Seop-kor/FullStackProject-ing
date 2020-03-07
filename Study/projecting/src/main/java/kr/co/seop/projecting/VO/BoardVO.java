package kr.co.seop.projecting.VO;

import lombok.*;

import java.sql.Date;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
    private int no;
    private String title;
    private String content;
    private String name;
    private String pass;
    private Date writedate;
    private int readcount;
    private String salt;
}
