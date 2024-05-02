import SwiftUI
import Shared

struct ContentView: View {
    let greet = Greeting().greet()

	var body: some View {
		Text(greet)
	}
}
