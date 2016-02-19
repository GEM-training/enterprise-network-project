package gem.androidtraining3.enterprisenetwork.model;

/**
 * Created by huylv on 19/02/2016.
 */
public class UserInfo {
    public String username;
    public String password;
    public String deviceId;

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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public UserInfo(String username, String password, String deviceId) {
        this.username = username;
        this.password = password;
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "{" +
                "\"username\":\"" + username + '\"' +
                ",\"password\":\"" + password + '\"' +
                ",\"deviceId\":\"" + deviceId + '\"' +
                '}';
    }
}
