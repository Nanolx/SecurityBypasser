package org.nanolx.securitybypasser.apps;

import android.content.Context;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Yokai Watch Wibble Wobble
 */
public class YokaiWatchWW implements IXposedHookLoadPackage
{
	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable
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
}
