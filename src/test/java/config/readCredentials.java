package config;

import com.zs.utils.ExcelUtils;
import org.testng.annotations.Optional;

/**
 * The class is responsible for reading and storing the username and password for a specific application
 * This class provides methods to retrieve the stored username and password.
 */

public class readCredentials {
    String userName= null;
    String password= null;

    /**
     * Sets the credentials (username and password) for a specific application.
     * @param appName The name of the application for which credentials are to be fetched is passed as the parameter
     */

    public void setCredentials(String appName){
        String[] credentials = ExcelUtils.getCredentialsForApp(appName);
        assert credentials != null;
        userName = credentials[0];
        password = credentials[1];
    }

    /**
     * Function used to get the username that was retrieved for the application.
     * @return The username associated with the application.
     */

    public String getUserName(){
        return userName;
    }

    /**
     * Function used to get the password that was retrieved for the application.
     * @return The password associated with the application.
     */

    public String getPassword(){
        return password;
    }
}
