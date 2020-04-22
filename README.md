# Logger
类门面模式规范日志调用。

# 最新版本
1.0

# 安装
根目录的build.gradle
```
allprojects {
    repositories {
        ......        
        maven { url 'https://jitpack.io' }
    }
}

```

基本的库
```
 implementation 'com.github.CrazyWalk.Logger:logger:{latestVersion}'
```

包含AndroidLoggerProvider
```
 implementation 'com.github.CrazyWalk.Logger:{latestVersion}'
```

# 使用
init
```
LoggerFactory.initialize(your loggerProvider)
```

or use android log
```
  LoggerFactory.initialize(new AndroidLoggerProvider.Builder()
                .setGlobalTag("demo")
                .setLevel(AndroidLoggerProvider.Level.DEBUG)
                .build());
```

call
```
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

```

# THANKS
orhanobut 提供的Logger思路 [source code](https://github.com/orhanobut/logger)


# LICENSE
<pre>
License : BSD http://en.wikipedia.org/wiki/BSD_license
Copyright (c) 2020  Andy Hong
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

1.Redistributions of source code must retain the above copyright notice,
this list of conditions and the following disclaimer.
2.Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
</pre>


<pre>
Copyright 2018 Orhan Obut

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

usage: AndroidLoggerProvider
</pre>