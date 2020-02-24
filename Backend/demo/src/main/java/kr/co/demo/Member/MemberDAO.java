package kr.co.demo.Member;

import kr.co.demo.Board.BoardItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberDAO {
    public MemberItem select(String mid) throws Exception;
    public MemberItem idlist(String mid) throws Exception;
    public void signup(MemberItem item) throws Exception;
}
