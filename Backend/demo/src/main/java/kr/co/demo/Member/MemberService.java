package kr.co.demo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
    @Autowired
    MemberDAO dao;

    public MemberItem select(String mid) throws Exception{
        return dao.select(mid);
    }

    public MemberItem idlist(String mid) throws Exception{
        return dao.idlist(mid);
    }

    public void signup(MemberItem item) throws Exception{
        dao.signup(item);
    }


}
