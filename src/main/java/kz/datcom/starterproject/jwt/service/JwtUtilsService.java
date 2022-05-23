package kz.datcom.starterproject.jwt.service;

import org.bson.types.ObjectId;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public interface JwtUtilsService {
    boolean validateToken(String authToken);
    String getUsernameFromToken(String token);
    List<SimpleGrantedAuthority> getRolesFromToken(String authToken);
    ObjectId getAccountIdFromToken(String authToken);
}
