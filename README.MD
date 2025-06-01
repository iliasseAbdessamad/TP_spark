<h2>Programmation des RDDs (Resilient distributed Datasets)</h2>
<p>Objectif du TP :</p>
<img src="./imgs/1.png" alt="objectif du tp" />

<h4>1 - total des ventes par ville (teste de l'application en local) : </h4>
<img src="./imgs/2.png" alt="programme du driver Spark" />

Résultat :
<img src="./imgs/3.png" alt="Résultat" />

<h4>2 - Deploiment de l'application sur un cluser spark (le fichier docker-compose.yml est fourni dans la racine du projet) : </h4>
<p>Voici les étapes à suivre : </p>
<p>1 - Créer un dossier sur votre machine (exp cluser-spark) , déplacer dans ce dossier le fichier docker-compose.yml</p>
<img src="./imgs/4.png" alt="dossier qui contient docker-compose.yml" />
<br />
<p>2 - Taper la commande suivante pour lancer les conteneurs (les services mentionnés dans docker-compose.yml)</p>
<img src="./imgs/5.png" alt="Lancement des services distribués" />
<br />
<p>
3 - Si tous est bien passer vous pouvez consulter http://localhost:8080 qui est l'interface web du conteneur spark-master,
dont vous trouverai des informations générales sur votre cluster
</p>
<img src="./imgs/6.png" alt="Lancement des services distribués" />
<br />
<p>4 - Déploiment de l'application sur ce cluster spark</p>
<img src="./imgs/7.png" alt="déploiment" />
<br />
<p>5 - A ce state toutes les taches (transformations et action) ont terminé leurs execution, et notre application "Total vente par ville" a était créée</p>
<img src="./imgs/8.png" alt="déploiment" />








