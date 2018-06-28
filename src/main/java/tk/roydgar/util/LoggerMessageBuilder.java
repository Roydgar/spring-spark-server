package tk.roydgar.util;



public class LoggerMessageBuilder {

    private LoggerMessageBuilder() {}

    public static String loginFailed(String login, String password, String ip) {
        return "Failed login attempt: (" + login + ", " + password + "); ip: " + ip;
    }

    public static String loginSuccess(String login, String password, String ip) {
        return "Success login (" + login + ",  " + password + "); ip: " + ip;
    }

}
