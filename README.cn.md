# [English](README.md) | 中文文档
## Launcher3 from android-14.0.0_r67
### Launcher3脱离源码在Android Studio的编译
##### 不同安卓版本的支持请切换到对应的分支
### 支持说明
* Google虽然很早就对Launcher3添加了Gradle支持，但是自从Android 12之后，开始撂挑子了，相关脚本代码已经不怎么维护，于是我们试着重新出发，对相关代码做修正，使其可以通过Android Studio进行单独编译。
* 从Android 14 开始，Launcher3内部开始引用一些系统内部的私有资源，这些在Android Studio的SDK工具链里是无法被识别的，需要用脚本来进行临时性替代。

## 使用命令编译
### 环境依赖
*  Gradle 8.7
*  JDK version 17

```
# 构建环境
gradle wrapper

# 执行预过滤任务
./gradlew :Filter:run

# 打包编译
./gradlew assemble
```


## 在Android Studio上编译
### 推荐使用
*  Android Studio Koala & JDK version 11

#### 第一步：运行在Filter上的主函数，会执行过滤任务
<img src="images/filter_main.png" width = "700"/>

*  移除一些AS不支持的颜色属性


### 第二步：执行Android Studio上Build APK的操作, 然后将apk推送到设备上Launcher3所在的目录

```
adb push Launcher3QuickStep.apk /system_ext/priv-app/Launcher3QuickStep/

adb shell killall com.android.launcher3
```
#####  首次推送会起不来，需要重启一下设备
```
adb reboot
```

######  另外也支持打包出其他的Flavors版本

<img src="images/output.png" width = "700"/>

## 构建步骤

### Step1：引入静态依赖
##### @framework.jar:
```
// android-14/out/target/common/obj/JAVA_LIBRARIES/framework_intermediates/classes-header.jar
compileOnly files('libs/framework.jar')
```
![avatar](images/framework.png)

##### @core-all.jar:
```
// android-14/out/soong/.intermediates/libcore/core-all/android_common/javac/core-all.jar
compileOnly files('libs/core-all.jar')
```
![avatar](images/core-all.png)


##### @libprotobuf-java-nano.jar:
```
// android-14/out/soong/.intermediates/external/protobuf/libprotobuf-java-nano/android_common/javac/libprotobuf-java-nano.jar
implementation files('libs/libprotobuf-java-nano.jar')
```
![avatar](images/libprotobuf-java-nano.png)


##### @WindowManager-Shell-proto.jar:
```
// android-14/out/soong/.intermediates/frameworks/base/libs/WindowManager/Shell/WindowManager-Shell-proto/android_common/e18b8e8d84cb9f664aa09a397b08c165/javac/WindowManager-Shell-proto.jar
implementation files('libs/WindowManager-Shell-proto.jar')
```
![avatar](images/WindowManager-Shell-proto.png)

##### @WindowManager-Shell-shared.jar:
```
// android-14/out/soong/.intermediates/frameworks/base/libs/WindowManager/Shell/WindowManager-Shell-shared/android_common/e18b8e8d84cb9f664aa09a397b08c165/javac/WindowManager-Shell-shared.jar
implementation files('libs/WindowManager-Shell-shared.jar')
```
![avatar](images/WindowManager-Shell-shared.png)


##### @SystemUI-statsd.jar:
```
// android-14/out/soong/.intermediates/frameworks/base/packages/SystemUI/shared/SystemUI-statsd/android_common/e18b8e8d84cb9f664aa09a397b08c165/javac/SystemUI-statsd.jar
implementation files('libs/SystemUI-statsd.jar')
```
![avatar](images/SystemUI-statsd.png)

##### @com.android.window.flags.window-aconfig-java.jar:
```
// android-14/out/soong/.intermediates/frameworks/base/com.android.window.flags.window-aconfig-java/android_common/javac/com.android.window.flags.window-aconfig-java.jar
implementation files('com.android.window.flags.window-aconfig-java.jar')
```
![avatar](images/com.android.window.flags.window-aconfig-java.png)

##### @com_android_systemui_flags_lib.jar:
```
// android-14/out/soong/.intermediates/frameworks/base/packages/SystemUI/aconfig/com_android_systemui_flags_lib/android_common/e18b8e8d84cb9f664aa09a397b08c165/javac/com_android_systemui_flags_lib.jar
implementation files('com_android_systemui_flags_lib.jar')
```
![avatar](images/com_android_systemui_flags_lib.png)


##### @com_android_systemui_shared_flags_lib.jar:
```
// android-14/out/soong/.intermediates/frameworks/libs/systemui/aconfig/com_android_systemui_shared_flags_lib/android_common/e18b8e8d84cb9f664aa09a397b08c165/javac/com_android_systemui_shared_flags_lib.jar
implementation files('com_android_systemui_shared_flags_lib.jar')
```
![avatar](images/com_android_systemui_shared_flags_lib.png)


##### @com_android_wm_shell_flags_lib.jar:
```
// android-14/out/soong/.intermediates/frameworks/base/libs/WindowManager/Shell/aconfig/com_android_wm_shell_flags_lib/android_common/e18b8e8d84cb9f664aa09a397b08c165/javac/com_android_wm_shell_flags_lib.jar
implementation files('com_android_wm_shell_flags_lib.jar')
```
![avatar](images/com_android_wm_shell_flags_lib.png)


##### @com_android_launcher3_flags_lib.jar:
```
// android-14/out/soong/.intermediates/packages/apps/Launcher3/aconfig/com_android_launcher3_flags_lib/android_common/e18b8e8d84cb9f664aa09a397b08c165/javac/com_android_launcher3_flags_lib.jar
implementation files('com_android_launcher3_flags_lib.jar')
```
![avatar](images/com_android_launcher3_flags_lib.png)


##### @perfetto_trace_java_protos.jar:
```
// android-14/out/soong/.intermediates/external/perfetto/perfetto_trace_java_protos/android_common/e18b8e8d84cb9f664aa09a397b08c165/javac/perfetto_trace_java_protos.jar
implementation files('libs/perfetto_trace_java_protos.jar')
```
![avatar](images/perfetto_trace_java_protos.png)

##### @launcher-testing-shared.jar:
```
// android-14/out/soong/.intermediates/packages/apps/Launcher3/tests/launcher-testing-shared/android_common/javac/launcher-testing-shared.jar
implementation files('libs/launcher-testing-shared.jar')
```
![avatar](images/launcher-testing-shared.png)

##### @tracinglib-platform.jar:
```
// android-14/out/soong/.intermediates/frameworks/libs/systemui/tracinglib/tracinglib-platform/android_common/e18b8e8d84cb9f664aa09a397b08c165/kotlin/tracinglib-platform.jar
implementation files('libs/tracinglib-platform.jar')
```
![avatar](images/tracinglib-platform.png)


### Step2：引入Module
###### 将具体路径下的代码直接导入到项目中作为Module依赖, 构建的时候可以直接通过implementation project引用，或者也可以gradle build生成aar,再放置到libs文件夹中，作为静态包使用。

##### @iconloaderlib: 
```
// android-14/frameworks/libs/systemui/iconloaderlib
implementation project(':iconloaderlib')
```
![avatar](images/iconloaderlib.png)

##### @animationlib: 
```
// android-14/frameworks/libs/systemui/animationlib  
implementation project(':animationlib')
```
![avatar](images/animationlib.png)

##### @viewcapturelib: 
```
// android-14/frameworks/libs/systemui/viewcapturelib  
implementation project(':viewcapturelib')
```
![avatar](images/viewcapturelib.png)


##### @Shell: 
```
// android-14/frameworks/base/libs/WindowManager/Shell
implementation project(':Shell')
```
![avatar](images/Shell.png)

##### @plugin: 
```
// android-14/frameworks/base/packages/SystemUI/plugin
implementation project(':plugin')
```
![avatar](images/plugin.png)

##### @plugin_core: 
```
// android-14/frameworks/base/packages/SystemUI/plugin_core
implementation project(':plugin_core')
```
![avatar](images/plugin_core.png)


##### @shared: 
```
// android-14/frameworks/base/packages/SystemUI/shared
implementation project(':shared')
```
![avatar](images/shared.png)

##### @animation: 
```
// android-14/frameworks/base/packages/SystemUI/animation
implementation project(':animation')
```
![avatar](images/animation.png)

##### @unfold: 
```
// android-14/frameworks/base/packages/SystemUI/unfold
implementation project(':unfold')
```
![avatar](images/unfold.png)

##### @common: 
```
// android-14/frameworks/base/packages/SystemUI/common
implementation project(':common')
```
![avatar](images/common.png)

##### @log: 
```
// android-14/frameworks/base/packages/SystemUI/log
implementation project(':log')
```
![avatar](images/log.png)

##### @SettingsTheme: 
```
// android-14/frameworks/base/packages/SettingsLib/SettingsTheme
implementation project(':SettingsTheme')
```
![avatar](images/SettingsTheme.png)

## 生成platform.keystore默认签名

在AOSP/android-14/build/target/product/security路径下找到签名证书，并使用 [keytool-importkeypair](https://github.com/getfatday/keytool-importkeypair) 生成keystore,
执行如下命令：

```
./keytool-importkeypair -k platform.keystore -p 123456 -pk8 platform.pk8 -cert platform.x509.pem -alias platform
```

并将以下代码添加到gradle配置中：

```
    signingConfigs {
        platform {
            storeFile file("platform.keystore")
            storePassword '123456'
            keyAlias 'platform'
            keyPassword '123456'
        }
    }

    buildTypes {
        release {
            debuggable false
            minifyEnabled false
            signingConfig signingConfigs.platform
        }

        debug {
            debuggable true
            minifyEnabled false
            signingConfig signingConfigs.platform
        }
    }
```

### PS:
##### 查看被忽略的文件列表
```
git ls-files -v | grep '^h\ '
```  

##### 忽略和还原单个文件
``` 
git update-index --assume-unchanged $path
git update-index --no-assume-unchanged $path
``` 

##### 还原全部被忽略的文件
```
git ls-files -v | grep '^h' | awk '{print $2}' |xargs git update-index --no-assume-unchanged 
```

### 关联项目
* [Settings](https://github.com/siren-ocean/Settings)
* [Launcher3](https://github.com/siren-ocean/Launcher3)
* [DocumentsUI](https://github.com/siren-ocean/DocumentsUI)
* [Camera2](https://github.com/siren-ocean/Camera2)
* [PermissionController](https://github.com/siren-ocean/PermissionController)