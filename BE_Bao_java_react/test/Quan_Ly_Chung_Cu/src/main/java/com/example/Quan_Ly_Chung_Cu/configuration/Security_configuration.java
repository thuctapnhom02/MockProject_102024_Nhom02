package com.example.Quan_Ly_Chung_Cu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class Security_configuration {

    //cac duong dan cua nhung trang khong can quyen
    private final String[] link_not_securiry = {"/login/test_1","/login/test_2","/home"};
    private final String[] link_admin_security = {"get_nguoi_dung","create_nguoi_dung"};

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*
        * cai dat bao mat cho trang web bang thu vien oauth2
        * set xem trang nao co the truy cap va trang nao khong dc truy cap
        * set xem co quyen truy cap vao trang web nay khong bang token
        * */

        //set trang web nao khong can va can quyen de truy cap vao
        http.authorizeHttpRequests(rq_  -> rq_
                .requestMatchers(HttpMethod.GET,link_not_securiry).permitAll()
                .requestMatchers(HttpMethod.POST,link_not_securiry).permitAll()
//                .requestMatchers(HttpMethod.GET,link_admin_security).hasAuthority("role_admin")
//                .requestMatchers(HttpMethod.POST,link_admin_security).hasAuthority("role_admin")

                .anyRequest().authenticated());

        // nhan token va decode lai token khi co request gui len server va co token
        http.oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwtConfigurer -> jwtConfigurer.decoder(jwt_decoder())));

        http.csrf(AbstractHttpConfigurer::disable);

        http.cors(Customizer.withDefaults()); //or however else you would like to configure CORS

        return http.build();
    }
    @Value("${jwt.create_token_key}")
    private String sereckey;


    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter(){
        JwtGrantedAuthoritiesConverter jwt_ = new JwtGrantedAuthoritiesConverter();
        jwt_.setAuthorityPrefix("ROLE_"); //name deflault la SCOPE sau do noi voi tu role trong user
//        jwt_.setAuthoritiesClaimName("role");//ten default la scope co the cusstom sang chu khac
        //jwt_.setAuthoritiesClaimDelimiter("_");//ki tu ngan cach giua chu SCOPE va role
        JwtAuthenticationConverter jwt__ = new JwtAuthenticationConverter();
        jwt__.setJwtGrantedAuthoritiesConverter(jwt_);
        return jwt__;
    }



    @Bean
    JwtDecoder jwt_decoder(){

        SecretKeySpec spec = new SecretKeySpec(sereckey.getBytes(),"HS512");

        return NimbusJwtDecoder
                .withSecretKey(spec)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
    }





    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:5173");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);

        return new CorsFilter(urlBasedCorsConfigurationSource);

    }

}