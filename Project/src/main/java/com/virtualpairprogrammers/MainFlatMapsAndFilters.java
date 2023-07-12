//package com.virtualpairprogrammers;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class MainFlatMapsAndFilters {
//    public static void main(String[] args) {
//        List<String> inputData = new ArrayList<>();
//        inputData.add("WARN: Tuesday 4 September 0405");
//        inputData.add("ERROR: Tuesday 4 September 0408");
//        inputData.add("FATAL: Wednesday 5 September 1632");
//        inputData.add("ERROR: Friday 7 September 1854");
//        inputData.add("WARN: Saturday 8 September 1842");
//
//        Logger.getLogger("org.apache").setLevel(Level.WARN);
//
//        SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//
//        JavaRDD<String> sentences = sc.parallelize(inputData);
//
//        JavaRDD<String> words = sentences.flatMap(value -> Arrays.asList(value.split(" ")).iterator());
//
////        words.collect().foreach(System.out::println);
//
////        I got the serializable error when running the spark command. So I had to change to Java collection stream
//
////        words.filter(word-> true); -> Do nothing since the condition is always true. When false then the program is
//        //is terminated with no output
//
//        JavaRDD<String> filteredWords = words.filter(value -> value.length() > 1);
//
//        filteredWords.collect().forEach(System.out::println);
//        sc.close();
//
//        //All the above command can be re-written into 1 line of code
//        sc.parallelize(inputData)
//                .flatMap(value -> Arrays.asList(value.split(" ")).iterator())
//                .filter(value -> value.length() > 1)
//                .collect().forEach(System.out::println);
//    }
//}
