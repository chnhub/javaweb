package vo;

import lombok.Data;

@Data
public class LoginVo {
    public String username;
    public String password;
    public String verification;
    public boolean isRemeberPWD;
}
