# ShakeSplash 🎨📱

ShakeSplash is a simple Android app that changes the background color every time you shake your device.  
It uses the **accelerometer sensor** to detect shake motion and generates a random color dynamically.

---

## 📌 Features
- Detects device shake using the accelerometer sensor.
- Changes background color randomly on shake.
- Adjustable sensitivity threshold.
- Lightweight and easy to use.

---

## 🛠️ How It Works
1. **Sensor Setup**  
   The app uses `SensorManager` to access the device's accelerometer (`TYPE_ACCELEROMETER`).

2. **Shake Detection**  
   - Calculates the speed of motion based on changes in X, Y, Z accelerometer values.
   - If the speed exceeds the defined threshold, it triggers a background color change.

3. **Color Change**  
   Generates a random RGB color using the `Random` class and updates the `ConstraintLayout` background.

---

## 📂 Project Structure
```bash
app/
├── java/com/example/myapplication1/MainActivity.java  # Main activity with shake detection logic
├── res/layout/activity_main.xml                       # UI layout with a simple TextView
├── AndroidManifest.xml                                # App manifest
```
---

## 🚀 Getting Started

### Prerequisites
- **Android Studio** (latest version recommended)
- **Android SDK 21+**
- A physical Android device or emulator **with accelerometer support**

### Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/Lucid-Lifo/ShakeSplash.git
2. **Open the project in Android Studio.**
3.**Build and run the app on your device or emulator.**
   
---
## ⚙️ Configuration
You can adjust the shake sensitivity by modifying the threshold value in MainActivity.java:
```bash
   threshold = 800; // Lower value = more sensitive
```
---
