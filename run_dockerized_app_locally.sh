#!/bin/bash

image_name=datcom/starter-project
app_port=8080
ext_port=8080
config_server_url=http://localhost:8888
discover_server_url=http://localhost:8761

echo $config_server_url

docker build -t $image_name .

docker run -p $ext_port:$app_port \
-e APPLICATION_PORT=$app_port \
-e SPRING_PROFILES_ACTIVE=develop \
-e CONFIG_SERVER_URL=$config_server_url \
-e DISCOVERY_SERVER_URL=$discover_server_url \
--network host \
$image_name

# to kill running docker
# docker rm -f $(docker ps | awk '{ if($2 == "datcom/starter-project") { print $NF}}')
