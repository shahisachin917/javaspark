//package com.virtualpairprogrammers;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.spark.sql.Dataset;
//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.SparkSession;
//
//public class MainFullSqlSyntax {
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
//        //header is optional field. But since we have a datafield in our csv file. We can use it
//        Dataset<Row> dataset = spark.read().option("header", true).csv("Project/src/main/resources/exams/students.csv");
//
//        dataset.createOrReplaceTempView("my_students_table");
//
////        Dataset<Row> result = spark.sql("select score, year from my_students_table where subject = 'French'");
////        Dataset<Row> result = spark.sql("select max(score) from my_students_table where subject = 'French'");
//        Dataset<Row> result = spark.sql("select distinct(year) from my_students_table order by year desc");
//        result.show();
//
//        spark.close();
//
//    }
//}
