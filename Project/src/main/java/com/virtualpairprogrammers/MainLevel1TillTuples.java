//package com.virtualpairprogrammers;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import scala.Tuple2;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainLevel1TillTuples {
//    public static void main(String[] args) {
//        List<Integer> inputData = new ArrayList<>();
//        inputData.add(34);
//        inputData.add(12);
//        inputData.add(26);
//        inputData.add(58);
//
//        Logger.getLogger("org.apache").setLevel(Level.WARN);
//
//        SparkConf conf = new SparkConf().setAppName("starting Spark").setMaster("local[*]");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//
//        //is communicating with Scala Rdd. Is a wrapper class
//        JavaRDD<Integer> myRdd = sc.parallelize(inputData);
//
////        Using map to get sqrt of a value
//        //JavaRDD<Double> sqrtRdd = myRdd.map(Math::sqrt);
//        //sqrtRdd.foreach(System.out::println);
//
//
//        //sqrtRdd.count();
//
//        //Count using map and reduce
//        JavaRDD<Long> count= myRdd.map(value->1L);
//        Long resultCount= count.reduce(Long::sum);
//        System.out.println(resultCount);
//
////Using map reduce to add all the elements of a node
////        Double result = myRdd.reduce((value1, value2)-> value1+value2);
////        System.out.println(result);
//
//        //If we need to store multiple data
//        JavaRDD<Integer> originalIntegers = sc.parallelize(inputData);
//
//        //JavaRDD<IntegerWithSquareRoot> sqrtRdd = originalIntegers.map(IntegerWithSquareRoot::new); -> Using custom class
//        JavaRDD<Tuple2<Integer, Double>> sqrtRdd = originalIntegers.map(value ->new Tuple2<>(value, Math.sqrt(value)));
//
//        sc.close();
//    }
//}
