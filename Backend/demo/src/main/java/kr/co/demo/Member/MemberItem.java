package kr.co.demo.Member;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberItem {
    private int code;
    private String mid = null;
    private String mpass = null;
    private String mpass_check;
    private String mname;
    private String salt;
    int count;
}
