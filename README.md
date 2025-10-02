# BlueEnglish - English Learning App 📚

A beautiful and interactive Android application built with Kotlin to help users learn English through various exercises and resources.


## 🛠️ Tech Stack & Badges

<div >

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![MVVM](https://img.shields.io/badge/Architecture-MVVM-FF6D00?style=for-the-badge)
![Room](https://img.shields.io/badge/Database-Room-4285F4?style=for-the-badge)
</div>


## 🌟 Features

### 🔤 Irregular Verbs Practice
- **Random Verb Generator**: Get random irregular verbs with their different forms
- **Complete Verb Information**: 
  - Infinitive form
  - Past tense
  - Past participle
  - Spanish translation
  - Usage examples in both English and Spanish
- **Interactive Interface**: Simple tap-to-next functionality

### 📝 Phrasal Verbs Library
- **Comprehensive List**: Extensive collection of phrasal verbs
- **Detailed Information**:
  - Phrasal verb form
  - Meaning/definition
  - Example sentences in English and Spanish
- **Bottom Sheet Details**: Tap any phrasal verb to see detailed information in an elegant bottom sheet

### 💭 Personal Phrase Book
- **Create & Manage**: Add your own English phrases and expressions
- **Room Database**: Local storage with Room persistence library
- **CRUD Operations**:
  - **Create**: Add new phrases with titles and definitions
  - **Read**: Browse all saved phrases
  - **Update**: Edit existing phrases
  - **Delete**: Remove phrases with confirmation dialog
- **Navigation**: Smooth navigation between list, add, and edit screens

### 🎵 Immersive Experience
- **Background Music**: Classical music ambiance for focused learning
- **Lifecycle Management**: Proper media player handling across app states
- **Fullscreen Splash**: Engaging launch experience

## 🏗 Architecture & Patterns

### MVVM Architecture
- **ViewModels**: 
  - `MyViewModelRoom` - Manages phrase data with Room
  - `MyViewmodelVI` - Handles irregular verbs logic
  - `MyViewmodelPhrasal` - Manages phrasal verbs data
- **LiveData**: Reactive data observation for UI updates
- **Lifecycle Awareness**: Proper lifecycle management with Android Lifecycle components

### Data Layer
- **Room Database**: Local SQLite database for user phrases
- **JSON Assets**: Static data for verbs loaded from JSON files
- **Repository Pattern**: Clean separation through use cases

### UI Components
- **RecyclerViews**: Efficient list displays for topics and phrases
- **Fragments**: Modular UI components for phrase management
- **Navigation Component**: Jetpack Navigation for smooth transitions
- **BottomSheetDialog**: Interactive details display

## 🎨 User Interface

### Main Topics Screen
- Clean card-based layout
- Four main learning categories:
  1. Most Used Words
  2. Phrasal Verbs
  3. Add Your Phrases
  4. Irregular Verbs

### Consistent Design Language
- Material Design components
- Responsive layouts
- Intuitive navigation patterns
- Visual feedback for user interactions

## 🔧 Technical Implementation

### Dependencies & Libraries
- **Android Jetpack**:
  - Lifecycle & ViewModel
  - Room Database
  - Navigation Component
  - LiveData
- **Kotlin Coroutines**: For background operations
- **Gson**: JSON parsing for static data

### Data Models
- `IrregularVerbsDataItem` - Irregular verb structure
- `PharsalDataItem` - Phrasal verb information
- `PhraseRoom` - User-generated phrases with Room annotations
- `TopicsData` - Main navigation topics

### Key Features Implementation
- **Media Management**: Background music with proper lifecycle handling
- **Data Validation**: Input checks for phrase creation/editing
- **Error Handling**: User-friendly error messages and validations
- **State Preservation**: Maintains state during configuration changes

## 🚀 Getting Started

### Prerequisites
- Android Studio
- Minimum SDK: 21+ (Android 5.0)
- Kotlin support

### Installation
1. Clone the repository
2. Open in Android Studio
3. Build and run on emulator or device
4. The app includes all necessary assets and data files

## 📱 Usage Guide

1. **Start with Splash Screen** - Beautiful fullscreen introduction
2. **Choose Learning Category** - Select from four main options
3. **Irregular Verbs** - Tap "Next" to cycle through random verbs
4. **Phrasal Verbs** - Scroll through list and tap for details
5. **Personal Phrases** - Create, read, update, and delete your own phrases
6. **Background Music** - Enjoy classical ambiance while learning

## 🎯 Learning Outcomes

This app helps English learners with:
- Irregular verb conjugation mastery
- Phrasal verb understanding and usage
- Personal vocabulary building
- Contextual learning through examples
- Consistent practice through engaging interface

---

*BlueEnglish - Making English learning beautiful and effective through technology* ✨
