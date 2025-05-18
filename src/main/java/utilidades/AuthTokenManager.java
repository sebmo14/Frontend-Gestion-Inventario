package utilidades;

public class AuthTokenManager {
    private static String token;

    public static void setToken(String t) {
        token = t;
    }

    public static String getToken() {
        return token;
    }

    public static void clearToken() {
        token = null;
    }

    public static boolean isLoggedIn() {
        return token != null;
    }
}