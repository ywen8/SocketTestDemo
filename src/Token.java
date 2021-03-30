public class Token {

    private String secret_key;
    private Long expires_in;

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "Token{" +
                "secret_key='" + secret_key + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
