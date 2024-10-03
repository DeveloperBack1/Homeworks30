package homework0210;
// Исключение для неверного логина
class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);
    }
}

// Класс исключения для неправильного пароля
class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }
}

public class MainRegistration {

    public static void main(String[] args) {
        try {
            // Пример вызова метода с корректными данными
            validateCredentials("John_Doe123", "pass1234", "pass1234");
            System.out.println("Валидация прошла успешно!");

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void validateCredentials(String login, String password, String confirmPassword)
        throws WrongLoginException, WrongPasswordException {

        // Проверка логина
        if (login.length() >= 20) {
            throw new WrongLoginException("Логин должен быть меньше 20 символов.");
        }
        if (!Character.isLetter(login.charAt(0))) {
            throw new WrongLoginException("Логин должен начинаться с латинской буквы.");
        }
        for (int i = 0; i < login.length(); i++) {
            char c = login.charAt(i);
            if (!(Character.isLetterOrDigit(c) || c == '_')) {
                throw new WrongLoginException("Логин должен содержать только латинские буквы," +
                    " цифры и знак подчеркивания.");
            }
        }

        // Проверка пароля
        if (password.length() >= 20) {
            throw new WrongPasswordException("Пароль должен быть меньше 20 символов.");
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                throw new WrongPasswordException("Пароль должен содержать только латинские буквы и цифры.");
            }
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают.");
        }
    }
}
