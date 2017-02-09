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
			"ZV",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen!");
					XposedBridge.log("Hooked SecureController.ZV())");
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
			"ZW",
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
			"P",
			Activity.class,
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Nintendo, I'm afraid I can't let you do that...");
					XposedBridge.log("Hooked SecureController.P())");
					return null;
				}
			});

		XposedHelpers.findAndHookMethod("jp.co.nintendo.z",
			param.classLoader,
			"cS",
			boolean.class,
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: All you logcat output are belong to us!");
					XposedBridge.log("Trying to catch z.cS(), logcat output should be available now!)");
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
					XposedBridge.log("(Hooked SecureController.checkEmulator())");
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
