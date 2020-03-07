package kr.co.seop.projecting.DAO;

import kr.co.seop.projecting.VO.MemberVO;

public interface MemberDAO {
    public MemberVO select(String mid);
    public MemberVO idlist(String mid) throws Exception;
    public void signup(MemberVO item) throws Exception;
    public void token(String token) throws Exception;
}
