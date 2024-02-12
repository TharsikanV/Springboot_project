//package bookstoreservices.util;
//
//import bookstoreservices.entity.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//
//@Component
//public class JwtUtils {
//
//    private static  String secret="This_is_secret";
//    public String generateJwt(User user){
//        Date issuedAt=new Date();
//        //claims
//        Claims claims= (Claims) Jwts.claims()
//                .setIssuer(user.getId().toString())
//                .setIssuedAt(issuedAt);
//
//        //generate jwt using claims
//        return Jwts.builder().setClaims(claims).compact();//compact String ah convert pannidum
//
//
//    }
//
//}
package bookstoreservices.util;

import bookstoreservices.common.Access_DeniedException;
import bookstoreservices.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;


@Component
public class JwtUtils {

    private static String secret="ThisIsSecretxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" +
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    private static long expiryDuration= 60 * 60;
    public String generateJwt(User user){

        long milliTime=System.currentTimeMillis();
        long expiryTime=milliTime+expiryDuration*1000;

        Date issuedAt=new Date(milliTime);
        Date expiryAt =new Date(expiryTime);
        //claims
        ClaimsBuilder claims=Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        //optional claims
        claims.add("type",user.getUserType());
        claims.add("name",user.getName());
        claims.add("emailId",user.getEmailId());

        //generate jwt using claims
        return Jwts.builder()
                .setClaims(claims.build())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();//compact String ah convert pannidum


    }

//    public Claims verify(String authorization) throws Exception {
//
//        try {
//            Claims claims=Jwts.parser()
//                    .setSigningKey(secret)
//                    .build()
//                    .parseSignedClaims(authorization).getBody();
//
//            System.out.println(claims.get("name"));
//            return claims;
//        }catch (Exception e){
//            throw new AccessDeniedException("Access Denied");
//        }
//
//    }
    public Claims verify(String authorization) throws Exception {
        try {
            Claims claims=Jwts.parser().setSigningKey(secret).build().parseClaimsJws(authorization).getBody();
            //jwt valida iruntha intha line ah pass panni poidum illanna exception throw pannum

//            System.out.println(claims.get("name"));
            return claims;
        }
        catch(Exception e){
            throw new Access_DeniedException("Access Denied");
        }

    }


}
