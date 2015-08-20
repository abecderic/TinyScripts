# TaskScheduler
This script was created to call another (Java-)program (action) every so often.

To use simply set the INTERVAL in ms - in this case 15 minutes; set the amount of times the action should be executed and add a call to the main function of your program in ACTION HERE.
Feel free to pass the logger to your program and make use of it.

The action gets called at the start of the interval; so if the interval is 15 minutes the action gets called at 00, 15, 30 and 45 minutes of every hour.