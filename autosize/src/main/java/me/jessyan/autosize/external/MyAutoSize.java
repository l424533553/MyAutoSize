package me.jessyan.autosize.external;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import me.jessyan.autosize.expose.AutoSize;
import me.jessyan.autosize.expose.AutoSizeConfig;
import me.jessyan.autosize.external.inface.OnAdaptListener;
import me.jessyan.autosize.external.inface.Subunits;
import me.jessyan.autosize.utils.AutoSizeLog;
import me.jessyan.autosize.utils.Precondition;

/**
 * @author 罗发新
 * 创建时间：2020/11/23  17:32
 * 邮件：424533553@qq.com
 * CSDN：https://blog.csdn.net/luo_boke
 * <p>
 * 更新时间：2020/11/23  17:32
 * <p>
 * 文件说明：自动适配的唯一暴露类
 * 如果需要适配，直接在项目中适配
 * <p>
 * 在清单文件中 配置如下，即可使用
 * <meta-data
 * android:name="design_width_in_dp"
 * android:value="360" />
 *
 * <meta-data
 * android:name="design_height_in_dp"
 * android:value="640" />
 */
public class MyAutoSize {


    /**
     * 支持多进程
     */
    public void initCompatMultiProcess(@NonNull Context context) {
        AutoSize.initCompatMultiProcess(context);
    }

    /**
     * 使用 AndroidAutoSize 初始化时设置的默认适配参数进行适配 (AndroidManifest 的 Meta 属性)
     *
     * @param activity {@link Activity}
     */
    public void autoConvertDensityOfGlobal(Activity activity) {
        AutoSize.autoConvertDensityOfGlobal(activity);
    }


    public static void autoConvertDensity(Activity activity, float sizeInDp, boolean isBaseOnWidth) {
        AutoSize.autoConvertDensity(activity, sizeInDp, isBaseOnWidth);
    }

    /**
     * 初始化检查 ，最好放在Application  OnCreate方法内
     */
    public void checkAndInit(@NonNull Application application) {
        AutoSize.checkAndInit(application);
    }

    /**
     * 重新开始框架的运行
     * 框架具有 热插拔 特性, 支持在项目运行中动态停止和重新启动适配功能
     */
    public static void restart() {
        AutoSizeConfig.getInstance().restart();
    }

    /**
     * 停止框架的运行
     * 框架具有 热插拔 特性, 支持在项目运行中动态停止和重新启动适配功能
     */
    public static void stop(Activity activity) {
        AutoSizeConfig.getInstance().stop(activity);
    }


    /**
     * 设置适配监听
     */
    public void setOnAdaptListener(OnAdaptListener listener) {
        AutoSizeConfig.getInstance().setOnAdaptListener(listener);
    }

    /**
     * 设置屏幕参数设置
     *
     * @param baseOnWidth   {@code true} 为按照宽度, {@code false} 为按照高度
     * @param useDeviceSize {@code true}为使用设备的实际尺寸 (包含状态栏),
     *                      {@code false，默认} 为不使用设备的实际尺寸 (不包含状态栏)
     */
    public void setScreenConfig(boolean baseOnWidth, boolean useDeviceSize) {
        AutoSizeConfig.getInstance().setBaseOnWidth(baseOnWidth).setUseDeviceSize(useDeviceSize);
    }


    /**
     * 是否让框架支持自定义 Fragment 的适配参数, 由于这个需求是比较少见的, 所以须要使用者手动开启
     */
    public void setCustomFragment(boolean customFragment) {
        AutoSizeConfig.getInstance().setCustomFragment(customFragment);
    }

    /**
     * 是否屏蔽系统字体大小对 AndroidAutoSize 的影响, 如果为 {@code true}, App 内的字体的大小将不会跟随系统设置中字体大小的改变
     * 如果为 {@code false}, 则会跟随系统设置中字体大小的改变, 默认为 {@code false}
     */
    public void setExcludeFontScale(boolean excludeFontScale) {
        AutoSizeConfig.getInstance().setExcludeFontScale(excludeFontScale);
    }


    public void setLog(boolean log) {
        AutoSizeLog.setDebug(log);
    }

    /**
     * 设置DP支持
     */
    public void setSupportDp(boolean isSupportDp) {
        AutoSizeConfig.getInstance().getUnitsManager().setSupportDP(isSupportDp);
    }

    /**
     * 设置SP支持
     */
    public void setSupportSp(boolean isSupportSp) {
        AutoSizeConfig.getInstance().getUnitsManager().setSupportDP(isSupportSp);
    }

    /**
     * 设计尺寸
     *
     * @param designWidth  屏幕宽
     * @param designHeight 屏幕高
     */
    public void designSize(float designWidth, float designHeight) {
        AutoSizeConfig.getInstance()
                .getUnitsManager()
                .setDesignSize(designWidth, designHeight);
    }

    /**
     * 设置支持的单位
     */
    public void setSupportSubunits(Subunits subunit) {
        AutoSizeConfig.getInstance().getUnitsManager().setSupportSubunits(subunit);
    }


}
