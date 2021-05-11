# FTP-Server
This program allows files to be transferred from a host's computer to any computers connected via port forwarding.

The File Transfer Protocol is a standard communication protocol used for the transfer of computer files from a server to a client on a computer network. FTP is built on a client–server model architecture using separate control and data connections between the client and the server.

On the "master" branch, the server is being run on the localhost via **JavaHTTPServer.java**. The backend work that is actually traversing the directories and outputting links/folders is in the GFG file. The GFG file iterates through an outputFile - file object that is hardcoded as the directory from which the project is being ran. 

![image](https://user-images.githubusercontent.com/59908789/117766489-852e5c80-b1e4-11eb-9b41-e8f7394c6c7f.png)

If there is a "." in the file name, then the program treats it like a downloadable file, otherwise it is treated as a directory and will link you to the contents of that directory.

As a proof of concept, files from my computer were able to be downloaded from another system that was given privledges via port forwarding.  
