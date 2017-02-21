package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public static final class Constants{
            public static final String A_A = "Server is not accessible for now.";
            public static final String B_B = "User is not authorized.";
            public static final String C_C = "User is banned.";
            public static final String D_D = "Access is denied.";

    }
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.A_A);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.A_A, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.B_B);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.B_B, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.C_C);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.C_C, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.D_D);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.D_D, cause);
        }
    }
}
