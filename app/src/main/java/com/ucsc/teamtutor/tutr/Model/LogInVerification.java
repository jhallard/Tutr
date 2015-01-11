package com.ucsc.teamtutor.tutr.Model;

/**
 * Created by Andrew H. Pometta on 1/10/15.
 * This class is designed to ensure login information is correct, then logs them in.
 */
public class LogInVerification {

    /**
     * The only method the LogIn java class should really call to access the DB to ensure login
     * success.  Returned ints correspond to result.
     * 0: success
     * 1: invalid e-mail format
     * 2: e-mail not found
     * 3: password incorrect
     * @param email
     * @param password
     * @return
     */
    public static int checkSignIn(String email, String password){
        if (!validEmail(email)) return 1;
        return passInEmailInfo(email, password);
    }

    /**
     * The e-mail verify function checks if the e-mail is valid.   False returned if email no, true
     * returned if it is.  After this stage the email goes through existence check in the database.
     */
    public static boolean validEmail(String email){
        //If it doesn't contain at least
        if (!email.contains(".") || !email.contains("@")) return false;
        int at_loc = email.indexOf("@");
        //If at symbol is last character or there's another one, that means there's an error.
        if (at_loc == email.length() - 1 || email.indexOf("@", at_loc + 1) != -1) return false;
        int dot_loc = email.indexOf(".");
        while (dot_loc != -1){
            //If @ is next to ., return false.
            if (dot_loc == at_loc + 1 || dot_loc == at_loc - 1) return false;
            //Move to next dot.
            dot_loc = email.indexOf(".", dot_loc + 1);
        }
        return true;
    }

    private static int passInEmailInfo(String email, String password){
        int res = FrontEndNode.verifyUserInfo(email, password);
        if (res == 1) return 3;
        else if (res == 2) return 2;
        else if (res == 0) return 0;
        //res should never be anything else
        return 1;
    }
}
