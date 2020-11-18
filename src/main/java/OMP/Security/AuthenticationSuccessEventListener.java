package OMP.Security;

import OMP.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {
    @Autowired
    private LoginService loginService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        loginService.loginFailed(event.getAuthentication().getName());
    }
}
