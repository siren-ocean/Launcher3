package com.siren.filter;

/**
 * 主程序
 * Created by Siren on 2022/4/7.
 */
public class Main {

    /**
     * 执行过滤任务
     */
    public static void main(String[] args) {
        replaceContent();
    }

    /**
     * 替换掉不能被识别到私有颜色引用
     */
    private static void replaceContent() {
        String TRANSPARENT_COLOR = "#00ffffff";
        FileContentReplacer.replaceInPath("quickstep/res/values/colors.xml", "?androidprv:attr/colorAccentPrimaryVariant", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/colors.xml", "?androidprv:attr/materialColorPrimaryFixedDim", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/colors.xml", "?androidprv:attr/materialColorOnPrimaryFixed", TRANSPARENT_COLOR);

        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorSurfaceContainer", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorPrimaryFixedDim", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorOnPrimaryFixedVariant", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorOnPrimaryFixed", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorTertiaryFixedDim", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorOnTertiaryFixedVariant", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorOnTertiaryFixed", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorPrimaryFixed", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorOnSecondaryFixedVariant", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorOnSecondaryFixed", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorOnSurfaceVariant", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorOnSurface", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorTertiaryFixed", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values/styles.xml", "?androidprv:attr/materialColorOnPrimary", TRANSPARENT_COLOR);


        FileContentReplacer.replaceInPath("quickstep/res/values-night/colors.xml", "?androidprv:attr/colorAccentSecondaryVariant", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/colors.xml", "?androidprv:attr/materialColorPrimaryFixedDim", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/colors.xml", "?androidprv:attr/materialColorOnPrimaryFixed", TRANSPARENT_COLOR);

        FileContentReplacer.replaceInPath("quickstep/res/values-night/styles.xml", "?androidprv:attr/materialColorSurfaceContainer", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/styles.xml", "?androidprv:attr/materialColorPrimaryFixedDim", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/styles.xml", "?androidprv:attr/materialColorOnPrimaryFixedVariant", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/styles.xml", "?androidprv:attr/materialColorOnPrimaryFixed", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/styles.xml", "?androidprv:attr/materialColorTertiaryFixedDim", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/styles.xml", "?androidprv:attr/materialColorOnTertiaryFixedVariant", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/styles.xml", "?androidprv:attr/materialColorOnTertiaryFixed", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/styles.xml", "?androidprv:attr/materialColorPrimaryFixed", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/styles.xml", "?androidprv:attr/materialColorOnSecondaryFixedVariant", TRANSPARENT_COLOR);
        FileContentReplacer.replaceInPath("quickstep/res/values-night/styles.xml", "?androidprv:attr/materialColorOnSecondaryFixed", TRANSPARENT_COLOR);

        FileContentReplacer.replaceInPath("Shell/res/values/styles.xml", "?androidprv:attr/materialColorOnSurface", TRANSPARENT_COLOR);
    }
}
