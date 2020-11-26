package OMP.Controller;

import OMP.Entity.Login;
import OMP.Entity.security.JwtRequest;
import OMP.Entity.security.JwtResponse;
import OMP.Security.JwtTokenUtil;
import OMP.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private LoginService loginService;
    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        final UserDetails userDetails = loginService
                .loadUserByUsername(authenticationRequest.getUsername());
        if (!userDetails.isAccountNonLocked()) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("User account is locked");
        }
        String token = jwtTokenUtil.generateToken(userDetails);
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        Login user = loginService.logInByUsername(userDetails.getUsername());
        System.out.println("Logged User " + user.getUsername() + " token " + token);
        return ResponseEntity.ok(new JwtResponse(user.getUsername(), user.getRole(), token));
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
