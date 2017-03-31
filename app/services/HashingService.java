package services;


import play.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by Sivani on 01/03/17.
 */
public class HashingService {


    public HashingService() {
    }

    public String hashPwd(String pwd,String salt){


        Logger.debug(pwd);
        Logger.debug(salt);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            pwd = salt + pwd;

            md.update(pwd.getBytes());
            byte byteData [] = md.digest();
            //to hex
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            Logger.debug("hash: " + sb.toString());
            return sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            Logger.debug(e.getMessage());
            return null;
        }
    }
}
