package org.nanolx.securitybypasser.apps;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Amazon Flex / Mobile Delivery
 */
public class AmazonFlex implements IXposedHookLoadPackage
{
	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable
	{
		XposedBridge.log("Nanolx Security Bypasser: Entering Amazon Flex... Ready... Set... GO!");

		XposedHelpers.findAndHookMethod("com.scottyab.rootbeer.RootBeer",
			param.classLoader,
			"checkForBinary",
			String.class,
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Amazon is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(com.scottyab.rootbeer.RootBeer.checkForBinary())");
					return false;
				}
			});

		XposedHelpers.findAndHookMethod("com.scottyab.rootbeer.RootBeer",
			param.classLoader,
			"checkForRootNative",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Amazon is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(com.scottyab.rootbeer.RootBeer.checkForRootNative())");
					return false;
				}
			});

		XposedHelpers.findAndHookMethod("com.scottyab.rootbeer.RootBeer",
			param.classLoader,
			"checkSuExists",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Amazon is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(com.scottyab.rootbeer.RootBeer.checkSuExists())");
					return false;
				}
			});

		XposedHelpers.findAndHookMethod("com.scottyab.rootbeer.RootBeer",
			param.classLoader,
			"checkForRWPaths",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Amazon is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(com.scottyab.rootbeer.RootBeer.checkForRWPaths())");
					return false;
				}
			});

		XposedHelpers.findAndHookMethod("com.scottyab.rootbeer.RootBeer",
			param.classLoader,
			"checkForDangerousProps",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Amazon is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(com.scottyab.rootbeer.RootBeer.checkForDangerousProps())");
					return false;
				}
			});

		XposedHelpers.findAndHookMethod("com.scottyab.rootbeer.RootBeer",
			param.classLoader,
			"isAnyPackageFromListInstalled",
			"java.util.List",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Amazon is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(com.scottyab.rootbeer.RootBeer.isAnyPackageFromListInstalled())");
					return false;
				}
			});
	}
}
