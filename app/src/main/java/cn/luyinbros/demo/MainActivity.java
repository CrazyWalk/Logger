package cn.luyinbros.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.luyinbros.logger.Logger;
import cn.luyinbros.logger.LoggerFactory;


public class MainActivity extends AppCompatActivity {
    private Logger logger = LoggerFactory.getLogger(MainActivity.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logger.debug("logger");
    }
}
