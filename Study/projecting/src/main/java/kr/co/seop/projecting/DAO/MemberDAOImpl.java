package kr.co.seop.projecting.DAO;

import kr.co.seop.projecting.VO.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public MemberVO select(String mid) {
        return sqlSession.selectOne("memberMapper.select",mid);
    }

    @Override
    public MemberVO idlist(String mid) throws Exception {
        return sqlSession.selectOne("memberMapper.idlist",mid);
    }

    @Override
    public void signup(MemberVO item) throws Exception {
        sqlSession.insert("memberMapper.signup",item);
    }

    @Override
    public void token(MemberVO item) throws Exception {
        sqlSession.update("memberMapper.token",item);
    }
}
