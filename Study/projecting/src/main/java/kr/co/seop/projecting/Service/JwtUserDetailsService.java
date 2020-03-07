package kr.co.seop.projecting.Service;

import kr.co.seop.projecting.DAO.MemberDAO;
import kr.co.seop.projecting.VO.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    MemberDAO dao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //여기에 이제 DB를 연결해서 id를 받아 쿼리문을 작성후 간다. username과 password를 반환
//        MemberVO vo= dao.select(s);
        if(s.equals("user")){
            return new User("user","$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found with username:"+s);
        }
    }

}
