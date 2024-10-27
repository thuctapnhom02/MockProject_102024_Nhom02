package com.example.Quan_Ly_Chung_Cu.seviece;


import com.example.Quan_Ly_Chung_Cu.Api.Api_repo;
import com.example.Quan_Ly_Chung_Cu.exeption.Errcode;
import com.example.Quan_Ly_Chung_Cu.exeption.Exeption_custom;
import com.example.Quan_Ly_Chung_Cu.request.Token_request;
import com.example.Quan_Ly_Chung_Cu.model.entity.Nguoi_dung_entity;
import com.example.Quan_Ly_Chung_Cu.respone.Token_respone;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.NonFinal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Data
@Builder
@Service
public class Login_seviece {

    public Api_repo<Token_respone> login(Nguoi_dung_entity nd){

            String token_ = create_token(nd);
            boolean check_=true;
            if(token_ == ""){
                throw new Exeption_custom(Errcode.Not_Create_token_);
            }

            Api_repo<Token_respone> check_api = Api_repo.<Token_respone>builder()
                    .ping_(100004)
                    .data(Token_respone.builder()
                            .value_(check_)
                            .token_(token_)
                            .build())
                    .build();

            return check_api;
    }

    @NonFinal
    private final String key_create_token_ = "aHa66Jus+2XX03YJO7MFcs6RnN4eHCsjLmmcIATMmjEi7RctICJiZzI3dzWZrh2q";

    private String create_token(Nguoi_dung_entity nd){
        /*  create token
        *   JWSHeader - tao heder la ten cua thuat toan
        *   subject - noi dung can dc tao token - ten user
        *   issuer - ten domain
        *   issueTime tg token dc tao
        *   .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli())) tg ket thuc token - 1 tieng
        *   claim them thong tin gi do
        *   payload deo biet.
        *   sign dang ki token.
        * */


        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(nd.getName_())
                .issuer("ten_domain")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(2, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("scope","admin")
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(jwsHeader,payload);

        try {
            jwsObject.sign(new MACSigner(key_create_token_.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            return "khong tao dc token";
        }
    }

    public Api_repo<Token_respone> verify_token(Token_request tq) throws JOSEException, ParseException {
        /*
        * check xem token co ton tai hay khong neu co thi con thoi gian hay khong
        * */
        var token = tq.getToken();

        JWSVerifier jwsVerifier = new MACVerifier(key_create_token_.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        boolean verify = signedJWT.verify(jwsVerifier);
        boolean check_time = signedJWT.getJWTClaimsSet().getExpirationTime().after(new Date());

        boolean check = (verify == true && check_time == true);
        System.out.println(verify);
        System.out.println(check_time);

        Api_repo<Token_respone> api =  Api_repo.<Token_respone>builder()
                .ping_(100005)
                .data(Token_respone.builder()
                        .value_(check)
                        .token_("thoi gian ket thuc cua token "+signedJWT.getJWTClaimsSet().getExpirationTime())
                        .build())
                .build();

        var a = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(a.getName());
        a.getAuthorities().forEach(e -> System.out.println(e.getAuthority()));


        return api;

    }

}
