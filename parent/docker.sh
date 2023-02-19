set -e

docker build -t app .
docker run -t app
