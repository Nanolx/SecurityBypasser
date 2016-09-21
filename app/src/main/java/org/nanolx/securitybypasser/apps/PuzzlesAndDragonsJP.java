package org.nanolx.securitybypasser.apps;

import android.content.Context;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Puzzles And Dragons (HT)
 */
public class PuzzlesAndDragonsJP implements IXposedHookLoadPackage
{
	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable
	{
		XposedBridge.log("Nanolx Security Bypasser: Entering Puzzles And Dragons (JP)... Ready... Set... GO!");

		XposedHelpers.findAndHookMethod("jp.gungho.padHT.AppDelegate",
			param.classLoader,
			"checkRoot",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Gungho is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(Hooked jp.gungho.padHT.AppDelegate.checkRoot())");
					return false;
				}
			});
	}
}
