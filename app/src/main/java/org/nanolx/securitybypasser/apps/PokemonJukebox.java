package org.nanolx.securitybypasser.apps;

import android.content.Context;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Pokemon Jukebox
 */
public class PokemonJukebox implements IXposedHookLoadPackage
{
	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable
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
}
