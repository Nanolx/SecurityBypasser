package org.nanolx.securitybypasser.apps;

import android.app.Activity;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Miitomo
 */
public class Miitomo implements IXposedHookLoadPackage
{
	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable
	{
		XposedBridge.log("Nanolx Security Bypasser: Entering Miitomo... Ready... Set... GO!");
		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController",
			param.classLoader,
			"ahS",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
					XposedBridge.log("Hooked SecureController.ahS())");
					return null;
				}
			});

		XposedHelpers.setStaticBooleanField(XposedHelpers.findClass(
			"jp.co.nintendo.android.archdev.BuildConfig",
			param.classLoader),
			"DEBUG",
			true);

		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController",
			param.classLoader,
			"ahT",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: It's debug time!");
					XposedBridge.log("Set BuildConfig.DEBUG to true)");
					return null;
				}
			});

		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController",
			param.classLoader,
			"L",
			Activity.class,
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Nintendo, I'm afraid I can't let you do that...");
					XposedBridge.log("Hooked SecureController.L())");
					return null;
				}
			});

		XposedHelpers.findAndHookMethod("jp.co.nintendo.v",
			param.classLoader,
			"dp",
			boolean.class,
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: All you logcat output are belong to us!");
					XposedBridge.log("Trying to catch v.dp(), logcat output should be available now!)");
					return null;
				}
			});

		XposedHelpers.findAndHookMethod("jp.co.nintendo.NativeSystem",
			param.classLoader,
			"nativeAbort",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Don't leave mii!");
					XposedBridge.log("(Trying to catch NativeSystem.nativeAbort())");
					return null;
				}
			});

		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController",
			param.classLoader,
			"checkEmulator",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Mii a emulator? Nope!");
					XposedBridge.log("(Hooked Cocos2dxActivity.isAndroidEmulator())");
					return false;
				}
			});

		XposedHelpers.findAndHookMethod("org.cocos2dx.lib.Cocos2dxActivity",
			param.classLoader,
			"isAndroidEmulator",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Mii a emulator? Nope!");
					XposedBridge.log("(Hooked Cocos2dxActivity.isAndroidEmulator())");
					return false;
				}
			});
	}
}
