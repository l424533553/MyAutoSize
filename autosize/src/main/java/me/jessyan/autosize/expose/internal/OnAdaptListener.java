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
package me.jessyan.autosize.expose.internal;

import android.app.Activity;

/**
 * ================================================
 * 屏幕适配监听器，用于监听屏幕适配时的一些事件
 * ================================================
 * @author LUOFAXIN
 * 由我再次注释说明
 */
public interface OnAdaptListener {

    /**
     * 在屏幕适配前调用
     *
     * ======================================
     * 使用以下代码, 可以解决横竖屏切换时的屏幕适配问题,需要在{@link OnAdaptListener #onAdaptBefore}
     * 可支持 Android 的分屏或缩放模式, 但前提是在分屏或缩放模式下当用户改变您 App 的窗口大小时，系统会重绘当前的页面,
     * 经测试在某些机型, 某些情况下系统不会重绘当前页面, ScreenUtils.getScreenSize(activity) 的参数一定要不要传 Application!!!
     * AutoSizeConfig.getInstance().setScreenWidth(ScreenUtils.getScreenSize(activity)[0]);
     * AutoSizeConfig.getInstance().setScreenHeight(ScreenUtils.getScreenSize(activity)[1]);
     * ==============================================================l
     *
     * @param target   需要屏幕适配的对象 (可能是 {@link Activity} 或者 Fragment)
     * @param activity 当前 {@link Activity}
     */
    void onAdaptBefore(Object target, Activity activity);

    /**
     * 在屏幕适配后调用
     *
     * @param target   需要屏幕适配的对象 (可能是 {@link Activity} 或者 Fragment)
     * @param activity 当前 {@link Activity}
     */
    void onAdaptAfter(Object target, Activity activity);
}
