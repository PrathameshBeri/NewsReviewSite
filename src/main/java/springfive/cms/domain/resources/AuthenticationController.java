package springfive.cms.domain.resources;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import springfive.cms.domain.services.services.MyUserDetailsService;
import springfive.cms.domain.utilities.JwtUtil;
import springfive.cms.vo.AuthenticationRequest;
import springfive.cms.vo.AuthenticationResponse;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    private static final Logger logger = LogManager.getLogger(AuthenticationController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest auth) throws Exception{
    try{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserName(),
                        auth.getPassWord()));
    }catch(BadCredentialsException e){
        logger.error("Bad credentials");
    }


    final UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getUserName());

    final String jwt = jwtUtil.generateToken(userDetails);


        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
