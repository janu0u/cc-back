package task.management.project.security;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import task.management.project.exceptions.InvalidLoginResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      AuthenticationException e) throws IOException {

    InvalidLoginResponse loginResponse = new InvalidLoginResponse();
    String jsonLoginResponse = new Gson().toJson(loginResponse);

    httpServletResponse.setContentType("application/json");
    httpServletResponse.setStatus(401);

    httpServletResponse.getWriter().print(jsonLoginResponse);

  }

}
