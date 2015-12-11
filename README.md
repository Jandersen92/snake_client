# snake_client

INSTALLATIONSVEJLEDNING FOR KLIENT OG Server: 

1.  - først åbens IntelliJ 
    - vælg file 
    - new
    - project
    - i menuen vælges Java Enterprise 
    - project SDK version sættes til 1.7 (java version)
    - under additional livraries and frameworks, skal der tilvælges "RESTful web service"
     tryk next.
     
2.  - på den næste skærm under project location, vælges mappen med programmet som skal importeres
    - tryk Finish.
    
3.  - eksterne libraies skal indlæses hvis de ikke findes i programmet lib mappe
        - Json-simple-1.1.1.jar 
        - Gson-2.4.jar
        - disse jar filer kan downloades  ved at søge efter dem på google 

4.  - tryk på file 
    - vælg project structure 
    - vælg libraies. 
    - tryk chance version
    - vælg version: jax-rs-jersey-1.10
    - tryk på + ikonet i ventre hjørne
    - indlæs de to jar filer, henholdsvis: Json-simple-1.1.1.jar og Gson-2.4.jar
    - tryk OK 
      
    
INSTALLATIONSVEJLEDNING FOR DATABASE:
 
1.  - Sequelpro(mac) skal køre på comuteren samt MYSQL 
    - hvis disse programmer ikke haves kan de downloades fra 
        - http://www.sequelpro.com/
        - https://www.mysql.com/
2.  - enter connection details
         - Host = localhost or 127.0.0.1
         - Username = root
         - database = snakedb
         - tryk connect.  

3   - snake_2015-11-12.sql filen fra mappen i skal indlæses til SequelPro
        - under select i ventre hjørne vælges: add database. 
        - kald databasen for snakedb
        - derefter tryk file
        - tryk import
        - import nu snake_2015-11-12.sql filen til SequelPro.

       

        
NU KAN SERVER OG KLIENT GØRES MED TILKOBLING TIL DATABASEN.        





