# You need a real tab instead of space in front of each command.
up:
	docker-compose up -d --force-recreate
run:
	mvn spring-boot:run
clean:
	docker-compose down
	sudo rm -rf db
	mvn clean