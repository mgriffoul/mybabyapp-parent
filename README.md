# Prérequis à l'application back:

**Prélude:** Pour lancer l'application côté back, l'installation de MongoDb est nécessaire.

linux : https://docs.mongodb.com/v2.8/administration/install-on-linux/
windows : https://docs.mongodb.com/v2.8/tutorial/install-mongodb-on-windows/

Lancer une instance de MongoDb en laissant les paramêtres par défaut (vous pouvez personnaliser le dossier de destination de Mongo), et c'est tout.

Ensuite il suffit de lancer la classe Main dans la classe MybabyappWebModuleApplication. L'application se lance sur le port 8080 et possède un jeu de Jsp pour tester les premiers développements.

# Pour lancer l'application front:

**Prélude:** Pour lancer l'application côté client, l'installation de NodeJS & Npm sur votre ordinateur est nécéssaire. 

* Aller dans le dossier "client"
* Installer les dépendances à l'aide de la commande: `npm install`
* Lancer l'application à l'aide de la commande: `npm start`
* Aller à l'adresse `localhost:8080` sur son navigateur
