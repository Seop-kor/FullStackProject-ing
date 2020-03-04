package kr.oauthpopol.project.Controller;

import kr.oauthpopol.project.Common.JwtRequest;
import kr.oauthpopol.project.Common.JwtResponse;
import kr.oauthpopol.project.Config.JwtTokenUtil;
import kr.oauthpopol.project.Service.JwtUserDetailsService;
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
public class JwtContoller {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest req) throws Exception{
        authenticate(req.getUsername(), req.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
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
