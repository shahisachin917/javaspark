//package com.virtualpairprogrammers;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.spark.sql.Dataset;
//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.SparkSession;
//
//public class MainDataSetBasics {
//
//    @SuppressWarnings("resource")
//    public static void main(String[] args) {
//        System.setProperty("hadoop.home.dir", "C:\\Tools\\hadoop");
//        Logger.getLogger("org.apache").setLevel(Level.WARN);
//
////        SparkConf conf = new SparkConf().setAppName("StartingSpark").setMaster("local[*]");
////        JavaSparkContext sc = new JavaSparkContext();
//
//        SparkSession spark = SparkSession.builder().appName("testingSql").master("local[*]")
//                .config("spark.sql.warehouse.dir", "file:///c:/tmp")
//                .getOrCreate();
//
//        //header is optional field. But since we have a datafield in our csv file. We can use it
//        Dataset<Row> dataset = spark.read().option("header", true).csv("Project/src/main/resources/exams/students.csv");
//
//        //Print the first 20 rows in a nice readable format
//        dataset.show();
//
//        long numberOfRows = dataset.count();
//        System.out.println("There are "+numberOfRows+ " records");
//
//        Row firstRow = dataset.first();
////        index of the table starts from 0
////        String subject = firstRow.get(2).toString();
//
////        Since we have the header. We can getAs the column header
//        String subject = firstRow.getAs("subject");
//        System.out.println(subject);
//
//        int year = Integer.parseInt(firstRow.getAs("year"));
//
//        spark.close();
//    }
//}
