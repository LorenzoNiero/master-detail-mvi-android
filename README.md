# master-detail-mvi-android

## Overview

todo

## Getting Started
To run the app locally, follow these steps:

1. Clone this repository.
2. Open the project in Android Studio
3. Select build variant *devDebug* in *app* module
4. Build and run the app on an Android emulator or device.

**Requirements:**

-I used Android Studio Meerkat | 2024.3.1 Patch 1  
-I have used a emulator "Pixel 7" to reference with Android api level 35  
-I used a real Pixel 7 with Android 15 api level 35 and a Galaxy A21s with Android 12 api level 32

## Modularazition
The app follows an implementation of mudularazition by features:
TODO

## Architecture and library used
The app follow this components:
- Project use **MVI** architecture and Clean architecture;
- divided project in sub-module;
- used Jetpack **Compose** and **Material Design 3**;
- **Retrofit** to request network;
- **Flow** to manage change state of data;
- **Hilt/Dagger** for dependency injection;
- **Mockk** to mock data on unit test

## Testing

The project includes unit tests for the network, domain, and data modules.
You can find them in the respective module directories.

Execute all unit test witu:

```
gradle testDevDebugUnitTest
```

```
./gradlew testDevDebugUnitTest
```