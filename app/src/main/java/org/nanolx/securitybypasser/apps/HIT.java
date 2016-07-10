package org.nanolx.securitybypasser.apps;

import android.app.Activity;
import android.content.Context;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * HIT (EN)
 */
public class HIT implements IXposedHookLoadPackage
{
	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable
	{
		XposedBridge.log("Nanolx Security Bypasser: HIT... Ready... Set... GO!");
		XposedHelpers.findAndHookMethod("da",
			param.classLoader,
			"run",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Nexon is trying to stop us, but I won't let it happen!");
					XposedBridge.log("da.run()V)");
					return null;
				}
			});

		XposedHelpers.findAndHookMethod("com.epicgames.ue4.GameActivity",
			param.classLoader,
			"AndroidThunkJava_ForceQuit",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Unreal4, I'm afraid I can't let you do that...");
					XposedBridge.log("Hooked com.epicgames.ue4.GameActivity.AndroidThunkJava_ForceQuit())");
					return null;
				}
			});

		XposedHelpers.findAndHookMethod("com.epicgames.ue4.GlobalApplication",
			param.classLoader,
			"nativeIsShippingBuild",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Unreal4 is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(com.epicgames.ue4.GlobalApplication.nativeIsShippingBuild())");
					return false;
				}
			});

		XposedHelpers.findAndHookMethod("com.epicgames.ue4.GameActivity",
			param.classLoader,
			"nativeIsShippingBuild",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Unreal4 is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(com.epicgames.ue4.GameActivity.nativeIsShippingBuild())");
					return false;
				}
			});

		XposedHelpers.findAndHookMethod("com.epicgames.ue4.Spectrum",
			param.classLoader,
			"getEnvironmentVersion",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Unreal4, I'm afraid I can't let you do that...");
					XposedBridge.log("Hooked com.epicgames.ue4.Spectrum.getEnvironmentVersion())");
					return "prod";
				}
			});

		XposedHelpers.findAndHookMethod("com.tnkfactory.ad.gw",
			param.classLoader,
			"d",
			Context.class,
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Hey, don't sniff into /system!");
					XposedBridge.log("(com.tnkfactory.ad.gw.d())");
					return null;
				}
			});

	}
}
