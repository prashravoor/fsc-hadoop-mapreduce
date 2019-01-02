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
        if ( date.equals(dates[2]) )
        {
            if ( values[1].equals(batsman))
            {
                context.write(new Text(values[1]), new IntWritable(Integer.parseInt(values[2])));
            }
        }
    }
}
