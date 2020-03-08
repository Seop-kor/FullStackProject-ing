package kr.co.seop.projecting.Service;

import kr.co.seop.projecting.VO.MemberVO;

public interface MemberService {
    public MemberVO select(String mid) throws Exception;
    public MemberVO idlist(String mid) throws Exception;
    public void signup(MemberVO item) throws Exception;
    public void token(MemberVO item) throws Exception;
}
