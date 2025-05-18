package DTO;

public class LoginResponse {
    private String token;
    private String email;
    private Integer idTrabajador;

    public LoginResponse(String token, String email, Integer idTrabajador) {
        this.token = token;
        this.email = email;
        this.idTrabajador = idTrabajador;

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
}
