//package com.virtualpairprogrammers;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.spark.sql.Dataset;
//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.SparkSession;
//
//import static org.apache.spark.sql.functions.*;
//
//public class Main27PraticalExercise {
//
//    @SuppressWarnings("resource")
//    public static void main(String[] args) {
//        System.setProperty("hadoop.home.dir", "C:\\Tools\\hadoop");
//        Logger.getLogger("org.apache").setLevel(Level.WARN);
//
//        SparkSession spark = SparkSession.builder().appName("testingSql").master("local[*]")
//                .config("spark.sql.warehouse.dir", "file:///c:/tmp")
//                .getOrCreate();
//
//        /* Practice Problem. Create a Pivot table for each subject show the average and stddev for the given year.
//        Subject is in left handside and year is across the top
//        */
//
//        Dataset<Row> dataset = spark.read().option("header", true).csv("Project/src/main/resources/exams/students.csv");
//
//        //For the pivot table we need 2 columns. Avg and Standard deviation. So they are comma seperated values
//        Dataset<Row> avg = dataset.groupBy("subject").pivot("year").agg(round(avg(col("score")), 2).alias("Average"),
//                                                                                        round(stddev(col("score")),2).alias("STDDEV"));
//
//        avg.show();
//
//    }
//}
