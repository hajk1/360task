# 360task
Assignment task 360T  
How to run:  
  1- build the project using maven >=3.6.3  
  2- use java >= 13  
  3- create new artifact using maven package  
  4- new artifact can be run using java -jar command as follows:  
  java -jar assignment-1.0-SNAPSHOT.jar  
  5- There are 2 possibilities which are shown to the user:  
  Welcome! Do you want to run Single(S) Process or Multiple(M) Process?    
  Selecting 'S' will continue the application in a single process mode on which both players exist on the same java process.  
  Then you are prompted to use 2 user names and also new message which will be sent between them 10 times.  
   6- Selecting 'M' will lead to multi process mode in which you have to select between Server(S) and Client(C) modes.  
   In this mode you have to run the application 2 times, first time as Server with no more actions.  
   7- Then you have to run the application again, while the server is running still. This time you have to select the Client mode.
  And then enter a username and the message.  
  8- In Multi process mode each player starts in a separate Process. The main Process starts a default Player which is host. And the client which is started by the user.
   
   
