mvn clean install
docker build -t apt-api .
docker run -p 8080:8080 -t apt-api
