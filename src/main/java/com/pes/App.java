package com.pes;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class App {
	public static void main(String[] args) throws Exception {
	
		if (args.length < 4) {
			System.err.println("Usage: <exe> <input path> <output path> <Year> <batsman name>");
			System.exit(1);
		}
	
		Configuration conf = new Configuration();
		conf.set("year", args[2]);
        conf.set("name", args[3]);

	
		Job job = Job.getInstance(conf);
		job.setJarByClass(App.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloatWritable.class);
		job.setMapperClass(AverageMapper.class);
		job.setReducerClass(AverageReducer.class);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		boolean status = job.waitForCompletion(true);
		if (status) {
			System.exit(0);
		} else {
			System.exit(1);
		}
	}

    /***** Uncomment below method, and comment above one to run the parser ******/
    /*
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper
            = new ObjectMapper(new YAMLFactory()); 
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        if (args.length != 2)
        {
            System.out.println("Specify a folder name containing the YAML files");
            System.exit(1);
        }

        FileWriter writer = new FileWriter(args[1]);
        try {
            File folder = new File(args[0]);
            File[] listOfFiles = folder.listFiles();
            File[] files = new File[listOfFiles.length];

            for (int i = 0, j = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains(".yaml")) {
                    files[j++] = listOfFiles[i];
                }
            }

            for( File f : files) {
                try {
                    Match match =
                        mapper.readValue(f, Match.class);
                    String date = match.getInfo().getDates().get(0);
                    for ( Innings inn : match.getInnings() ) {
                        //System.out.println("Innings: " + inn);
                        //System.out.println("First: " + inn.getFirst() + ", Second: " + inn.getSecond());
                        String str = processInnings(inn.getFirst(), date);
                        if ( !str.isEmpty() )
                        {
                            writer.write(str);
                        }
                        str = processInnings(inn.getSecond(), date);
                        if ( !str.isEmpty() )
                        {
                            writer.write(str);
                        }
                    }
                } catch (NullPointerException e)
                {
                    System.err.println("Null for file: " + f);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        writer.close();
    }

    private static String processInnings(Innings.DeepInnings inn, String date)
    {
        if ( null == inn )
        {
            return "";
        }

        String output = "";
        // System.out.println("Innings Team: " + inn.getTeam() + ", Num Deleveries: " + inn.getDeliveries().size());
        for ( Map<String, Innings.Delivery> map : inn.getDeliveries() )
        {
            for ( Innings.Delivery del : map.values() )
            {
                //System.out.println("Date: " + date + ", Batsman: " + del.getBatsman() + ", Runs: " + del.getRuns().getBatsman());
                output += date + "," + del.getBatsman() + "," + del.getRuns().getBatsman() + "\n";
            }
        }
        return output;
    }
    */
}
