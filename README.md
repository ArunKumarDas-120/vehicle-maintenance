# vehicle-maintenance

## Architecture Diagram
![vehicle-service](https://user-images.githubusercontent.com/45845757/64473138-3b75af00-d183-11e9-8c0b-45c3349fd037.jpg)
## Local email settings (HmailServer)
http://duyhung.1055016.n5.nabble.com/How-to-Setup-localhost-email-server-using-hMailServer-and-Thunderbird-td5704501.html
## Database
<pre>
1) make directory of any name <drive:\H2Database>
2) Copy h2 inside the directory.
3) create one more directory to store database files <drive:\H2Database\databases>
4) run command:- java -cp h2.jar org.h2.tools.Server -web -webPort 2000 -webAllowOthers -tcp -tcpAllowOthers -tcpPort 3000
   this will start h2 database in server mode
</pre>
