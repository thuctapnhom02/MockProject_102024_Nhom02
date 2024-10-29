package com.example.demo.model.serviece.bao;

import com.example.demo.api_setting.ApiRespone;
import com.example.demo.model.entity.bao.RoleEntity;
import com.example.demo.model.repo.bao.RoleRepo;
import com.example.demo.model.repo.bao.StaffRepo;
import com.example.demo.model.entity.bao.StaffEntity;
import com.example.demo.model.request.bao.LoginRequest;
import com.example.demo.model.respone.bao.LoginRespone;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginServiece {

    @Autowired
    StaffRepo staffRepo;
    @Autowired
    RoleRepo roleRepo;

    public ApiRespone<LoginRespone> login_create_token(LoginRequest loginRequest) throws ParseException, JOSEException {

        StaffEntity staffEntity = staffRepo.findByPhone(loginRequest.getPhone_());

        ApiRespone<LoginRespone> apiRespone = new ApiRespone<>();
        apiRespone.setApi_respone_("Err request");
        apiRespone.setApi_result_(LoginRespone.builder()
                .check_token_(false)
                .build());

        String err_notication_ = "";
        if(staffEntity == null){
            apiRespone.setApi_desription_("phone not regiter");
        }else{
            if(staffEntity.getPassword_().equals(loginRequest.getPassword_())){
                RoleEntity roleEntity = roleRepo.findById_(staffEntity.getId_role_());
                return create_token(staffEntity,roleEntity);
            }else{
                apiRespone.setApi_desription_("password is wrong");
            }
        }





        return apiRespone;
    }


    @NonFinal
    private final String key_create_token_ = "aHa66Jus+2XX03YJO7MFcs6RnN4eHCsjLmmcIATMmjEi7RctICJiZzI3dzWZrh2q";

    private ApiRespone<LoginRespone> create_token(StaffEntity staffEntity, RoleEntity roleEntity){

        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(staffEntity.getId_())
                .issuer("ten_domain")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(2, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("scope",roleEntity.getName_role_())
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(jwsHeader,payload);

        try {
            jwsObject.sign(new MACSigner(key_create_token_.getBytes()));
            String a = jwsObject.serialize();
            ApiRespone<LoginRespone> apiRespone = new ApiRespone<>();
            apiRespone.setApi_desription_("create ok");
            apiRespone.setApi_respone_("200");
            apiRespone.setApi_result_(LoginRespone.builder()
                    .check_token_(true)
                    .token_(a)
                    .id_user_(staffEntity.getId_())
                    .time_token_(new Date(Instant.now().plus(2, ChronoUnit.HOURS).toEpochMilli()))
                    .name_user_(staffEntity.getName_())
                    .build());
            return apiRespone;
        } catch (JOSEException e) {
            ApiRespone<LoginRespone> apiRespone = new ApiRespone<>();
            apiRespone.setApi_desription_("not create token");
            apiRespone.setApi_respone_("200");
            apiRespone.setApi_result_(LoginRespone.builder()
                    .check_token_(false)
                    .name_user_(staffEntity.getName_())
                    .id_user_(staffEntity.getId_())
                    .build());
            return apiRespone;
        }
    }

    public boolean verify_token(String token) throws JOSEException, ParseException {
        JWSVerifier jwsVerifier = new MACVerifier(key_create_token_.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);
        boolean verify = signedJWT.verify(jwsVerifier);
        boolean check_time = signedJWT.getJWTClaimsSet().getExpirationTime().after(new Date());
        boolean check = (verify == true && check_time == true);
        var a = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(a.getName());
        a.getAuthorities().forEach(e -> System.out.println(e.getAuthority()));
        return check;

    }
}
