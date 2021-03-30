public class AcToken {

    private Long random;
    private String ip;

    private Long expires_in;

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public Long getRandom() {
        return random;
    }

    public void setRandom(Long random) {
        this.random = random;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "AcToken{" +
                "random=" + random +
                ", ip='" + ip + '\'' +
                '}';
    }
}
