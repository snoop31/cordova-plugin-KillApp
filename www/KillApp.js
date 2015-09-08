var exec = require('cordova/exec');

function KillApp() { 
}

KillApp.prototype.killProcess = function(shouldRestart){ 
	shouldRestart === 1? shouldRestart:shouldRestart = 0;
	exec(
		function(result){ /*alert("OK" + reply);*/ }, 
		function(result){ /*alert("Error" + reply);*/ },
		"KillApp", '', [shouldRestart]
	);
} 

var killApp = new KillApp(); 

module.exports = killApp;