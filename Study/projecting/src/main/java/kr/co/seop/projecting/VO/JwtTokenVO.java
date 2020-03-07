package kr.co.seop.projecting.VO;

import lombok.*;

@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtTokenVO {
    private String username;
    private String password;
}
