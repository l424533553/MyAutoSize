/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xuanyuan.myautosize;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;


/**
 * ================================================
 * 发布后新增了副单位，可以在 pt、in、mm 三个冷门单位中选择一个作为副单位，然后在 layout 文件中使用副单位进行布局
 * 副单位可以规避修改 {@link DisplayMetrics#density} 所造成的对于其他使用 dp 布局的系统控件或三方库控件的不良影响
 * 使用副单位后可直接在 AndroidManifest 中填写设计图上的像素尺寸，不需要再将像素转化为 dp。
 *
 * <a href="https://github.com/JessYanCoding/AndroidAutoSize/blob/master/README-zh.md#preview">
 * 点击查看在布局中的实时预览方式</a>
 * <p>
 * 本框架核心原理来自于 <a href="https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA">今日头条官方适配方案</a>
 *
 * <p>
 * 本框架源码的注释都很详细, 欢迎阅读学习
 * AndroidAutoSize 会在 APP 启动时自动完成初始化,
 * 如果您想设置自定义参数可以在 {@link Application#onCreate()} 中设置
 * <p>
 * Created by JessYan on 2018/8/9 17:05
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 *
 * @author LUOFAXIN
 */
public class BaseApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }



}
