package br.com.framework.blog.security;

import br.com.framework.blog.data.UsuarioDetails;
import br.com.framework.blog.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXP = 6000_0000;

    public static final String TOKEN_PASSWORD = "8abb4b5f-fd91-47f9-a35c-35f10c518df3";

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getLogin(),usuario.getPassword(),new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(" Falha ao autenticar", e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UsuarioDetails usuarioDetails = (UsuarioDetails) authResult.getPrincipal();
        String token = JWT.create().withSubject(usuarioDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXP))
                .sign(Algorithm.HMAC512(TOKEN_PASSWORD));

        response.getWriter().write(token);
        response.getWriter().flush();
    }
}

