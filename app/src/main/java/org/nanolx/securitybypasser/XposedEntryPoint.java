package org.nanolx.securitybypasser;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import org.nanolx.securitybypasser.apps.Miitomo;
import org.nanolx.securitybypasser.apps.YokaiWatchWW;
import org.nanolx.securitybypasser.apps.YokaiWatchWWEU;

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
		appRegistry.put("com.nintendo.zaaa", Miitomo.class);
		appRegistry.put("com.level5.ywwwus", YokaiWatchWW.class);
		appRegistry.put("com.level5.ywpeu", YokaiWatchWWEU.class);
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
