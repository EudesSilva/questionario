 package br.com.questionario.configuration;

import br.com.questionario.util.MyLogger;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

 

public class CustomAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    
     
    private final MyLogger LOG = MyLogger.configLog(CustomAuthSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        
        
            HttpSession session = request.getSession(); 
            if ("true".equals(request.getHeader("X-Login-Ajax-call"))) {
                LOG.myLog("::::Login-Ajax:::::"); 
            }
            
            if (session != null) {
                 String redirectUrl = "/views/restrict/home.html#/home"; 
                 getRedirectStrategy().sendRedirect(request, response, redirectUrl);  
                 LOG.myLog(":::session Redirect:::::"); 
            } else {
                 super.onAuthenticationSuccess(request, response, authentication); 
                 LOG.myLog(":::onAuthenticationSuccess:::::"); 
            }
 
    }
}