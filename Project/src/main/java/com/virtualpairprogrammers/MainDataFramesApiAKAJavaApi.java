//package com.virtualpairprogrammers;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.spark.sql.Dataset;
//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.SparkSession;
//import org.apache.spark.sql.types.DataTypes;
//
//import static org.apache.spark.sql.functions.*;
//
//public class MainDataFramesApiAKAJavaApi {
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
//        Dataset<Row> dataset = spark.read().option("header", true).csv("Project/src/main/resources/biglog.txt");
//
////        Dataset<Row> results = spark.sql("select level, date_format(datetime,'MMMM') as month,count(1) as total " +
////                "from logging_table group by level, month order by cast(first(date_format(datetime,'M')) as int), level");
//
////        We wanted to get the date with a certain format but it doesn't work with select
////        dataset = dataset.select("level");
//
////        Using this we can get format the date and have an alias
////        dataset.selectExpr("level", "date_format(datetime,'MMMM' as month)");
//
////        Another way of doing is by using function
//
//        dataset = dataset.select(col("level"), date_format(col("datetime"), "MMMM").alias("month"),
//                date_format(col("datetime"), "M").alias("monthnum").cast(DataTypes.IntegerType));
//
//        //We need to have aggregation in order to assign it to a dataset. That's why added count in the end
//        dataset = dataset.groupBy(col("level"), col("month"), col("monthnum")).count();
//        dataset = dataset.orderBy("monthnum","level");
//        dataset = dataset.drop(col("monthnum"));
//
//        dataset.show(100);
//
//        spark.close();
//    }
//}
