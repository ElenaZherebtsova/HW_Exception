public class Main {
    public static void main(String[] args) {
        try {
            UserValidator.checkUser("User_Login123",
                    "pass+word",
                    "password");
            System.out.println("Авторизация пройдена успешно!");


        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        }

    }

}