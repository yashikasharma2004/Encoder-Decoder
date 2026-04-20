# 🔐 Secret Message App

A simple Android app built with **Jetpack Compose** that lets you encode and decode secret messages using character shifting.

## ✨ Features
- 🔒 **Encode** — Convert your text into a secret message
- 🔓 **Decode** — Convert secret message back to original text
- 🗑️ **Clear** — Reset everything in one click
- 📋 **Copy Result** — Long press to copy the output

## 🛠️ Built With
- Kotlin + Jetpack Compose + Material 3

## 🚀 How To Run
1. Clone this repo `git clone https://github.com/YOUR_USERNAME/SecretMessageApp.git`
2. Open in Android Studio
3. Add any image in `res/drawable` named `img`
4. Run on emulator or device ▶️

## 🔧 How It Works
| Action | Logic |
|--------|-------|
| Encode | ASCII value shifted by **+2** |
| Decode | ASCII value shifted by **-2** |

## 📜 License
MIT License
