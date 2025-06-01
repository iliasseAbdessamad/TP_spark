package me.iliasse;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

// <b>
public class Main {
    public static void main(String[] args) {
        SparkConf sparkConfig = new SparkConf().setAppName("Total vente par ville");
        JavaSparkContext sprkCtx = new JavaSparkContext(sparkConfig);

        //chargement des lignes de ce fichier texte dans un RDD
        JavaRDD<String> rddLines = sprkCtx.textFile("ventes.txt");

        //initilisation d'un autre RDD qui contient les données sous forme de clé valeur
        JavaPairRDD<String, Double> citySale =rddLines.mapToPair(line -> {
            String[] parts = line.split(" ");
            String city = parts[1];
            Double price = Double.parseDouble(parts[parts.length - 1]);
            return new Tuple2<>(city, price);
        });

        //reduire par clé (ville) pour obtenir le total de vente pour chaque ville
        JavaPairRDD<String, Double> totalByCity = citySale.reduceByKey((v1, v2) -> {
            return v1+v2;
        });

        //collecter les données depuis les workers (et dans ce cas on affiche le résultat)
        totalByCity.collect().forEach(t -> {
            System.out.println("City:"+t._1 + " | total:"+t._2);
        });
    }
}