# proguard-rules.pro
# Add any project specific ProGuard rules here.
# For more information see the official documentation:
# http://developer.android.com/tools/help/proguard.html

# If your project uses the Android Support Library, you probably don't
# need to specify any additional ProGuard rules, since the support
# library already defines and includes its own ProGuard rules.
#
# For example, to ensure the ObfuscatedStringUtility class is not obfuscated
# -keep class com.example.stringfogexample.ObfuscatedStringUtility { *; }

# Example to keep resource names (less relevant for string *content* obfuscation)
# -keepclassmembers class **.R$* {
#    public static <fields>;
# }

    # Add this global rule
    -keepattributes Signature

    # This rule will properly ProGuard all the model classes in
    # the package com.yourcompany.models.
    # Modify this rule to fit the structure of your app.
    -keepclassmembers class com.github.debacodex.model.** {
      *;
    }