package org.nanolx.securitybypasser.apps;

import android.app.Activity;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Monster Hunter Explore
 */
public class MonsterHunterExplore implements IXposedHookLoadPackage
{
	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable
	{
		XposedBridge.log("Nanolx Security Bypasser: Entering Monster Hunter Explore... Ready... Set... GO!");

		XposedHelpers.findAndHookMethod("jp.co.capcom.android.explore.MTFPUtils",
			param.classLoader,
			"isRooted",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Capcom, I'm afraid I can't let you do that...!");
					XposedBridge.log("(Hooked MTFPUtils.isRooted())");
					return false;
				}
			});
	}
}
