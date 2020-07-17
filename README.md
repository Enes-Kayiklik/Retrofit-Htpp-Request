# Retrofit-Http-Request
> Kotlin MVVM Htpp Request Using Retrofit

***Sample MVVM Architecture***

[![Sample MVVM Architecture](https://androidwave.com/wp-content/uploads/2019/05/mvvm-architecture-app-in-android.png)]()

## build.gradle (Module.app) Implementation

```kotlin
     ...
     
    //Retrofit
    def retrofit_version = "2.6.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"

    //Coroutine
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7"

    def lifecycle_version = "2.2.0"
    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"

    //Glide (Picasso Alternative)
    def glide_version = "4.11.0"
    implementation "com.github.bumptech.glide:glide:$glide_version"

    //Recycler View
    def recycler_view_version = "1.1.0"
    implementation "androidx.recyclerview:recyclerview:$recycler_view_version"

    //Card View
    def card_view_version = "1.0.0"
    implementation "androidx.cardview:cardview:$card_view_version"
```

---

> Nasıl implement ederim ?

<img src="/images/implemetation.gif"/> 

***Package Architecture***

<img src="/images/retrofitPackageYapısı.png"/> 

> Sample screen

<img src="/images/retrofitOutput.png" width="500"/> 

> Retrofit MVVM Architecture ile ilgili <a href="https://medium.com/hardwareandro/android-kotlin-retrofit-2-kurulumu-ve-http-request-mvvm-1-832e6cdd5bf5" target="_blank">`Makalem`</a>
