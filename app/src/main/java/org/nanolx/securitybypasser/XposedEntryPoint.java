package org.nanolx.securitybypasser;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import org.nanolx.securitybypasser.apps.AmazonFlex;
import org.nanolx.securitybypasser.apps.HIT;
import org.nanolx.securitybypasser.apps.KingdomHeartsUX;
import org.nanolx.securitybypasser.apps.Miitomo;
import org.nanolx.securitybypasser.apps.YokaiWatchWW;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class XposedEntryPoint implements IXposedHookLoadPackage
{
	/** Map of lower case package names to their respective package hooks. */
	private static Map<String, Class<? extends IXposedHookLoadPackage>> appRegistry;

	static
	{
		// Load up our registry with the hook handlers
		// Note: These package names must be lowercase.
		appRegistry = new HashMap<String, Class<? extends IXposedHookLoadPackage>>();
		appRegistry.put("com.amazon.rabbit", AmazonFlex.class);
		appRegistry.put("com.nexon.hit.global", HIT.class);
		appRegistry.put("com.square_enix.android_googleplay.khuxww", KingdomHeartsUX.class);
		appRegistry.put("com.nintendo.zaaa", Miitomo.class);
		appRegistry.put("com.level5.ywwwus", YokaiWatchWW.class);
	}

	@Override
	public void handleLoadPackage(LoadPackageParam param) throws Throwable
	{
		// package names are alphanumeric with _'s only. but diff device locales may handle
		// lowercase operations differently. be specific and use english.
		final String packageLower = param.packageName.toLowerCase(Locale.US);
		final Class<? extends IXposedHookLoadPackage> appHook = appRegistry.get(packageLower);
		if (appHook != null)
		{
			appHook.newInstance().handleLoadPackage(param);
		}

	}

}
