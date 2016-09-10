package org.nanolx.securitybypasser.apps;

import android.content.Context;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Pokemon GO
 */
public class PokemonGo implements IXposedHookLoadPackage
{
	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable
	{
		XposedBridge.log("Nanolx Security Bypasser: Entering Pokemon GO... Ready... Set... GO!");

		XposedHelpers.findAndHookMethod("com.upsight.android.analytics.internal.dispatcher.schema.DeviceBlockProvider",
			param.classLoader,
			"isRooted",
			new XC_MethodReplacement()
			{
				@Override
				protected Object replaceHookedMethod(MethodHookParam param) throws Throwable
				{
					XposedBridge.log("Nanolx Security Bypasser: Niantic is trying to stop us, but I won't let it happen!");
					XposedBridge.log("(Hooked com.upsight.android.analytics.internal.dispatcher.schema.DeviceBlockProvider.isRooted())");
					return false;
				}
			});
	}
}
