package cn.luyinbros.logger;

public class DefaultLoggerProvider implements LoggerProvider {

    @Override
    public Logger getLogger(String name) {
        return new LoggerImpl(name);
    }


    private static class LoggerImpl implements Logger {
        private String name;

        private LoggerImpl(String name) {
            this.name = name;
        }

        @Override
        public boolean isVerboseEnabled() {
            return true;
        }

        @Override
        public void verbose(String msg) {
            System.out.println(name + " verbose: " + msg);
        }

        @Override
        public boolean isDebugEnabled() {
            return true;
        }

        @Override
        public void debug(String msg) {
            System.out.println(name + " debug: " + msg);
        }

        @Override
        public boolean isInfoEnabled() {
            return true;
        }

        @Override
        public void info(String msg) {
            System.out.println(name + " info: " + msg);
        }

        @Override
        public boolean isWarnEnabled() {
            return true;
        }

        @Override
        public void warn(String msg) {
            System.out.println(name + " warn: " + msg);
        }

        @Override
        public boolean isErrorEnabled() {
            return true;
        }

        @Override
        public void error(String msg) {
            System.out.println(name + " error: " + msg);
        }
    }
}
