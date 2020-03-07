package kr.co.seop.projecting.VO;

import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {
    private int code;
    private String mid = null;
    private String mpass = null;
    private String mpass_check;
    private String mname;
    private String salt;
    private int count;
    private String token;
}
