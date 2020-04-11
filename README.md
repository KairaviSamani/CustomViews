# CustomLibrary

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency
	
	implementation 'com.github.KairaviSamani:CustomViews:1.0.0'

How to use?

	<com.example.customviewlibrary.CustomTextView
        	android:layout_width="wrap_content"
        	android:layout_height="wrap_content"
        	android:text="Hello World!!"
        	app:custom_borderWidth="1dp"
        	app:custom_borderColor="@android:color/holo_blue_dark"
        	app:custom_radius="5dp"
		app:custom_background="@android:color/holo_blue_light"/>

