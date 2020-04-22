package cn.luyinbros.logger;

public interface Logger {
    boolean isVerboseEnabled();

    void verbose(String msg);

    boolean isDebugEnabled();

    void debug(String msg);

    boolean isInfoEnabled();

    void info(String msg);

    boolean isWarnEnabled();

    void warn(String msg);

    boolean isErrorEnabled();

    void error(String msg);

}
