package cn.luyinbros.logger;

import android.util.Log;


public class AndroidLoggerProvider implements LoggerProvider {
    private final Level level;
    private final String tag;
    private static Logger NONE_LOGGER = new NoneLogger();

    private AndroidLoggerProvider(Builder builder) {
        this.level = builder.level;
        this.tag = builder.tag;
    }

    @Override
    public Logger getLogger(String name) {
        if (level == Level.NONE) {
            return NONE_LOGGER;
        }
        return new LoggerImpl(this, name);
    }

    public  enum Level {
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR,
        NONE
    }

    public static class Builder {
        private String tag = "default";
        private Level level = Level.VERBOSE;

        public Builder setLevel(Level level) {
            this.level = level;
            return this;
        }

        public Builder setGlobalTag(String tag) {
            this.tag = tag;
            return this;
        }

        public AndroidLoggerProvider build() {
            return new AndroidLoggerProvider(this);
        }

    }

    private static class NoneLogger implements Logger {

        @Override
        public boolean isVerboseEnabled() {
            return false;
        }

        @Override
        public void verbose(String msg) {

        }

        @Override
        public boolean isDebugEnabled() {
            return false;
        }

        @Override
        public void debug(String msg) {

        }

        @Override
        public boolean isInfoEnabled() {
            return false;
        }

        @Override
        public void info(String msg) {

        }

        @Override
        public boolean isWarnEnabled() {
            return false;
        }

        @Override
        public void warn(String msg) {

        }

        @Override
        public boolean isErrorEnabled() {
            return false;
        }

        @Override
        public void error(String msg) {

        }
    }

    //android log tag 最多23个字符
    private static class LoggerImpl implements Logger {
        private static String methodName = LoggerImpl.class.getName() + ".printInfo";

        private final Level mLevel;
        private final String name;
        private final String tag;

        private static final char TOP_LEFT_CORNER = '┌';
        private static final char BOTTOM_LEFT_CORNER = '└';
        private static final char MIDDLE_CORNER = '├';
        private static final char HORIZONTAL_LINE = '│';
        private static final String DOUBLE_DIVIDER = "────────────────────────────────────────────────────────";
        private static final String SINGLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
        private static final String TOP_BORDER = TOP_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER;
        private static final String BOTTOM_BORDER = BOTTOM_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER;
        private static final String MIDDLE_BORDER = MIDDLE_CORNER + SINGLE_DIVIDER + SINGLE_DIVIDER;

        private LoggerImpl(AndroidLoggerProvider provider, String name) {
            this.mLevel = provider.level;
            this.tag = provider.tag;
            this.name = name;
        }

        @Override
        public boolean isVerboseEnabled() {
            return mLevel.compareTo(Level.VERBOSE) <= 0;
        }

        @Override
        public void verbose(String msg) {
            if (isVerboseEnabled()) {
                Log.v(tag, printInfo(msg));
            }

        }

        @Override
        public boolean isDebugEnabled() {
            return mLevel.compareTo(Level.DEBUG) <= 0;
        }

        @Override
        public void debug(String msg) {
            if (isDebugEnabled()) {
                Log.d(tag, printInfo(msg));
            }
        }

        @Override
        public boolean isInfoEnabled() {
            return mLevel.compareTo(Level.INFO) <= 0;
        }

        @Override
        public void info(String msg) {
            if (isInfoEnabled()) {
                Log.i(tag, printInfo(msg));
            }
        }

        @Override
        public boolean isWarnEnabled() {
            return mLevel.compareTo(Level.WARN) <= 0;
        }

        @Override
        public void warn(String msg) {
            if (isWarnEnabled()) {
                Log.w(tag, printInfo(msg));
            }
        }

        @Override
        public boolean isErrorEnabled() {
            return mLevel.compareTo(Level.ERROR) <= 0;
        }

        @Override
        public void error(String msg) {
            if (isErrorEnabled()) {
                Log.e(tag, printInfo(msg));
            }
        }

        private String printInfo(String msg) {
            Thread thread = Thread.currentThread();
            final StringBuilder sb = new StringBuilder();
            sb.append("Log: ").append(name).append("\n");
            sb.append(TOP_BORDER).append("\n");
            sb.append(HORIZONTAL_LINE).append("thread: ").append(thread.getName()).append("\n");
            sb.append(MIDDLE_BORDER).append("\n");
            StackTraceElement[] trace = thread.getStackTrace();


            final int traceLength = trace.length;
            String currentTargetName;
            int findStackIndex = -1;
            for (int index = 0; index < traceLength; index++) {
                StackTraceElement element = trace[index];
                currentTargetName = element.getClassName() + "." + element.getMethodName();
                if (methodName.equals(currentTargetName)) {
                    findStackIndex = index;
                    break;
                }
            }

            if (findStackIndex != -1) {
                if (findStackIndex + 2 < traceLength) {
                    sb.append(HORIZONTAL_LINE).append(trace[findStackIndex + 2]).append("\n");
                }
                if (findStackIndex + 3 < traceLength) {
                    sb.append(HORIZONTAL_LINE).append(trace[findStackIndex + 3]).append("\n");
                }
            }

            sb.append(MIDDLE_BORDER).append("\n");
            if (msg == null || msg.isEmpty()) {
                sb.append(HORIZONTAL_LINE).append("Empty msg").append("\n");
            } else {
                sb.append(HORIZONTAL_LINE).append(msg).append("\n");
            }
            sb.append(BOTTOM_BORDER);
            return sb.toString();
        }

    }
}
