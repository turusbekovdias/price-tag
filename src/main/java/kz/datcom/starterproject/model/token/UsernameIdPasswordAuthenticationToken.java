package kz.datcom.starterproject.model.token;

import org.bson.types.ObjectId;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UsernameIdPasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    private ObjectId userId;

    public UsernameIdPasswordAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public UsernameIdPasswordAuthenticationToken(Object principal, ObjectId userId, Object credentials) {
        super(principal, credentials);
        this.userId = userId;
    }

    public UsernameIdPasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public UsernameIdPasswordAuthenticationToken(Object principal, ObjectId userId, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.userId = userId;
    }

    public ObjectId getUserId() {
        return this.userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
}
