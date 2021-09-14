# booking-api

J'ai créé un projet de réservation d'Hôtel, pour être plus centralisé j'ai utilisé le concept de monorepo.

**Annuaire**
#Dans /app** vous pouvez trouver toutes les API's REST
booking = C'est l'API pour réserver l'hôtel, au sein de cette API, elle contient les Layers : model = où il y a des entités, 
repository = où il y a l'interface qui communique avec la base de données, service = où il contient toutes les règles métier
pour la réservation comme enregistrer, modifier, rechercher toutes les réservations, rechercher une réservation par ID,
contrôleur = qui contient les verbes d'appels http utilisés: (GET, POST, PUT et DELETE.) et le layer rest = est l'endroit 
où j'ai personnalisé l'exception.

hotel = C'est l'API de l'hôtel, dans cette API elle contient les Layers : model = où se trouvent les entités, 
repository = où l'interface qui communique avec la base de données, service = qui contient toutes les règles métier pour l'hôtel
comme save, change, rechercher tous les hôtels, rechercher l'hôtel par ID, contrôleur = qui contient mes appels http verbes 
utilisés : (GET, POST, PUT et DELETE.) et le layer rest = est l'endroit où j'ai personnalisé l'exception.

common-booking = Là où j'ai centralisé ce qui est commun aux API (hotel-api et booking), j'ai les couches model et enums.

----------------------------------------------------------------------------------------------------------------------------------
#Avant de démarrer les services Kafka
1er Doit démarrer zookeeper (exécuter la commande dans Bin)
zookeeper-server-start (ton source)\kafka_2.13-2.7.0\config\zookeeper.properties
2e Doit démarrer kafka (exécuter la commande dans Bin)
kafka-server-start (ton source)\kafka_2.13-2.7.0\config\server.properties

#Services Kafka
common=kafka = Là où j'ai centralisé ce qui est commun à kafka, dans ce service j'ai créé les packages : 
dispacher = où j'ai la logique de produire les événements des événements kafka., 
consumer = où je consomme les événements qui ont été produits par thème.

service-email = J'ai créé ce service pour simuler l'envoi d'emails lors de la consommation d'un événement kafka.

service-email-new-booking-order = Ce service se charge d'envoyer des e-mails de remerciement, et de signaler que l'achat de 
la réservation est en cours de traitement, pour chaque réservation d'hôtel effectuée.

service-fraud-detector = Ce service se charge de valider si par hasard il y a fraude au paiement, si la valeur est >= 4500, 
je rejette la commande comme s'il s'agissait d'une fraude.

service-log = Ce service est chargé d'afficher les journaux des événements consommés.

----------------------------------------------------------------------------------------------------------------------------------
#Base de données: 
Pour ce projet, j'ai utilisé la base de données en mémoire H2
booking: http://localhost:8081/h2-console/
JDBC URL: jdbc:h2:mem:db-booking
username=sa
password=

hotel: http://localhost:8082/h2-console/
JDBC URL: jdbc:h2:mem:db-hotel
username=sa
password=

----------------------------------------------------------------------------------------------------------------------------------
#Swagger Booking API:
#J'ai utilisé Swagger pour documenter mes API
Swagger Hotel API: http://localhost:8082/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#

Swagger Booking API: http://localhost:8081/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#

---------------------------------------------------------------------------------------------------------------------------------

#J'ai créé un petit dessin d'architecture représentant mon projet, l'image est à la racine Architecture_API.jpge

#Merci à tous!
