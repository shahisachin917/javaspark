//package com.virtualpairprogrammers;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.spark.sql.*;
//
//import static org.apache.spark.sql.functions.*;
//
//public class MainDataSetFilters {
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
////        use where clause from sql
////        Dataset<Row> modernArtResults = dataset.filter("subject='Modern Art' AND year >=2007");
////        modernArtResults.show();
//
////        Dataset<Row> modernArtResultsLambda = dataset.filter(row -> row.getAs("subject").equals("Modern Art")
////                                                            && Integer.parseInt(row.getAs("year")) >=2007);
////
////        modernArtResultsLambda.show();
////
////        Column subjectColumn = dataset.col("subject");
////        Column yearColumn = dataset.col("year");
//
////
////        Dataset<Row> modernArtResults = dataset.filter(subjectColumn.equalTo("Modern Art")
////                .and(yearColumn.geq(2007)));
//
//
//        Dataset<Row> modernArtResults = dataset.filter(col("subject").equalTo("Modern Art")
//                        .and(col("year").geq(2007)));
//
//        modernArtResults.show();
//
//    }
//}
