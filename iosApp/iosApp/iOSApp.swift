import SwiftUI

@main
struct iOSApp: App {
init(){
KoinKt.setupKoin()
}
    init(){
       FirebaseApp.configure()
     }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
