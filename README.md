##  Merv Toast Message  
### 🚀 Merv Toast Message takes your toast messages to the next level – stylish, fast, and customizable!

-----------------------------------------------------------------------------------------------------------------------------------------------

[![Platform](https://img.shields.io/badge/Platform-Android-brightgreen.svg?style=flat)](https://www.android.com/)
[![](https://jitpack.io/v/b3ddodev/Merv-Toast-Message.svg)](https://jitpack.io/#b3ddodev/Merv-Toast-Message)
[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=24)

### Jitpack

Add the JitPack repository to your `settings.gradle` file
```groovy
allprojects {
	repositories {
		...
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}
```
### Dependency
Add the dependency in your `build.gradle`

```groovy
dependencies {
    implementation 'com.github.b3ddodev:Merv-Toast-Message:{release-version}'   
}
```
### Using the library
Empty Sample :
```
MervToastMessage.with(this).setToastType()
                .setText()
                .setTextSize()
                .setTextColor()
                .setFont()
                .setGravity()
                .setAnimation()
                .setAnimationDuration()
                .setScreenTime()
                .setRadius()
                .setLayoutID()
                .setMargin()
                .setMervShow();
```

-----------------------------------------------------------------------------------------------------------------------------------------------
### 🟢 Success Toast Message

<img src="https://github.com/b3ddodev/Merv-Toast-Message/blob/master/ToastMessageScreenShot/success.jpg?raw=true" width="100%"/>

```
 MervToastMessage.with(this)
                .setToastType(MervToastMessage.MERV_TYPE_SUCCESS)
                .setText("Success Toast Message!")
                .setTextSize(15f)
                .setTextColor(getColor(R.color.white))
                .setFont(R.font.poppins)
                .setGravity(MervToastMessage.MERV_GRAVITY_CENTER)
                .setAnimation(MervToastMessage.MERV_FADE_ANIMATION)
                .setAnimationDuration(500)
                .setScreenTime(2000)
                .setRadius(20)
                .setMargin(50, 0, 50, 0)
                .setMervShow();
```

-----------------------------------------------------------------------------------------------------------------------------------------------
### 🔵 Info Toast Message

<img src="https://github.com/b3ddodev/Merv-Toast-Message/blob/master/ToastMessageScreenShot/info.jpg?raw=true" width="100%"/>

```
  MervToastMessage.with(this)
                .setToastType(MervToastMessage.MERV_TYPE_INFO)
                .setText("Info Toast Message!")
                .setTextSize(15f)
                .setTextColor(getColor(R.color.white))
                .setFont(R.font.poppins)
                .setGravity(MervToastMessage.MERV_GRAVITY_CENTER)
                .setAnimation(MervToastMessage.MERV_FADE_ANIMATION)
                .setAnimationDuration(500)
                .setScreenTime(2000)
                .setRadius(20)
                .setMargin(50, 0, 50, 0)
                .setMervShow();
```

### 🔴 Error Toast Message

<img src="https://github.com/b3ddodev/Merv-Toast-Message/blob/master/ToastMessageScreenShot/error.jpg?raw=true" width="100%"/>

```
  MervToastMessage.with(this)
                .setToastType(MervToastMessage.MERV_TYPE_ERROR)
                .setText("Error Toast Message!")
                .setTextSize(15f)
                .setTextColor(getColor(R.color.white))
                .setFont(R.font.poppins)
                .setGravity(MervToastMessage.MERV_GRAVITY_CENTER)
                .setAnimation(MervToastMessage.MERV_FADE_ANIMATION)
                .setAnimationDuration(400)
                .setScreenTime(2000)
                .setRadius(20)
                .setMargin(50, 0, 50, 0)
                .setMervShow();
```

-----------------------------------------------------------------------------------------------------------------------------------------------
### 🟡 Warning Toast Message

<img src="https://github.com/b3ddodev/Merv-Toast-Message/blob/master/ToastMessageScreenShot/warning.jpg?raw=true" width="100%"/>

```
   MervToastMessage.with(this)
                .setToastType(MervToastMessage.MERV_TYPE_WARNING)
                .setText("Warning Toast Message!")
                .setTextSize(15f)
                .setTextColor(getColor(R.color.white))
                .setFont(R.font.poppins)
                .setGravity(MervToastMessage.MERV_GRAVITY_CENTER)
                .setAnimation(MervToastMessage.MERV_FADE_ANIMATION)
                .setAnimationDuration(500)
                .setScreenTime(2000)
                .setRadius(20)
                .setMargin(50, 0, 50, 0)
                .setMervShow();
```

-----------------------------------------------------------------------------------------------------------------------------------------------
### Animation Type
### Major animations you can adjust:

Type | Description
--------- | -----------
`𝙈𝙀𝙍𝙑_𝙇𝙀𝙁𝙏_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉` | The toast comes from the left side of the screen and exits to the right side 
`𝙈𝙀𝙍𝙑_𝙍𝙄𝙂𝙃𝙏_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉` | The toast comes from the right side of the screen and exits to the left side.
`𝙈𝙀𝙍𝙑_𝙁𝘼𝘿𝙀_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉`  | The toast fades in from transparency and fades out to transparency, without a directional movement.
`𝙈𝙀𝙍𝙑_𝙏𝙊𝙋_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉`  | The toast comes from the bottom of the screen and exits to the top.
`𝙈𝙀𝙍𝙑_𝘽𝙊𝙏𝙏𝙊𝙈_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉`  | The toast comes from the top of the screen and exits to the bottom.

-----------------------------------------------------------------------------------------------------------------------------------------------
### Toast Type
### The main types you can set:

Type | Description
--------- | -----------
`𝙈𝙀𝙍𝙑_𝙏𝙔𝙋𝙀_𝙎𝙐𝘾𝘾𝙀𝙎𝙎` | Represents a success toast message, used to indicate that an action or operation was completed successfully. 
`𝙈𝙀𝙍𝙑_𝙏𝙔𝙋𝙀_𝙄𝙉𝙁𝙊` | Represents an informational toast message, typically used to provide general information or updates.
`𝙈𝙀𝙍𝙑_𝙏𝙔𝙋𝙀_𝙀𝙍𝙍𝙊𝙍`  | Represents an error toast message, used to indicate a failure or an issue that requires the user's attention.
`𝙈𝙀𝙍𝙑_𝙏𝙔𝙋𝙀_𝙒𝘼𝙍𝙉𝙄𝙉𝙂`  | Represents a warning toast message, used to indicate potential issues or important cautions that the user should be aware of.

### Features
### There are several attributes you can set:
-----------------------------------------------------------------------------------------------------------------------------------------------
Set | Description
--------- | -----------
`𝘀𝗲𝘁𝗧𝗼𝗮𝘀𝘁𝗧𝘆𝗽𝗲();` | This method configures the appearance of a toast message based on the specified type. Sets an icon, icon tint color, and background color based on predefined toast types such as Success, Error, Warning, and Information.
`𝘀𝗲𝘁𝗧𝗲𝘅𝘁();` | This method is used to set the text of the toast message and supports method chaining for easier configuration.
`𝘀𝗲𝘁𝗧𝗲𝘅𝘁𝗖𝗼𝗹𝗼𝗿 ();` | Text color settings of toast message with this method.
`𝘀𝗲𝘁𝗧𝗲𝘅𝘁𝗦𝗶𝘇𝗲();` | This method adjusts the text size of the toast message.
`𝘀𝗲𝘁𝗙𝗼𝗻𝘁();` | This method sets the font of the toast message.
`𝘀𝗲𝘁𝗚𝗿𝗮𝘃𝗶𝘁𝘆();` | This method sets the gravity (positioning) of the toast message on the screen.
`𝘀𝗲𝘁𝗔𝗻𝗶𝗺𝗮𝘁𝗶𝗼𝗻();` | This method sets the animation style of the toast message.
`𝘀𝗲𝘁𝗦𝗰𝗿𝗲𝗲𝗻𝗧𝗶𝗺𝗲();` | This method sets the display duration of the toast message in milliseconds.
`𝘀𝗲𝘁𝗔𝗻𝗶𝗺𝗮𝘁𝗶𝗼𝗻𝗗𝘂𝗿𝗮𝘁𝗶𝗼𝗻();` | This method sets the duration of the animation for the toast message.
`𝘀𝗲𝘁𝗥𝗮𝗱𝗶𝘂𝘀();` | This method sets the corner radius for the toast message, allowing you to create rounded corners.
`𝘀𝗲𝘁𝗟𝗮𝘆𝗼𝘂𝘁𝗜𝗗();` | If there is an AppBar or Toolbar, this method can take that layout ID and show the toast message above or below that layout. That is, the toast message is not positioned directly at the top of the screen, but according to the layout you specify.
`𝘀𝗲𝘁𝗘𝗹𝗲𝘃𝗮𝘁𝗶𝗼𝗻();` | This method sets the elevation (shadow) of the toast message, which determines how high it appears above the content on the screen.
`𝘀𝗲𝘁𝗠𝗮𝗿𝗴𝗶𝗻();` | This method sets the margins for the toast message. You can define the start, top, end, and bottom margins to control the spacing around the toast message.

-----------------------------------------------------------------------------------------------------------------------------------------------

[![Instagram Badge](https://img.shields.io/badge/Instagram-%20%40b3ddo.dev-brightgreen)](https://www.instagram.com/b3ddo.dev)


## License

```
The MIT License (MIT)

Copyright (c) 2025 b3ddo dEV' (github.com/b3ddodev)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
