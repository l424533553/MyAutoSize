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
package me.jessyan.autosize.config;

import android.app.Activity;

import me.jessyan.autosize.AutoAdaptStrategy;
import me.jessyan.autosize.AutoSizeConfig;

/**
 * ================================================
 * {@link AutoAdaptStrategy} 的包装者, 用于给 {@link AutoAdaptStrategy} 的实现类增加一些额外的职责
 * ================================================
 * @author LUOFAXIN
 */
public class WrapperAutoAdaptStrategy implements AutoAdaptStrategy {
    private final AutoAdaptStrategy mAutoAdaptStrategy;

    public WrapperAutoAdaptStrategy(AutoAdaptStrategy autoAdaptStrategy) {
        mAutoAdaptStrategy = autoAdaptStrategy;
    }

    /**
     * 开始执行屏幕适配逻辑
     * @param target   需要屏幕适配的对象 (可能是 {@link Activity} 或者 Fragment)
     * @param activity 需要拿到当前的 {@link Activity} 才能修改 {@link android.util.DisplayMetrics #density}
     */
    @Override
    public void applyAdapt(Object target, Activity activity) {
        OnAdaptListener onAdaptListener = AutoSizeConfig.getInstance().getOnAdaptListener();
        if (onAdaptListener != null){
            onAdaptListener.onAdaptBefore(target, activity);
        }
        if (mAutoAdaptStrategy != null) {
            mAutoAdaptStrategy.applyAdapt(target, activity);
        }
        if (onAdaptListener != null){
            onAdaptListener.onAdaptAfter(target, activity);
        }
    }
}
