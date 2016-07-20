package org.nanolx.securitybypasser.apps;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Final Fantasy Brave Exvius
 */
public class FFBraveExvius implements IXposedHookLoadPackage
{
	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable
	{
		XposedBridge.log("Nanolx Security Bypasser: Entering FF Brave Exvius... Ready... Set... GO!");

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
