package OMP.Entity.security;

public class JwtResponse {

    private String username;
    private String role;
    private String jwtToken;

    public JwtResponse(String username, String role, String jwtToken) {
        this.username = username;
        this.role = role;
        this.jwtToken = jwtToken;
    }

    public JwtResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJwtToken() {
        return jwtToken;
    }
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
