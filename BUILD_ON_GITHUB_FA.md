# ساخت APK نسخه 2.0 با GitHub Actions

1. در GitHub یک Repository جدید بسازید.
2. فایل `bazaar_android_native_2_0.zip` را از حالت ZIP خارج کنید.
3. تمام محتویات پوشه `bazaar_android_native_2_0` را داخل Repository قرار دهید؛ پوشه `.github` را هم حتماً منتقل کنید.
4. Commit/Push کنید.
5. در GitHub وارد بخش **Actions** شوید.
6. workflow با نام **Build Bazaar APK** را انتخاب کنید.
7. روی **Run workflow** بزنید.
8. پس از پایان موفق Build، وارد اجرای همان workflow شوید.
9. در پایین صفحه بخش **Artifacts** را باز کنید.
10. فایل `Bazaar-2.0-release-APK` را دانلود و از حالت ZIP خارج کنید.
11. فایل `app-release.apk` همان APK قابل نصب است.

این روش برای Build نسخه Android Native است و Flutter لازم ندارد.
