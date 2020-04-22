package cn.luyinbros.logger;

public class LoggerFactory {
    private static volatile LoggerProvider PROVIDER;

    private LoggerFactory() {
    }


    public static void initialize(LoggerProvider loggerProvider) {
        if (PROVIDER == null) {
            PROVIDER = loggerProvider;
        }
    }


    private static LoggerProvider getProvider() {
        if (PROVIDER == null) {
            PROVIDER = new DefaultLoggerProvider();
        }
        return PROVIDER;
    }

    public static Logger getLogger(String name) {
        return getProvider().getLogger(name);
    }

    public static Logger getLogger(Class<?> cls) {
        return getProvider().getLogger(cls.getName());
    }


}
