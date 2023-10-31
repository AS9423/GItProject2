package org.itc.com
import org.apache.spark.sql.{SparkSession, DataFrame}

object Main {
  def main(args: Array[String]): Unit = {
    // Create a SparkSession
    val spark = SparkSession.builder()
      .appName("ThreeTablesImport")
      .config("spark.master","local[1]")
      .getOrCreate()

    // Specify the file paths for your three CSV files
    val file1Path = "C:\\Training\\SQL\\members.csv"
    val file2Path = "C:\\Training\\SQL\\menu.csv"
    val file3Path =  "C:\\Training\\SQL\\sales.csv"

    // Read the CSV files into DataFrames
    val df1: DataFrame = spark.read.option("header", "true").csv(file1Path)
    val df2: DataFrame = spark.read.option("header", "true").csv(file2Path)
    val df3: DataFrame = spark.read.option("header", "true").csv(file3Path)

    // You now have three DataFrames (df1, df2, df3) containing the data from the CSV files.


    // For example, you can show the first few rows of each DataFrame
    df1.show()
    df2.show()
    df3.show()

    // Don't forget to stop the SparkSession when you're done.
    spark.stop()
  }
}
