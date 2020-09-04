MasterCard Code Challenge

Problem Statement/Description:
Two cities are considered connected if there’s a series of roads that can be travelled from one city to another.
List of roads is available in a file "cities.txt"
File contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.
Ex:
Boston, New York
Philadelphia, Newark
Newark, Boston
Trenton, Albany
It is deployed as a spring-boot app and the endpoint URL is:
http://localhost:8080/connected and input parameters: origin(String) and destination(String)
The program responds with ‘YES’ if city1 is connected to city2, ’NO’ if city1 is not connected to city2.
Ex:
http://localhost:8080/connected?origin=Boston&destination=Newark : YES
http://localhost:8080/connected?origin=Boston&destination=Philadelphia : YES
http://localhost:8080/connected?origin=Philadelphia&destination=Albany : NO

Project Documentation URL: http://localhost:8080/swagger-ui.html
