# بازارچه 2.0 — Android Native

این نسخه دیگر به Flutter وابسته نیست. پروژه یک Android Native (Java) است که رابط بازارچه را از `assets/index.html` داخل WebView اجرا می‌کند.

## ساخت APK
- Android Studio: پروژه را باز کنید و `Build > Generate App Bundles or APKs > Generate APKs` را بزنید.
- خط فرمان: `./gradlew assembleRelease`
- خروجی: `app/build/outputs/apk/release/app-release.apk`

## مشخصات
- applicationId: `com.bazaar.bazaar`
- versionName: `2.0.0`
- versionCode: `20`
- compileSdk/targetSdk: `36`
- حداقل Android: API 23

این نسخه برای ساخت آنلاین/سرور آماده است و Flutter لازم ندارد. برای امکانات واقعاً چنددستگاهی مانند چت رمزنگاری‌شده، ورود/بازیابی رمز با SMS/Email و ذخیره بنر/آهنگ روی همه دستگاه‌ها، Backend لازم است.
