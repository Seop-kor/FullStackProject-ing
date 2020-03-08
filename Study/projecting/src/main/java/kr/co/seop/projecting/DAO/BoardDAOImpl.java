package kr.co.seop.projecting.DAO;

import kr.co.seop.projecting.VO.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<BoardVO> boardlist() throws Exception {
        return sqlSession.selectList("boardMapper.boardlist");
    }

    @Override
    public void boardDelete(int no) throws Exception {
        sqlSession.delete("boardMapper.boardDelete",no);
    }

    @Override
    public void boardwrite(BoardVO item) throws Exception {
        sqlSession.insert("boardMapper.boardwrite",item);
    }

    @Override
    public void readcount(int no) throws Exception {
        sqlSession.update("boardMapper.readcount",no);
    }
}
