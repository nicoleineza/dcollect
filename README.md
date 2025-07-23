# dcollect
dcollect is a kotlin mobile application field officers use to record basic information about farmers they visit
# Farmer Registration App

An offline-first Android app for agricultural field officers to register farmer information in rural areas. The app collects:
- Farmer name
- ID number
- Crop type
- Registration date

All data is stored locally on the device using Room database, requiring no internet connection.

Architecture Summary
- MVVM Architecture: Clean separation between UI, business logic, and data
- Offline-First: Room database provides robust local storage
- Single Source of Truth: Repository pattern centralizes data access
- Modern UI: Built with Jetpack Compose for responsive interfaces
- Material 3: Follows latest design guidelines with proper theming

 Future Sync Strategy
To add server synchronization later:
1. Implement API interface for remote server communication
2. Extend Repository to handle both local and remote data sources
3. Add WorkManager for periodic background sync
4. Implement conflict resolution strategy
5. Add network availability checks before sync attempts
6. Include retry mechanism for failed syncs
7. Add sync status indicators in UI


 Dependencies
- Android SDK 34
- Jetpack Compose
- Room Database
- Kotlin Coroutines
