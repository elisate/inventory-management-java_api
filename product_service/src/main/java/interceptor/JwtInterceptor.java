package interceptor;

import interceptor.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.logging.Logger;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    private static final Logger logger = Logger.getLogger(JwtInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            logger.warning("Missing or malformed Authorization header");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        final String token = authorizationHeader.substring(7);
        String username = null;

        try {
            logger.info("Token: " + token);
            username = jwtUtil.extractUsername(token);
            logger.info("Extracted Username: " + username);
        } catch (Exception e) {
            logger.warning("Failed to extract username: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        if (username == null || !jwtUtil.validateToken(token, username)) {
            logger.warning("Invalid or expired token");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        logger.info("Token valid for user: " + username);
        request.setAttribute("username", username);
        return true;
    }
}
