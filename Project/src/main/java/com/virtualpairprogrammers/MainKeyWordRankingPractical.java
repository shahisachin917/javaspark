//package com.virtualpairprogrammers;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaPairRDD;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import scala.Tuple2;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class MainKeyWordRankingPractical {
//    public static void main(String[] args) {
//        System.setProperty("hadoop.home.dir", "C:\\Tools\\hadoop");
//        Logger.getLogger("org.apache").setLevel(Level.WARN);
//
//        SparkConf conf = new SparkConf().setAppName("startingSpark").setMaster("local[*]");
//        JavaSparkContext sc = new JavaSparkContext(conf);
//
//        JavaRDD<String> initialRdd = sc.textFile("C:\\Tools\\SparkUdemy\\Practicals\\Starting Workspace\\Project\\src\\main\\resources\\subtitles\\input.txt");
//
//        // Removing everything that is not a work with blank. Use of regex here
//        JavaRDD<String> lettersOnlyRdd = initialRdd.map(sentence -> sentence.replaceAll("[^a-zA-Z\\s]", "").toLowerCase());
//
//        // Removing empty lines. But first we need to trim any whitespaces
//        JavaRDD<String> removedBlankLines = lettersOnlyRdd.filter(sentence -> sentence.trim().length() > 0);
//
//        //Using FlatMap to get all the words out of the sentence. Covered before so review that if you don't understand this one
//        JavaRDD<String> justWords = removedBlankLines.flatMap(sentence -> Arrays.asList(sentence.split(" ")).iterator());
//
//        //We were still getting blank values, we could've refactored the code to avoid blank values.
//        //But we didn't care about performance so we just decided to filter out the blank spaces like this instead. Performance will be checked later
//        JavaRDD<String> blankWordsRemoved = justWords.filter(word -> word.trim().length() > 0);
//
//        //Filtering words that are not interesting. Checking with the file we already have
//        JavaRDD<String> justInterestingWords = blankWordsRemoved.filter(Util::isNotBoring);
//
//        //Using PairRDD to add 1 to each word so we can do the reduceByKey to count them
//        JavaPairRDD<String, Long> pairRDD = justInterestingWords.mapToPair(word -> new Tuple2<String, Long>(word, 1L));
//
//        //Now counting them like I said :)
//        JavaPairRDD<String, Long> totals = pairRDD.reduceByKey(Long::sum);
//
//        //When we were sorting, we can only sort by key. So we are switching the value so we can sort by number
//        JavaPairRDD<Long, String> switched = totals.mapToPair(tuple -> new Tuple2<Long, String>(tuple._2, tuple._1));
//
//        //Sorting, true means ascending which can be left blank and false is descending
//        JavaPairRDD<Long, String> sorted = switched.sortByKey(false);
//
//        //Generating the 1st 10 values with the highest count
//        List<Tuple2<Long, String>> results = sorted.take(10);
//
//        //We can use collect as well. But make sure that the data is not too big
//        //List<Tuple2<Long, String>> results = sorted.collect();
//
//        //Using coalesce
//        //System.out.println(sorted.getNumPartitions()); -> Shows the number of partitions
//        //sorted.coalesce(1);
//
//        results.forEach(System.out::println);
//
//        sc.close();
//    }
//}
