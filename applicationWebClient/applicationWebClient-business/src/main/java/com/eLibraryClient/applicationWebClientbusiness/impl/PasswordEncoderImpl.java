package com.eLibraryClient.applicationWebClientbusiness.impl;

import com.eLibraryClient.applicationWebClientbusiness.contract.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {

    /**
     * For hash password
     *
     * @param password_plaintext -> clear text
     * @return -> hashed password
     */
    @Override
    public String hashPassword(String password_plaintext) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password_plaintext);

        return hashedPassword;
    }


    /**
     * For check password
     * @param pPasswordPlainText -> pass plain text
     * @param pHashingPassword -> hashingPass
     * @return
     */
    @Override
    public boolean checkPassword(String pPasswordPlainText, String pHashingPassword) {

        boolean pass = false;

        pass = BCrypt.checkpw(pPasswordPlainText,pHashingPassword);

        return pass;
    }
}