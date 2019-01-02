package com.pes;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class AverageMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String date = context.getConfiguration().get("year");
        String batsman = context.getConfiguration().get("name");
        System.out.println("Year: " + date + ", Batsman: " + batsman);

        System.out.println("Input: " + value.toString());
        String[] values = value.toString().split(",");
        String[] dates = values[0].split("-");
        System.out.println("The date for the row is " + dates[0]);
        if ( date.equals(dates[0]) )
        {
            System.out.println("Found date match! Batsman is: " + values[1]);
            if ( values[1].equals(batsman))
            {
                System.out.println("Found Batsman! Writing value: " + Integer.parseInt(values[2]));
                context.write(new Text(values[0]), new IntWritable(Integer.parseInt(values[2])));
            }
        }
    }
}
