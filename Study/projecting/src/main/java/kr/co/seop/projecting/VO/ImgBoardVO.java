package kr.co.seop.projecting.VO;

import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImgBoardVO {
    private int num;
    private String imgaddr;
    private String summary;
    private String content;
    private String title;
}
