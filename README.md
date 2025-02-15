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
---
### Toast Type
#### The main types you can set:  `MervToastType`

Type | Description
--------- | -----------
`𝙈𝙀𝙍𝙑_𝙏𝙔𝙋𝙀_𝙎𝙐𝘾𝘾𝙀𝙎𝙎` | Represents a success toast message, used to indicate that an action or operation was completed successfully. 
`𝙈𝙀𝙍𝙑_𝙏𝙔𝙋𝙀_𝙄𝙉𝙁𝙊` | Represents an informational toast message, typically used to provide general information or updates.
`𝙈𝙀𝙍𝙑_𝙏𝙔𝙋𝙀_𝙀𝙍𝙍𝙊𝙍`  | Represents an error toast message, used to indicate a failure or an issue that requires the user's attention.
`𝙈𝙀𝙍𝙑_𝙏𝙔𝙋𝙀_𝙒𝘼𝙍𝙉𝙄𝙉𝙂`  | Represents a warning toast message, used to indicate potential issues or important cautions that the user should be aware of.

---

### Using the library
Default Sample :
```
        MervToastMessage.with(this)
                .setToastType(MervToastType.MERV_TYPE_SUCCESS,SUCCESS_BOLD)
                .setText("b3ddo dEV' All Right Reserved.")
                .setTextColor(Color.WHITE)
                .setTextSize(15f)
                .setTextAllCaps(false)
                .setChooseFont(R.font.outfit_regular)
                .setIconAnimation(MervIconAnimationType.ICON_FADE_ANIMATION,500)
                .setGravity(MervGravityType.MERV_GRAVITY_CENTER)
                .setAnimation(MervAnimationType.MERV_FADE_ANIMATION,1000)
                .setScreenTime(3000)
                .setElevation(50) // Staying at 50 applies the Outline Spot Shadow Color
                .setRadius(20)
                .setStrokeWidth(2)
                .setStrokeColor(Color.WHITE)
                .setMargin(50,50,50,50)
                .setLayoutIdentification(R.id.main) // Sets the layout Identification to position the toast inside a custom layout.
                .setShowToastMessage();
```
---
### 🟢 Success Toast Message
<img src="https://github.com/b3ddodev/Merv-Toast-Message/blob/master/ToastMessageScreenShot/success.jpg?raw=true" width="100%"/>

```
        int mIconAnimationDuration = 500;
        int mToastAnimationDuration = 1000;

        MervToastMessage.with(this)
                .setToastType(MervToastType.MERV_TYPE_SUCCESS,SUCCESS_OUTLINE)
                .setText("Success Toast Message!")
                .setTextColor(Color.WHITE)
                .setTextSize(15f)
                .setTextAllCaps(false)
                .setChooseFont(R.font.outfit_regular)
                .setIconAnimation(MervIconAnimationType.ICON_FADE_ANIMATION,mIconAnimationDuration)
                .setGravity(MervGravityType.MERV_GRAVITY_CENTER)
                .setAnimation(MervAnimationType.MERV_FADE_ANIMATION , mToastAnimationDuration)
                .setScreenTime(3000)
                .setElevation(50)
                .setRadius(20)
                .setStrokeWidth(0)
                .setStrokeColor(Color.TRANSPARENT)
                .setMargin(50,50,50,50)
                //Optional .setLayoutIdentification(R.id.main)
                .setShowToastMessage();
```
---
### 🔴 Error Toast Message
<img src="https://github.com/b3ddodev/Merv-Toast-Message/blob/master/ToastMessageScreenShot/error.jpg?raw=true" width="100%"/>

```
	int mIconAnimationDuration = 500;
        int mToastAnimationDuration = 1000;

        MervToastMessage.with(this)
                .setToastType(MervToastType.MERV_TYPE_ERROR,ERROR_OUTLINE)
                .setText("Error Toast Message!")
                .setTextColor(Color.WHITE)
                .setTextSize(15f)
                .setTextAllCaps(false)
                .setChooseFont(R.font.outfit_regular)
                .setIconAnimation(MervIconAnimationType.ICON_FADE_ANIMATION,mIconAnimationDuration)
                .setGravity(MervGravityType.MERV_GRAVITY_CENTER)
                .setAnimation(MervAnimationType.MERV_FADE_ANIMATION , mToastAnimationDuration)
                .setScreenTime(3000)
                .setElevation(50)
                .setRadius(20)
                .setStrokeWidth(0)
                .setStrokeColor(Color.TRANSPARENT)
                .setMargin(50,50,50,50)
                //Optional .setLayoutIdentification(R.id.main)
                .setShowToastMessage();
```
---
### 🟡 Warning Toast Message
<img src="https://github.com/b3ddodev/Merv-Toast-Message/blob/master/ToastMessageScreenShot/warning.jpg?raw=true" width="100%"/>

```
        MervToastMessage.with(this)
                .setToastType(MervToastType.MERV_TYPE_WARNING,WARNING_OUTLINE)
                .setText("Warning Toast Message!")
                .setTextColor(Color.WHITE)
                .setTextSize(15f)
                .setTextAllCaps(false)
                .setChooseFont(R.font.outfit_regular)
                .setIconAnimation(MervIconAnimationType.ICON_FADE_ANIMATION,mIconAnimationDuration)
                .setGravity(MervGravityType.MERV_GRAVITY_CENTER)
                .setAnimation(MervAnimationType.MERV_FADE_ANIMATION , mToastAnimationDuration)
                .setScreenTime(3000)
                .setElevation(50)
                .setRadius(20)
                .setStrokeWidth(0)
                .setStrokeColor(Color.TRANSPARENT)
                .setMargin(50,50,50,50)
                //Optional.setLayoutIdentification(R.id.main) 
                .setShowToastMessage();
```
---
### 🔵 Info Toast Message
<img src="https://github.com/b3ddodev/Merv-Toast-Message/blob/master/ToastMessageScreenShot/info.jpg?raw=true" width="100%"/>

```
	int mIconAnimationDuration = 500;
        int mToastAnimationDuration = 1000;

        MervToastMessage.with(this)
                .setToastType(MervToastType.MERV_TYPE_INFO,INFO_OUTLINE)
                .setText("Info Toast Message!")
                .setTextColor(Color.WHITE)
                .setTextSize(15f)
                .setTextAllCaps(false)
                .setChooseFont(R.font.outfit_regular)
                .setIconAnimation(MervIconAnimationType.ICON_FADE_ANIMATION,mIconAnimationDuration)
                .setGravity(MervGravityType.MERV_GRAVITY_CENTER)
                .setAnimation(MervAnimationType.MERV_FADE_ANIMATION , mToastAnimationDuration)
                .setScreenTime(3000)
                .setElevation(50)
                .setRadius(20)
                .setStrokeWidth(0)
                .setStrokeColor(Color.TRANSPARENT)
                .setMargin(50,50,50,50)
                //Optional .setLayoutIdentification(R.id.main)
                .setShowToastMessage();
```
---

### 6 Icon Changes
#### Adjustable Icon Styles:

Type | Description | Image
--------- | ----------- | -----------
`𝘽𝙍𝙊𝙆𝙀𝙉` | **Broken Icon Type**: This icon style represents a "broken" or damaged version of the icon. It's often used to convey a sense of failure or a broken state. |  <img src="https://raw.githubusercontent.com/b3ddodev/Merv-Toast-Message/d0693d1bb94a2add18d7e89820f3e74c93a946c4/ToastMessageScreenShot/success/success_broken.svg" width="200%"/>
`𝙇𝙄̇𝙉𝙀𝘼𝙍` | **Linear Icon Type**: This icon uses a simple and clean linear design, typically featuring sharp lines and minimalistic elements. | <img src="https://raw.githubusercontent.com/b3ddodev/Merv-Toast-Message/d0693d1bb94a2add18d7e89820f3e74c93a946c4/ToastMessageScreenShot/success/success_linear.svg" width="200%"/>
`𝙏𝙒𝙊_𝙏𝙊𝙉𝙀` | **Two-Tone Icon Type**: This icon features two contrasting tones, creating a distinctive and visually appealing effect through color contrast. | <img src="https://raw.githubusercontent.com/b3ddodev/Merv-Toast-Message/d0693d1bb94a2add18d7e89820f3e74c93a946c4/ToastMessageScreenShot/success/success_two_tone.svg" width="200%"/>
`𝙊𝙐𝙏𝙇𝙄𝙉𝙀` | **Outline Icon Type**: The outline style icon focuses on the border of the design, with minimal interior detailing, often used for a more simplistic and modern appearance. | <img src="https://raw.githubusercontent.com/b3ddodev/Merv-Toast-Message/d0693d1bb94a2add18d7e89820f3e74c93a946c4/ToastMessageScreenShot/success/sucess_outline.svg" width="200%"/>
`𝘽𝙐𝙇𝙆` | **Bulk Icon Type**: This icon is thick and solid, giving a strong, bold visual impact. It is often used for attention-grabbing purposes. | <img src="https://raw.githubusercontent.com/b3ddodev/Merv-Toast-Message/d0693d1bb94a2add18d7e89820f3e74c93a946c4/ToastMessageScreenShot/success/sucess_outline.svg" width="200%"/>
`𝘽𝙊𝙇𝘿` | **Bold Icon Type**: The bold icon has a heavier weight, making it stand out more. It's ideal for highlighting important or emphasized elements. | <img src="https://raw.githubusercontent.com/b3ddodev/Merv-Toast-Message/d0693d1bb94a2add18d7e89820f3e74c93a946c4/ToastMessageScreenShot/success/success_bold.svg" width="200%"/>

<img src="https://github.com/b3ddodev/Merv-Toast-Message/blob/master/ToastMessageScreenShot/success/success_full_icon.jpg?raw=true" width="100%"/>

### Icon Style
```
    //Success Icon Style
   .setToastType(MervToastType.MERV_TYPE_SUCCESS,SUCCESS_BROKEN)
    or: -SUCCESS_LINEAR, SUCCESS_TWO_TONE, SUCCESS_OUTLINE, SUCCESS_BULK, SUCCESS_BOLD

    //Error Icon Style
   .setToastType(MervToastType.MERV_TYPE_ERROR,ERROR_BROKEN)
    or: -ERROR_LINEAR, ERROR_TWO_TONE, ERROR_OUTLINE, ERROR_BULK, ERROR_BOLD

    //Warning Icon Style
   .setToastType(MervToastType.MERV_TYPE_WARNING,WARNING_BROKEN)
    or: -WARNING_LINEAR, WARNING_TWO_TONE, WARNING_OUTLINE, WARNING_BULK, WARNING_BOLD

    //Info Icon Style
   .setToastType(MervToastType.MERV_TYPE_INFO,INFO_BROKEN)
    or: -INFO_LINEAR, INFO_TWO_TONE, INFO_OUTLINE, INFO_BULK, INFO_BOLD

```

---
### Icon Animation Type 
#### Major icon animations you can adjust: `MervIconAnimationType`

Type | Description
--------- | -----------
`𝙄𝘾𝙊𝙉_𝙀𝙈𝙋𝙏𝙔_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉` | The icon performs a simple animation with no movement or effects, effectively remaining static while appearing and disappearing.
`𝙄𝘾𝙊𝙉_𝙎𝙃𝘼𝙆𝙀_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉` | The icon shakes back and forth, usually with a slight left-right motion, to grab attention.
`𝙄𝘾𝙊𝙉_𝘽𝙀𝘼𝙏_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉`  | The icon performs a zoom-like effect, rapidly scaling up and down to give a pulsing beat effect.
`𝙄𝘾𝙊𝙉_𝙁𝘼𝘿𝙀_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉`  | The icon fades in and out smoothly without any directional movement, only changing opacity.
`𝙄𝘾𝙊𝙉_𝘽𝙀𝘼𝙏_𝙁𝘼𝘿𝙀_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉`  | The icon combines both zoom (beat) and fade effects, pulsing while fading in and out.

---
---
### Animation Type
#### Major animations you can adjust: `MervAnimationType`

Type | Description 
--------- | -----------
`𝙈𝙀𝙍𝙑_𝙇𝙀𝙁𝙏_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉` | The toast comes from the left side of the screen and exits to the right side 
`𝙈𝙀𝙍𝙑_𝙍𝙄𝙂𝙃𝙏_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉` | The toast comes from the right side of the screen and exits to the left side.
`𝙈𝙀𝙍𝙑_𝙁𝘼𝘿𝙀_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉`  | The toast fades in from transparency and fades out to transparency, without a directional movement.
`𝙈𝙀𝙍𝙑_𝙏𝙊𝙋_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉`  | The toast comes from the bottom of the screen and exits to the top.
`𝙈𝙀𝙍𝙑_𝘽𝙊𝙏𝙏𝙊𝙈_𝘼𝙉𝙄𝙈𝘼𝙏𝙄𝙊𝙉`  | The toast comes from the top of the screen and exits to the bottom.

---
### Features
#### There are several attributes you can set:

Set | Description
--------- | -----------
`.𝘀𝗲𝘁𝗧𝗼𝗮𝘀𝘁𝗧𝘆𝗽𝗲();` | This method configures the appearance of a toast message based on the specified type. Sets an icon, icon tint color, and background color based on predefined toast types such as Success, Error, Warning, and Information.
`.𝘀𝗲𝘁𝗧𝗲𝘅𝘁();` | This method is used to set the text of the toast message and supports method chaining for easier configuration.
`.𝘀𝗲𝘁𝗧𝗲𝘅𝘁𝗖𝗼𝗹𝗼𝗿 ();` | Text color settings of toast message with this method.
`.𝘀𝗲𝘁𝗧𝗲𝘅𝘁𝗦𝗶𝘇𝗲();` | This method adjusts the text size of the toast message.
`.𝘀𝗲𝘁𝗧𝗲𝘅𝘁𝗔𝗹𝗹𝗖𝗮𝗽𝘀();` | This method allows the text to be displayed in capital letters.
`.𝘀𝗲𝘁𝗖𝗵𝗼𝗼𝘀𝗲𝗙𝗼𝗻𝘁();` | This method sets the font of the toast message.
`.𝘀𝗲𝘁𝗜𝗰𝗼𝗻𝗔𝗻𝗶𝗺𝗮𝘁𝗶𝗼𝗻();` | This method allows customization of how the Icon is animated (e.g. Shake, Zoom, Fade).
`.𝘀𝗲𝘁𝗚𝗿𝗮𝘃𝗶𝘁𝘆();` | This method sets the gravity (positioning) of the toast message on the screen.
`.𝘀𝗲𝘁𝗔𝗻𝗶𝗺𝗮𝘁𝗶𝗼𝗻();` | This method sets the animation style of the toast message.
`.𝘀𝗲𝘁𝗦𝗰𝗿𝗲𝗲𝗻𝗧𝗶𝗺𝗲();` | This method sets the display duration of the toast message in milliseconds.
`.𝘀𝗲𝘁𝗘𝗹𝗲𝘃𝗮𝘁𝗶𝗼𝗻();` | This method sets the elevation (shadow) of the toast message, which determines how high it appears above the content on the screen.
`.𝘀𝗲𝘁𝗥𝗮𝗱𝗶𝘂𝘀();` |  This method sets the corner radius for the toast message, allowing you to create rounded corners.
`.𝘀𝗲𝘁𝗦𝘁𝗿𝗼𝗸𝗲𝗪𝗶𝗱𝘁𝗵();` |  This method sets the stroke width for the border of the toast message, allowing you to adjust the thickness of the border line.
`.𝘀𝗲𝘁𝗦𝘁𝗿𝗼𝗸𝗲𝗖𝗼𝗹𝗼𝗿();` |  This method sets the color of the border for the toast message, allowing you to customize the border's appearance.
`.𝘀𝗲𝘁𝗠𝗮𝗿𝗴𝗶𝗻();` | This method sets the margins for the toast message. You can define the start, top, end, and bottom margins to control the spacing around the toast message.
`.𝘀𝗲𝘁𝗟𝗮𝘆𝗼𝘂𝘁𝗜𝗱𝗲𝗻𝘁𝗶𝗳𝗶𝗰𝗮𝘁𝗶𝗼𝗻();` | If there is an AppBar or Toolbar, this method can take that layout ID and show the toast message above or below that layout. That is, the toast message is not positioned directly at the top of the screen, but according to the layout you specify.

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
