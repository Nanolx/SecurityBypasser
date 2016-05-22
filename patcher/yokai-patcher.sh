#!/bin/bash

version=1.1.0
reldate=2016/05/22

basedir=$(readlink -m "${BASH_SOURCE[0]}")
basedir=$(dirname ${basedir})
rootdir="${PWD}"

_error () {
	echo "${1}"
	exit 1
}

_build () {

	if [[ -f ${1} && ${1} == *.apk ]]; then

		rm -rf ${rootdir}/build-yokai

		which xdelta &>/dev/null || _error "xdelta not installed!"
		xdelta=$(which xdelta)

		source="${1}"
		sourceapk=$(basename "${source}")
		sourcedir=$(basename "${source}" .apk)

		mkdir ${rootdir}/build-yokai
		cp "${source}" ${rootdir}/build-yokai
		cd ${rootdir}/build-yokai
		${apktool} ${apktoolparams} \
			d "${sourceapk}" || _error "apktool failed!"

		for arch in armeabi armeabi-v7a x86; do
			${xdelta} patch "${basedir}"/delta/com.level5.ywwwus/libSGF-${arch}.delta \
				"${sourcedir}"/lib/${arch}/libSGF.so libSGF-mod.so || _error "xdelta failed!"

			mv libSGF-mod.so "${sourcedir}"/lib/${arch}/libSGF.so
		done

		${apktool} ${apktoolparams} \
			b "${sourcedir}" \
			-o Yokai-Root.apk || _error "apktool failed!"

		cp -r "${sourcedir}/original/META-INF" .
		zip -r Yokai-Root.apk META-INF/ || _error "zip failed!"

		echo -e "
Modified apk stored as

		${rootdir}/build-yokai/Yokai-Root.apk

copy to your device and install or issue

		adb install [-r] ${rootdir}/build-yokai/Yokai-Root.apk

if your device is connected to your computer.
"
	else	_error "file ${1} does not exist."
	fi

}

case ${1} in

	*alt )	apktool=${basedir}/apktool
		apktoolparams="-p ${basedir}/framework"
		build "${1}"	;;

	*.apk )	which apktool &>/dev/null || _error "apktool not installed!"
		apktool=$(which apktool)
		apktoolparams=""
		build "${1}"	;;

	* )	echo -e "Yokai Watch Wibble Wobble (US) root patcher

version ${version} (${reldate})
usage:
	patcher.sh <yokaiwatch.apk>
	patcher.sh --alt <yokaiwatch.apk>

option:
	--alt	[use alternative framework and apktool]
	--help	[show this message]
"	;;

esac
