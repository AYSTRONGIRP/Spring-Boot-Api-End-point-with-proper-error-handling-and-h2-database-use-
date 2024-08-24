
git clone https://github.com/yourusername/supplier-search-api.git
cd supplier-search-api

Build the application using Maven:
mvn clean install

Running the Application
To run the application locally, use the following command:
mvn spring-boot:run

project video link - https://drive.google.com/file/d/1XIk9a4j22yhm44lLJls8s7WnthPxLGh2/view?usp=drive_link

The application will start on http://localhost:8080.

API Endpoints
Search Suppliers
Endpoint: api/supplier/query
Method: POST
Content-Type: application/json

Description: Search for suppliers based on location, nature of business, and manufacturing processes.

![image](https://github.com/user-attachments/assets/14f4813b-36a5-498a-98c9-51289dea3024)

cURL Commands
Valid Request Example:

curl -X POST http://localhost:8080/api/supplier/query \
-H "Content-Type: application/json" \
-d '{
    "location": "San Francisco",
    "natureOfBusiness": "LARGE_SCALE",
    "manufacturingProcesses": "CASTING",
    "page": 0,
    "size": 2
}'

