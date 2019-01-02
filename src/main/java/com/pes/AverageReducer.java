package com.pes;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AverageReducer extends Reducer<Text, IntWritable, Text, FloatWritable> {

    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        float sum = 0;
        int i = 0;
        for (IntWritable val : values) {
            sum += val.get();
            ++i;
        }
        context.write(key, new FloatWritable(sum/i));
    }

}
