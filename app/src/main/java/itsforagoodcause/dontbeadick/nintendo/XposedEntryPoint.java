package itsforagoodcause.dontbeadick.nintendo;
import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.*;
import de.robv.android.xposed.XC_MethodHook.*;
import android.app.*;

public class XposedEntryPoint implements IXposedHookLoadPackage
{

	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam param) throws Throwable
	{
		if (!param.packageName.equalsIgnoreCase("com.nintendo.zaaa"))
		{
			return;
		}
		XposedBridge.log("Miitomo Security bypasser: Entering Miitomo... Ready... Set... GO!");
		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController", param.classLoader, "ahS", new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable
				{
					// TODO: Implement this method
					XposedBridge.log("Miitomo Security bypasser: Nintendo is trying to stop us, but I won't let it happen! (Hooked SecureController.ZD())");
					return null;
				}


			});
			
		XposedHelpers.setStaticBooleanField(XposedHelpers.findClass("jp.co.nintendo.android.archdev.BuildConfig", param.classLoader), "DEBUG", true);

		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController", param.classLoader, "ahT", new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable
				{
					// TODO: Implement this method
					XposedBridge.log("Miitomo Security bypasser: It's debug time! (Set BuildConfig.DEBUG to true)");
					return null;
				}


			});
			
		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController", param.classLoader, "L", Activity.class, new XC_MethodReplacement(){
				@Override
				protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable
				{
					// TODO: Implement this method
					XposedBridge.log("Miitomo Security bypasser: Nintendo, I'm afraid I can't let you do that... (Hooked SecureController.L())");
					return null;
				}


		});
		
		XposedHelpers.findAndHookMethod("jp.co.nintendo.v", param.classLoader, "dp", boolean.class, new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Miitomo Security bypasser: All you logcat output are belong to us! (Trying to catch v.dp(), logcat output should be available now!)");
					return null;
				}

		});

		XposedHelpers.findAndHookMethod("jp.co.nintendo.NativeSystem", param.classLoader, "nativeAbort", new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Miitomo Security bypasser: Don't leave mii! (Trying to catch NativeSystem.nativeAbort())");
					return null;
				}


		});
		
		XposedHelpers.findAndHookMethod("jp.co.nintendo.SecureController", param.classLoader, "checkEmulator", new XC_MethodReplacement(){

				@Override
				protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam p1) throws Throwable
				{
					XposedBridge.log("Miitomo Security bypasser: Mii a emulator? Nope! (Hooked SecureController.checkEmulator())");
					return false;
				}


			});
	}


}
