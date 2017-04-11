Supporting Yokai Watch Wibble Wobble (US/EU) was a rather tricky task
and consists of two parts:

- Xposed Override: The easy one, Xposed Module overrides checkRoot() and h()
- Modified libSGF: The hard one, we need to remove all references to "su" from the libSGF library

## Linux only: Automated modification of the libSGF library

1. First download the Wibble Wobble apk file.
1. You need to have xdelta and zip installed.
1. Using automated patcher:
    - In the directory [patcher](patcher) you'll find the script [yokai-patcher](patcher/yokai-patcher)
    - Execute it and give the name of the apk file as argument, for example:

            ./patcher/yokai-patcher --us /home/user/YokaiWatchWibbleWobble.apk

for the US version, or for the EU version:

            ./patcher/yokai-patcher --eu /home/user/YokaiWatchWibbleWobble.apk

1. If everything goes fine, the script will tell you that it succeeded and where
the new Yokai-Root.apk is stored.

1. Copy this apk to your device and install it (or install using adb).

## All Operating Systems: Manual Methods

To modify the library there are three ways.

1. But first download the Wibble Wobble apk file and extract it,  you'll find the library in

        <apkfilename>/lib/<architecture>/libSGF.so

    If you encounter issues with apktool, try the supplied one the [patcher](patcher) directory.

1. Now do one of the following *A*, *B*, or *C* sub-sections.
1. After that:
1. Use the modified library to replace the original one in

        <apkfilename>/lib/<architecture>/libSGF.so

1. Rebuild the apk file using apktool

        apktool b <apkfilename>/

1. Open the new apk located in

        <apkfilename>/dist/<apkfilename>.apk

1. With a zip program, copy the

        META-INF/

    folder from

        <apkfilename>/original/

    into the new apk.

1. Copy this apk to your device and install.
1. Now start Yokai Watch Wibble Wobble on your rooted phone.


#### A) Using xdelta patches
In the directory patcher/delta/com.level5.ywwwus you'll find xdelta patches for US version,
in the directory patcher/delta/com.level5.ywpeu you'll find the xdelta patches for EU version

        xdelta3 -d -s -f <original-lib> <delta-patch> <modified-lib>

   for example with the armeabi libSGF:

        xdelta3 -d -s -f libSGF.so libSGF-armeabi.delta libSGF-mod.so

   with the armeabi-v7a libSGF:

        xdelta3 -d -s -f libSGF.so libSGF-armeabi-v7a.delta libSGF-mod.so

   or with the x86 libSGF:

        xdelta3 -d -s -f libSGF.so libSGF-x86.delta libSGF-mod.so

afterwards replace the original libSGF.so with libSGF-mod.so

If xdelta3 is not available on your system, you'll find 32 and 64 bit versions in
the directory [patcher](patcher).

#### B) Command line editor
Use Vim, Emacs, or whatever text editor you prefer. Simply open the library and
search for all instances of "su" and replace the two letters with something
different like "st".

**BUT** you must not change the length of the string, else you'll destroy the library.

**Also** don't change anything where "su" is just part of another word like "result"
or whatever (that should be obvious, but still).

#### C) Hex editor
Open the library in a hex editor and change the hexcodes for all instances of "su"
and replace the two letters with something different like "st".

**BUT** you must not change the length of the string, else you'll destroy the library.

**Also** don't change anything where "su" is just part of another word like "result"
or whatever (that should be obvious, but still).
