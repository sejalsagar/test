# test assessment source
Technologies used
1. Java8
2. maven
3. Spring boot
4. H2 database
5. jacoco for code coverage
6. JUnit for unit testing

Notes::
1. Test cases use in memory db
2. To run the main app please use the below command to start the H2 db in server mode for persistence
java -jar h2-1.4.196.jar -baseDir ./tmp/h2dbs
Once the project is built using maven, h2-1.4.196.jar can be found at C:\Users\[username]\.m2\repository\com\h2database\h2\1.4.196
3. The coverage reports can be found at \test\target\site\jacoco
