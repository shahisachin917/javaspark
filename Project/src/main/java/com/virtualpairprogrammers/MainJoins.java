//package com.virtualpairprogrammers;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaPairRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.api.java.Optional;
//import scala.Tuple2;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainJoins {
//    public static void main(String[] args) {
//        System.setProperty("hadoop.home.dir", "C:\\Tools\\hadoop");
//        Logger.getLogger("org.apache").setLevel(Level.WARN);
//
//        SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//
//        List<Tuple2<Integer, Integer>> visitRaw = new ArrayList<>();
//        visitRaw.add(new Tuple2<>(4, 18));
//        visitRaw.add(new Tuple2<>(6, 4));
//        visitRaw.add(new Tuple2<>(10, 9));
//
//        List<Tuple2<Integer, String>> userRaw = new ArrayList<>();
//        userRaw.add(new Tuple2<>(1, "John"));
//        userRaw.add(new Tuple2<>(2, "Bob"));
//        userRaw.add(new Tuple2<>(3, "Alan"));
//        userRaw.add(new Tuple2<>(4, "Doris"));
//        userRaw.add(new Tuple2<>(5, "Marybelle"));
//        userRaw.add(new Tuple2<>(6, "Raquel"));
//
//        JavaPairRDD<Integer, Integer> visits = sc.parallelizePairs(visitRaw);
//        JavaPairRDD<Integer, String> users = sc.parallelizePairs(userRaw);
//
//        //Inner Join
//        //JavaPairRDD<Integer, Tuple2<Integer, String>> joinedRdd = visits.join(users);
//        //joinedRdd.collect().forEach(System.out::println);
//
//        //Left Outer-Join
//        //JavaPairRDD<Integer, Tuple2<Integer, Optional<String>>> joinedRdd = visits.leftOuterJoin(users);
//        //joinedRdd.collect().forEach(name-> System.out.println(name._2._2().orElse("BLANK").toUpperCase()));
//
//        //Right Outer-Join
//        //JavaPairRDD<Integer, Tuple2<Optional<Integer>, String>> joinedRdd = visits.rightOuterJoin(users);
//        //joinedRdd.collect().forEach(it-> System.out.println("user "+ it._2._2 +" had "+ it._2._1().orElse(0)+ " visits"));
//
//        //Full Outer-Join
//        JavaPairRDD<Integer, Tuple2<Optional<Integer>, Optional<String>>> joinedRdd = visits.fullOuterJoin(users);
//        joinedRdd.collect().forEach(it-> System.out.println("user "+ it._2._2 +" had "+ it._2._1().orElse(0)+ " visits"));
//
//        //Cartesians
////        JavaPairRDD<Tuple2<Integer, Integer>, Tuple2<Integer, String>> joinedRdd = visits.cartesian(users);
////        joinedRdd.collect().forEach(System.out::println);
//
//        sc.close();
//    }
//}
