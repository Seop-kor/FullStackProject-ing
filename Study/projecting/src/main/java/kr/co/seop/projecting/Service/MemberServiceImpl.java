package kr.co.seop.projecting.Service;

import kr.co.seop.projecting.DAO.MemberDAO;
import kr.co.seop.projecting.VO.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDAO dao;

    @Override
    public MemberVO select(String mid) throws Exception {
        return dao.select(mid);
    }

    @Override
    public MemberVO idlist(String mid) throws Exception {
        return dao.idlist(mid);
    }

    @Override
    public void signup(MemberVO item) throws Exception {
        dao.signup(item);
    }

    @Override
    public void token(MemberVO item) throws Exception {
        dao.token(item);
    }
}
