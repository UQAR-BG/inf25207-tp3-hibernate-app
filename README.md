Ce projet a �t� cr�� dans l'IDE IntelliJ. Il est compil� et g�r� avec l'outil Maven.

Les variables d'environnement utilis�es pour la configuration de la connexion avec la base de donn�es
MariaDB se situent dans le fichier application.properties dans le r�pertoire src/main/resources/

La classe LoadDatabase charge des donn�es lors du lancement de l'application. Dans le cas ou vous 
souhaiteriez ne pas charger de donn�es au lancement, il suffit de mettre en commentaire le code 
contenu dans la classe.

Afin de tester l'application, une fois lanc�e, il suffit de se diriger � l'adresse http://localhost:8080/
dans le navigateur de votre choix.

Bonne correction !