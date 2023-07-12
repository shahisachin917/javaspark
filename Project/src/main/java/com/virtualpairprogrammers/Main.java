package com.virtualpairprogrammers;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF2;
import org.apache.spark.sql.types.DataTypes;

import static org.apache.spark.sql.functions.*;
import static org.apache.spark.sql.functions.col;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "C:\\Tools\\hadoop");
        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkSession spark = SparkSession.builder().appName("testingSql").master("local[*]")
                .config("spark.sql.warehouse.dir", "file:///c:/tmp")
                .getOrCreate();

        spark.udf().register("hasPassed", PassOrFail(), DataTypes.BooleanType);

        Dataset<Row> dataset = spark.read().option("header", true).csv("Project/src/main/resources/exams/students.csv");

//        dataset=dataset.withColumn("pass", lit("YES"));
        
        //true or false will literally be added
        //dataset = dataset.withColumn("pass", lit(col("grade").equalTo("A+")));

        dataset=dataset.withColumn("pass",callUDF("hasPassed",col("grade"), col("subject")));

        dataset.show();
    }

    private static UDF2<String, String, Object> PassOrFail() {
        return (String grade, String subject) -> {
            if (subject.equals("Biology")) {
                if (grade.startsWith("A"))
                    return true;
                return false;
            }
            return grade.startsWith("A") || grade.startsWith("B") || grade.startsWith("C");
        };
    }
}
