package pl.sdacademy;

public class LoginValidator {
    /**
     * This method validates is username and password arr correct.
     * If userName aor password are empty then return false.
     * If userName or password lenght is snamller than 6 then return false.
     * Is userName is Javaktw9 and password is SDA2019 then return true.
     * Username and password are case sensitive.
     *
     * @param userName
     * @param password
     * @return
     */

    private static String USERNAME = "Javaktw9";
    private static String PASSWORD = "SDA2019";

    public boolean isValid(String userName, String password) {

        if (!USERNAME.equals(userName) || !PASSWORD.equals(password)) {
            return false;
        } else if (userName.length() < 6 || password.length() < 6) {
            return false;
        } else if (userName.isEmpty() || password.isEmpty()){
            return false;
        }
        return true;
    }
}
