#include <jni.h>
#include <string>
#include "PrimeNumber.h"

extern "C"
JNIEXPORT jboolean

JNICALL
Java_com_metroinfrasys_nativeapp_MainActivity_isPrime(
        JNIEnv *env,
        jobject /* this */,jint number) {
    PrimeNumber primeNumber(number);
    return primeNumber.isPrime();
}
