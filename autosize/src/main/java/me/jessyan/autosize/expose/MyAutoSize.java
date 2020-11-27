package me.jessyan.autosize.expose;

import android.app.Application;

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
 */
public class MyAutoSize {

    public static void initAutoSize(Application application) {
        if (application == null) {
            throw new NullPointerException("application 不可为空 ");
        }

        AutoSize.initCompatMultiProcess(application);
        //如果在某r些特殊情况下出现 InitProvider 未能正常实例化, 导致 AndoidAutoSize 未能完成初始化
        //可以主动调用 AutoSize.checkAndInit(this) 方法, 完成 AndroidAutoSize 的初始化后即可正常使用
        AutoSize.checkAndInit(application);
        AutoSizeConfig.getInstance()
                //是否让框架支持自定义 Fragment 的适配参数, 由于这个需求是比较少见的, 所以须要使用者手动开启
                //如果没有这个需求建议不开启
//                .setCustomFragment(true)
                //是否屏蔽系统字体大小对 AndroidAutoSize 的影响, 如果为 true, App 内的字体的大小将不会跟随系统设置中字体大小的改变
                //如果为 false, 则会跟随系统设置中字体大小的改变, 默认为 false
//                .setExcludeFontScale(true)

                .setExcludeFontScale(true)
//                .setPrivateFontScale(0.8f)
                .setLog(false)
                .setBaseOnWidth(true)
                .setUseDeviceSize(true);

                //区别于系统字体大小的放大比例, AndroidAutoSize 允许 APP 内部可以独立于系统字体大小之外，独自拥有全局调节 APP 字体大小的能力
                //当然, 在 APP内您必须使用 sp 来作为字体的单位, 否则此功能无效, 不设置或将此值设为 0 则取消此功能
//                .setPrivateFontScale(0.8f);
    }

}
