# enable-json
B) As the second part, we need a rest enabled service that load this cache and provide endpoint to search them and point user to the most appropriate page for requests like “what are the symptoms of cancer?” “treatments for headaches”

# instructions
This is a spring-boot application that loads the json and exposes 1)Rest enabled endpoint:
/search 
The endpoint takes 1 parameter query and returns respons with the query and list of urls that the application finds relevant.

example of result:
http://localhost:8080/search?query=what%20are%20the%20symptoms%20of%20cancer
{"query":"what are the symptoms of cancer","urls":["www.nhs.uk/conditions/eyelid-problems","www.nhs.uk/conditions/nail-abnormalities","www.nhs.uk/conditions/blood-in-urine","www.nhs.ukhttp://www.nhs.uk/Conditions/vaccinations/Pages/hpv-human-papillomavirus-vaccine.aspx","www.nhs.uk/conditions/Kaposis-sarcoma"]}

# to run
run this application as any other spring-boot application 
either 
java -jar target/enable-json-0.0.1-SNAPSHOT.jar
or 
mvn spring-boot:run 
