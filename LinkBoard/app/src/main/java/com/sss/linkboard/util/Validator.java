package com.sss.linkboard.util;


public final class Validator {
    public static boolean validateEmail(String email){
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
