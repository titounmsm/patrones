package ayudadoc.models.auth;

import org.springframework.data.annotation.Transient;

public class Usuario {
    
    @Transient
    protected String username;
    @Transient
    protected String password;

    public Usuario()    {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
       
        return "User: [" + this.username + " - " + this.password + "]";     
    }
}
