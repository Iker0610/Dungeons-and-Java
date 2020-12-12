
#Comprobar que docker está instalado
VAR1=$(which docker)

#Si docker no está instalado, lo instala
if [ -z "$VAR1" ];
then
	echo 'Instalando Docker...'
	sudo apt-get update
	sudo apt-get install \
    	apt-transport-https \
   	ca-certificates \
   	curl \
   	gnupg-agent \
    	software-properties-common
	curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
	sudo apt-key fingerprint 0EBFCD88
	sudo add-apt-repository \
   	"deb [arch=amd64] https://download.docker.com/linux/ubuntu \
  	 $(lsb_release -cs) \
  	stable"
	sudo apt-get update
	sudo apt-get install docker-ce docker-ce-cli containerd.io
	docker-ce=19.03.12 docker-ce-cli=3-0 containerd.io
else
	echo 'Docker ya estaba instalado'
fi

#Comprobar que docker-compose está instalado
VAR2=$(which docker-compose)

#Si docker no está instalado, lo instala
if [ -z "$VAR2" ];
then
	echo 'Instalando docker-compose...'
	sudo apt install docker-compose
else
	echo 'Docker-compose ya estaba instalado'
fi

# Creamos las imágenes
sudo docker build --tag web:1.0 .

# Creamos los containers
sudo docker-compose up -d

# Importamos la base de datos
echo 'Importando datos en la base de datos...'
sudo docker exec -i $(docker ps | grep mariadb | cut -c 1-12) mysql -uroot -proot database < relojeria_platas.sql 2> /dev/null
echo 'Datos importados'

# Abrimos el sistema web a través de firefox
echo 'Abriendo sistema web...'
firefox http://127.0.0.1:8080
