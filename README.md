# Comtek-Inc-test-task

The realisation of State pattern + property file reading. Single classes are singleton's, so no new objects are created.

1) Waiting State -  String data comes from console input;
2) Process State - received data is written backwards;
3) Send State - data is output to consloe.

Pause time is taken from application.properties file. Pause is a task condition which is : "process and send state should take no less than N second written in application.properties file".
