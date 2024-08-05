#!/bin/bash

# 定义 Docker Compose 文件的名称
COMPOSE_FILES=("docker-compose.env.yml" "docker-compose.service.yml")
CONTAINER_NAMES_BUSINESS=("olecode-question-service" "olecode-judge-service" "olecode-user-service" "olecode-gateway-service")
CONTAINER_NAMES_ENV=("olecode-redis" "olecode-rabbitmq" "olecode-nacos" "olecode-mysql")
IMAGE_NAMES=("olecode_springcloud_alibaba_dev-olecode-gateway-service:latest" "olecode_springcloud_alibaba_dev-olecode-user-service:latest" "olecode_springcloud_alibaba_dev-olecode-question-service:latest" "olecode_springcloud_alibaba_dev-olecode-backend-judge-service:latest")

# 停止并删除指定的容器
cleanup_containers() {
    # 停止并删除业务模块容器
    for CONTAINER_NAME in "${CONTAINER_NAMES_BUSINESS[@]}"; do
        if docker ps -a --format '{{.Names}}' | grep -q "^${CONTAINER_NAME}$"; then
            echo "停止并删除业务模块容器: ${CONTAINER_NAME}"
            docker stop ${CONTAINER_NAME}
            docker rm ${CONTAINER_NAME}
        fi
    done

    # 停止并删除环境依赖容器
    for CONTAINER_NAME in "${CONTAINER_NAMES_ENV[@]}"; do
        if docker ps -a --format '{{.Names}}' | grep -q "^${CONTAINER_NAME}$"; then
            echo "停止并删除环境依赖容器: ${CONTAINER_NAME}"
            docker stop ${CONTAINER_NAME}
            docker rm ${CONTAINER_NAME}
        fi
    done
}

# 删除指定的镜像
cleanup_images() {
    for IMAGE_NAME in "${IMAGE_NAMES[@]}"; do
        if docker images --format '{{.Repository}}:{{.Tag}}' | grep -q "^${IMAGE_NAME}$"; then
            echo "删除镜像: ${IMAGE_NAME}"
            docker rmi ${IMAGE_NAME}
        fi
    done
}

# 启动 Docker Compose 服务
start_services() {
    for FILE in "${COMPOSE_FILES[@]}"; do
        echo "从 ${FILE} 启动服务"
        docker-compose -f ${FILE} up -d
    done
}

# 主脚本执行
echo "开始部署脚本"

# 清理容器和镜像
cleanup_containers
cleanup_images

# 启动服务
start_services

echo "部署脚本完成"
