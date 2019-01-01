# Using Hadoop Map-Reduce to calculate Batting Average of a Batsman

## Install and configure
Install Hadoop, set it up in Pseudo-Distributed mode, as described [here](https://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/SingleCluster.html#Pseudo-Distributed_Operation) <br>
Some sample configuration files are included in the `conf` folder. <br>

## Fetching and preparing the Data
Download the datasets for the IPL commenataries from the cricinfo website in the YAML format. <br>
The data needs to be pre-processed and condensed before running Map-Reduce

## Condensing the Data
In the `App.java` file, uncomment the second main function, which is responsible for parsing the YAML file and converting it to a form suitable for Map-Reduce <br>
Once uncommented the required main function (and comment out the Map-Reduce main function), then run `mvn package` from the root folder of the project <br>

This will generate a jar-with-dependencies.jar in the target folder. This is an executable jar, which will parse the YAML files and generate the CSV. <br>

Run the program using `java -jar target/average-1.0-SNAPSHOT-jar-with-dependencies.jar <path to ipl dataset folder> <output filename>` <br>
This generates the CSV file required by Map-Reduce

## Put the data into HDFS
Start Hadoop by running the `start-yarn.sh` and `start-dfs.sh` from the proper locations. <br>
Make a directory in Hadoop for input files through `hdfs dfs -mkdir -p /user/input/ipl` <br>
Copy the CSV file into the input folder `hdfs dfs -put <path to CSV file> /user/input/ipl` <br>
Create another folder to hold the output data: hdfs dfs -mkdir -p /user/ipl` <br>

## Running the Map-Reduce
Uncomment the Map-Reduce code in the App.java class, and comment out the parser code. Once this is done, build the code using `mvn install`. <br>

Run the Map-Reduce program through: `hadoop jar target/average-1.0-SNAPSHOT.jar com.pes.App /user/input/ipl /user/ipl/output 2016 "V Kohli"` <br>
Change the year and the batsman name appropriately if needed.

## Getting the output
Once the Map-Reduce completes, retrieve the output from HDFS by copying the output folder to a local folder: `hdfs dfs -get /user/ipl/output output` <br>
The output folder contains the results of the Map-Reduce.

