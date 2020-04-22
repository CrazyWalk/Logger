package cn.luyinbros.demo;


import cn.luyinbros.logger.AndroidLoggerProvider;
import cn.luyinbros.logger.LoggerFactory;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LoggerFactory.initialize(new AndroidLoggerProvider.Builder()
                .setGlobalTag("demo")
                .setLevel(AndroidLoggerProvider.Level.DEBUG)
                .build());
    }
}
