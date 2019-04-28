# NewsFeed App

# App Workflow

After launching the app, we hit one API:  https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json

# Happy Path or Success Case

This can be thought of as a use case: Network Available

It will start fetching the data from server and display loading icon. This icon will be hidden after receiving the response.
This list will be presented beautifully with News Feed.

# Sad Path or Failure Case

This can be thought of as a use case: No Network

User will be presented with an Error screen with a retry button.
If the user clicks on retry, it will show an alert dialog asking the user to turn-on Wi-Fi.
When the user clicks on Turn on button, the app will start fetching data from server again.

# Specs
Language: Kotlin </br>
Architecture: MVVM </br>
Network Calls: Retrofit, RxJava/RxAndroid </br>
Logging Network Calls: OkHttp/HttpLoggingInterceptor </br>
Image Processing: Glide </br>
Layout: ConstraintLayout </br>

# YouTube Video
Find the demo app video: https://youtu.be/PKFNqXWyDZY
