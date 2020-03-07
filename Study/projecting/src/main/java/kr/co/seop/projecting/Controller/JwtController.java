package kr.co.seop.projecting.Controller;

import kr.co.seop.projecting.Config.JwtTokenUtil;
import kr.co.seop.projecting.Response.JwtResponse;
import kr.co.seop.projecting.Service.JwtUserDetailsService;
import kr.co.seop.projecting.Service.MemberService;
import kr.co.seop.projecting.VO.JwtTokenVO;
import kr.co.seop.projecting.VO.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private MemberService service;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenVO req) throws Exception{
        authenticate(req.getUsername(), req.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
//        service.token(token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("user_Disabled", e);
        }catch (BadCredentialsException e){
            throw new Exception("invalid_credentials",e);
        }
    }
}
