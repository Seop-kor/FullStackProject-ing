package kr.co.seop.projecting.DAO;

import kr.co.seop.projecting.VO.ImgBoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImgBoardDAOImpl implements ImgBoardDAO {
    @Autowired
    SqlSession sqlSession;

    public ImgBoardDAOImpl(){

    }

    @Override
    public List<ImgBoardVO> select() throws Exception {
        return sqlSession.selectList("ImgBoardMapper.select");
    }

    @Override
    public List<ImgBoardVO> selectDetail(int num) throws Exception {
        return sqlSession.selectOne("ImgBoardMapper.selectDetail",num);
    }
}
