# Cordova KillApp Plugin

Simple plugin that lets you exit or restart an android process using `android.os.Process.killProcess(android.os.Process.myPid());`. Restarts happen using `PendingIntent`.  

Useful where `navigator.app.exitApp();` might not work. Also useful if your app needs to reset and start from the Initail Activity. 

## Usage

#### 1. Create a new Cordova Project

    $ cordova create hello com.example.helloapp Hello
    
#### 2. Install the plugin

    $ cd hello
    $ cordova plugin install https://github.com/srivathsa-dhanraj/cordova-plugin-KillApp
	    

#### 3. HTML
Edit `www/index.html` and add the following code inside `<HEAD></HEAD>`

    <script type="text/javascript" src="KillApp.js"></script>
#### 4. Javascript
Pass 1 to restart. 0 (optional) to exit.
    KillApp.killProcess(1); 



