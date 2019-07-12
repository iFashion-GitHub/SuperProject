# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontobfuscate
-keepclassmembers class **.R$* {
 public static <fields>;
}

-dontwarn com.google.*.*
-keep class com.google.** {*;}
-keep class android.**{*;}

-keep class com.google.protobuf.** { *; }
-keep class * extends com.google.protobuf.** { *; }


-keepclasseswithmembers class * {
    public <init>(android.content.Context);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class **.R$* {
    public static <fields>;
}
-keepclasseswithmember class * {     # 保持 native 方法不被混淆
    native <methods>;
}
-keepclassmembers enum * {
    **[] $VALUES;
    public *;
}

-keepclassmembers enum * {                  # 保持枚举 enum 类不被混淆
    public static **[] values();
    public static ** valueOf(java.lang.String);
    <fields>;
}

-keep class * implements android.os.Parcelable {    # 保持Parcelable不被混淆
  public static final android.os.Parcelable$Creator *;
}


-keep class com.light.play.binding.input.evdev.* {*;}

# Moonlight common
-keep class com.light.play.nvstream.jni.* {*;}

# Okio
-keep class sun.misc.Unsafe {*;}
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn okio.**

# BouncyCastle
-keep class org.bouncycastle.jcajce.provider.asymmetric.* {*;}
-keep class org.bouncycastle.jcajce.provider.asymmetric.* {*;}
-keep class org.bouncycastle.jcajce.provider.asymmetric.util.* {*;}
-keep class org.bouncycastle.jcajce.provider.asymmetric.rsa.* {*;}
-keep class org.bouncycastle.jcajce.provider.digest.** {*;}
-keep class org.bouncycastle.jcajce.provider.symmetric.** {*;}
-keep class org.bouncycastle.jcajce.spec.* {*;}
-keep class org.bouncycastle.jce.** {*;}
-keep class org.bouncycastle.cert.jcajce.* {*;}
-keep class org.bouncycastle.cert.* {*;}
-keep class org.bouncycastle.jcajce.* {*;}
-dontwarn javax.naming.**

# jMDNS
-dontwarn javax.jmdns.impl.DNSCache

#-dontwarn sun.misc.***
-dontwarn sun.misc.***
-keep class sun.misc. { *; }
#jni保留
-keep class com.light.play.gsmointor.**{*;}
-keep class com.light.play.api.LightPlay{*;}
-keep class com.light.play.api.LightPlayView{*;}
-keep class com.pb.**{*;}
-keep class com.light.play.entity.DialogMessageEntity{*;}
-keep class com.light.play.entity.LocalUserInfo{*;}
-keep class com.light.play.entity.UserInfo{*;}
-keep class com.light.play.entity.Header{*;}
-keep class com.light.play.entity.Result{*;}
-keep class com.light.play.eneity.AuthenticationResponse{*;}
-keep class com.light.play.entity.Body{*;}
-keep class com.light.play.entity.Ret{*;}
-keep class com.light.play.manager.AccountManager{*;}

-keep interface com.light.play.ui.InputCallbacks{*;}


-keep enum com.light.play.api.PlayQualityLevel
-keep enum com.light.play.api.PlayFrameRate
-keep enum com.light.play.api.VirtualControlType


-keep interface com.light.play.api.OnPlayErrorListener{*;}
-keep interface com.light.play.api.OnPlayStatusListener{*;}
-keep interface com.light.play.api.OnPlayPreparedListener{*;}


-dontwarn okio.**
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *; }
-keep interface com.squareup.okhttp3.** { *; }
-dontwarn okhttp3.internal.platform.ConscryptPlatform.**

-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**

-dontwarn org.jcodec.codecs.h264.**
-keep class org.jcodec.codecs.h264.** {*;}

-keep class org.conscrypt.**{*;}

-keep class com.limelight.nvstream.jni.* {*;}