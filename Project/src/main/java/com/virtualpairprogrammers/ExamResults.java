//package com.virtualpairprogrammers;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.spark.sql.Dataset;
//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.SparkSession;
//import org.apache.spark.sql.functions;
//
//import static org.apache.spark.sql.functions.col;
//import static org.apache.spark.sql.functions.min;
//
//public class ExamResults {
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
//        //Using inferSchema, you can use aggregate functions without having to change it to Integer
////        Dataset<Row> dataset = spark.read().option("header", true).option("inferSchema", true).csv("Project/src/main/resources/exams/students.csv");
//
//        Dataset<Row> dataset = spark.read().option("header", true).csv("Project/src/main/resources/exams/students.csv");
//
//        //Find out what the maximum score is for each subject
//
////        Column score = dataset.col("score");
////        dataset = dataset.groupBy("subject").max(score.cast(DataTypes.IntegerType));
//
////        dataset=dataset.groupBy("subject")
////                .agg(functions.max(col("score").cast(DataTypes.IntegerType)).alias("max score"),
////                        min(col("score").cast(DataTypes.IntegerType)).alias("min score"));
//
//        dataset = dataset.groupBy("subject")
//                .agg(functions.max(col("score")).alias("max score"),
//                        min(col("score")).alias("min score"));
//
//        dataset.show();
//
//
//    }
//}
