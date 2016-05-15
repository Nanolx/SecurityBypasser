package org.nanolx.securitybypasser;

import android.content.Context;
import android.app.Activity;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class XposedEntryPoint implements IXposedHookLoadPackage
{

	@Override
	public void handleLoadPackage(LoadPackageParam param) throws Throwable
	{
						// Miitomo
		if (param.packageName.equalsIgnoreCase("com.nintendo.zaaa"))
		{

		XposedBridge.log("Nanolx Security Bypasser: Entering Miitomo... Ready... Set... GO!");
		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController", param.classLoader, "ahS", new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Nintendo is trying to stop us, but I won't let it happen! (Hooked SecureController.ahS())");
					return null;
				}

			});

		XposedHelpers.setStaticBooleanField(XposedHelpers.findClass("jp.co.nintendo.android.archdev.BuildConfig", param.classLoader), "DEBUG", true);

		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController", param.classLoader, "ahT", new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: It's debug time! (Set BuildConfig.DEBUG to true)");
					return null;
				}

			});

		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController", param.classLoader, "L", Activity.class, new XC_MethodReplacement(){
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Nintendo, I'm afraid I can't let you do that... (Hooked SecureController.L())");
					return null;
				}

		});

		XposedHelpers.findAndHookMethod("jp.co.nintendo.v", param.classLoader, "dp", boolean.class, new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: All you logcat output are belong to us! (Trying to catch v.dp(), logcat output should be available now!)");
					return null;
				}

		});

		XposedHelpers.findAndHookMethod("jp.co.nintendo.NativeSystem", param.classLoader, "nativeAbort", new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Don't leave mii! (Trying to catch NativeSystem.nativeAbort())");
					return null;
				}

		});

		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController", param.classLoader, "checkEmulator", new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Mii a emulator? Nope! (Hooked SecureController.checkEmulator())");
					return false;
				}

			});

		XposedHelpers.findAndHookMethod("org.cocos2dx.lib.Cocos2dxActivity", param.classLoader, "isAndroidEmulator", new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Mii a emulator? Nope! (Hooked Cocos2dxActivity.isAndroidEmulator())");
					return false;
				}

			});
		}

						// Yokai Watch Wibble Wobble (US)
		else if (param.packageName.equalsIgnoreCase("com.level5.ywwwus"))
		{

		XposedBridge.log("Nanolx Security Bypasser: Entering Yokai Watch Wibble Wobble (US)... Ready... Set... GO!");

		XposedHelpers.findAndHookMethod("com.example.sgf.MainActivity",
			param.classLoader,
			"checkRoot",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Level5 is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(Hooked com.example.sgf.MainActivity.checkRoot())");
					return false;
				}
			});

		XposedHelpers.findAndHookMethod("com.mparticle.b.d",
			param.classLoader,
			"h",
			Context.class,
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Hey, don't sniff into /system!");
					XposedBridge.log("(com.mparticle.b.d.h())");
					return false;
				}
			});

		XposedHelpers.findAndHookMethod("com.hangame.hsp.util.DeviceInfoUtil",
			param.classLoader,
			"isRunningOnEmulator",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Hey, don't sniff into /system!");
					XposedBridge.log("(com.hangame.hsp.util.DeviceInfoUtil.isRunningOnEmulator())");
					return false;
				}
			});

		}
							// Pokemon Jukebox
		else if (param.packageName.equalsIgnoreCase("jp.pokemon.music"))
		{

		XposedBridge.log("Nanolx Security Bypasser: Entering Pokemon Jukebox... Ready... Set... GO!");

		XposedHelpers.findAndHookMethod("com.pokemon.music.d.k",
			param.classLoader,
			"c",
			Context.class,
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Pokemon Company is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(Hooked com.pokemon.music.d.k.c())");
					return false;
				}
			});

		}
		else
		{
			return;
		}

	}

}

