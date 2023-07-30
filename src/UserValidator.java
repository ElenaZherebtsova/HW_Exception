import java.util.SortedMap;
import java.util.regex.Pattern;

public class UserValidator {

    private static Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");

    public static void checkUser(String login,
                                 String password,
                                 String confirmPassword)
            throws WrongPasswordException, WrongLoginException {
        checkLogin(login);
        checkPassword(password);
        checkConfirmPassword(password, confirmPassword);
    }


    private static void checkLogin(String login) {
        if (!login.matches(regex.pattern())) {
            throw new WrongLoginException("Логин должен содержать " +
                    "только латинские буквы, цифры и знак _. " +
                    "И быть не более 20 символов.");
        }
    }

    private static void checkPassword(String password)
            throws WrongPasswordException {

        if (!password.matches(regex.pattern())) {
            throw new WrongPasswordException("Пароль должен содержать " +
                    "только латинские буквы, цифры и знак _. " +
                    "И быть не более 20 символов.");
        }
    }

    private static void checkConfirmPassword(String password,
                                             String confirmPassword)
            throws WrongPasswordException{
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }

}
