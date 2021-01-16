package com.github.hdfs;


import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//                                       k1    v1         k2       v2                                    
public class ObjMapper extends Mapper<LongWritable, Text, Employee, IntWritable>{

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		//7369,SMITH,CLERK,7902,1980/12/17,800,0,20
		String[] fields = value.toString().split(",");
		Employee employee = new Employee(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]),  fields[4], Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]));

		context.write(employee, new IntWritable(employee.getSal()));
		
	}

	
}
