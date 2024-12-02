package config;

import com.zs.utils.ExcelUtils;
import org.testng.annotations.Optional;

public class readCredentials {
    String userName= null;
    String password= null;
    public void setCredientials(@Optional String appName){
        String[] credentials = ExcelUtils.getCredentialsForApp(appName);
        assert credentials != null;
        userName = credentials[0];
        password = credentials[1];
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
}
