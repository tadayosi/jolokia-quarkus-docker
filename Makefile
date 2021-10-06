APP_NAME = jolokia-quarkus

build:
	./mvnw package

image:
	podman build -t $(APP_NAME) .

run:
	podman run --rm -p 8080:8080 -p 8778:8778 --network bridge localhost/$(APP_NAME)

test:
	http localhost:8080/hello/test
	http localhost:8080/bye/test
	http localhost:8778/jolokia/version
