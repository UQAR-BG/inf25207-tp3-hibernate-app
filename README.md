Ce projet a été créé dans l'IDE IntelliJ. Il est compilé et géré avec l'outil Maven.

Les variables d'environnement utilisées pour la configuration de la connexion avec la base de données
MariaDB se situent dans le fichier application.properties dans le répertoire src/main/resources/

La classe LoadDatabase charge des données lors du lancement de l'application. Dans le cas ou vous 
souhaiteriez ne pas charger de données au lancement, il suffit de mettre en commentaire le code 
contenu dans la classe.

Afin de tester l'application, une fois lancée, il suffit de se diriger à l'adresse http://localhost:8080/
dans le navigateur de votre choix.

Bonne correction !