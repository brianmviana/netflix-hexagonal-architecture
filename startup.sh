#!/bin/bash
echo -e "\e[1m---------------------< Application provisioning startup >---------------------\e[0m"
echo ""
docker-compose up -d --build
echo ""
echo "------------------------------------------------------------------------------"
echo ""
echo ""

echo -e "\e[1mAccess URLs:\e[0m"
echo    "----------------------------------------------------------------"
echo -e "             \033[1mAPI URL:\033[0m http://localhost:8180/"
#echo -e "             \033[1mAPI URL:\033[0m http://localhost:8180/netflix-hexagonal-architecture"
#echo -e "             \033[1mSwagger:\033[0m http://localhost:8180/netflix-hexagonal-architecture/swagger-ui/"
#echo -e "            \033[1mActuator:\033[0m http://localhost:9190/actuator"
#echo -e "          \033[1mDebug Port:\033[0m 5105"
echo    "----------------------------------------------------------------"
