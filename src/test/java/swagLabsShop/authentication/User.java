package swagLabsShop.authentication;

public enum User {
    STANDARD_USER("standard_user", "secret_sauce", "a standard user"),
    LOCKER_OUT_USER("locked_out_user", "secret_sauce", "a locked user"),
    PROBLEM_USER("problem_user", "secret_sauce", "a problem user"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", "secret_sauce", "a glitched user"),
    INCORRECT_PASSWORD_USER("standard_user", "incorrect_password", "a incorrect password user"),
    INCORRECT_USERNAME_USER("incorrect_username", "incorrect_username", "a incorrect username user"),
    INCORRECT_USER("incorrect_username", "incorrect_username", "a incorrect user");

    private final String userLogin;
    private final String userPassword;
    private final String userDescription;

    User(String userLogin, String userPassword, String userDescription) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userDescription = userDescription;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return userDescription;
    }
}