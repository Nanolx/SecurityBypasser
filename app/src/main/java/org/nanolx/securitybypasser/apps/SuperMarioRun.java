package org.nanolx.securitybypasser.apps;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Super Mario Run
 */
public class SuperMarioRun implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable {
        XposedBridge.log("Nanolx Security Bypasser: Entering Super Mario Run.");
        // hasPackage()
        XposedHelpers.findAndHookMethod("jp.dena.securelib.PrivilegeChecker",
                param.classLoader,
                "hasPackage",
                "android.content.Context",
                String.class,
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
                        XposedBridge.log("Hooked PrivilegeChecker.hasPackage()");
                        return false;
                    }
                });
        // isDebuggerAttachedJava()
        XposedHelpers.findAndHookMethod("jp.dena.securelib.PrivilegeChecker",
                param.classLoader,
                "isDebuggerAttachedJava",
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
                        XposedBridge.log("Hooked PrivilegeChecker.isDebuggerAttachedJava()");
                        return false;
                    }
                });
        // isDebuggerAttachedNative()
        XposedHelpers.findAndHookMethod("jp.dena.securelib.PrivilegeChecker",
                param.classLoader,
                "isDebuggerAttachedNative",
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
                        XposedBridge.log("Hooked PrivilegeChecker.isDebuggerAttachedNative()");
                        return false;
                    }
                });
        // isDebuggerAttachedNative2()
        XposedHelpers.findAndHookMethod("jp.dena.securelib.PrivilegeChecker",
                param.classLoader,
                "isDebuggerAttachedNative2",
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
                        XposedBridge.log("Hooked PrivilegeChecker.isDebuggerAttachedNative2()");
                        return false;
                    }
                });
        // isEmulator()
        XposedHelpers.findAndHookMethod("jp.dena.securelib.PrivilegeChecker",
                param.classLoader,
                "isEmulator",
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
                        XposedBridge.log("Hooked PrivilegeChecker.isEmulator()");
                        return false;
                    }
                });
        // isRooted()
        XposedHelpers.findAndHookMethod("jp.dena.securelib.PrivilegeChecker",
                param.classLoader,
                "isRooted",
                "android.content.Context",
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
                        XposedBridge.log("Hooked PrivilegeChecker.isRooted()");
                        return false;
                    }
                });
        // isUSBConnected()
        XposedHelpers.findAndHookMethod("jp.dena.securelib.PrivilegeChecker",
                param.classLoader,
                "isUSBConnected",
                "android.content.Context",
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
                        XposedBridge.log("Hooked PrivilegeChecker.isUSBConnected()");
                        return false;
                    }
                });
        // isUSBDebugEnabled()
        XposedHelpers.findAndHookMethod("jp.dena.securelib.PrivilegeChecker",
                param.classLoader,
                "isUSBDebugEnabled",
                "android.content.Context",
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
                        XposedBridge.log("Hooked PrivilegeChecker.isUSBDebugEnabled()");
                        return false;
                    }
                });
        // isUSBDebugOptionEnabled()
        XposedHelpers.findAndHookMethod("jp.dena.securelib.PrivilegeChecker",
                param.classLoader,
                "isUSBDebugOptionEnabled",
                "android.content.Context",
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
                        XposedBridge.log("Hooked PrivilegeChecker.isUSBDebugOptionEnabled()");
                        return false;
                    }
                });
        // isSuccess()
        XposedHelpers.findAndHookMethod("com.snslinkage.dena.snslinkageunityplugin.AttestCall",
                param.classLoader,
                "isSuccess",
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
                        XposedBridge.log("Hooked AttestCall.isSuccess()");
                        return true;
                    }
                });

        // String[] packages
        XposedHelpers.setStaticObjectField(
                XposedHelpers.findClass("jp.dena.securelib.PrivilegeChecker", param.classLoader),
                "packages",
                new String[]{"non.existing.package"});
        // String[] suExecutables
        XposedHelpers.setStaticObjectField(
                XposedHelpers.findClass("jp.dena.securelib.PrivilegeChecker", param.classLoader),
                "suExecutables",
                new String[]{"/non/existing/path"});
    }
}
