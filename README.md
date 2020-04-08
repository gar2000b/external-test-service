# external-test-service
External Test Service

docker network create -d bridge social-insurance  
docker network ls  

docker build -t gar2000b/external-test-service .  
docker run -it -d -p 9086:9086 --network="social-insurance" --name external-test-service gar2000b/external-test-service  

All optional:

docker create -it gar2000b/external-test-service bash  
docker ps -a  
docker start ####  
docker ps  
docker attach ####  
docker remove ####  
docker image rm gar2000b/external-test-service  
docker exec -it external-test-service sh  
docker login  
docker push gar2000b/external-test-service  