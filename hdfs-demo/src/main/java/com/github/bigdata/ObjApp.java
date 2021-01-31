package com.github.bigdata;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ObjApp {

	public static void main(String[] args) throws Exception {

		// hdfs地址
		String HDFS_PATH = "hdfs://hadoop001:8020";
		String HDFS_USER = "root";
		Configuration configuration = new Configuration();
		// 这里我启动的是单节点的 Hadoop,所以副本系数设置为 1,默认值为 3
		configuration.set("dfs.replication", "1");
		configuration.set("fs.defaultFS", HDFS_PATH);


		Job job = Job.getInstance(configuration);
		job.setJarByClass(ObjApp.class);

		FileInputFormat.addInputPath(job, new Path("/beihang/emp.csv"));

		job.setMapperClass(ObjMapper.class);
		job.setMapOutputKeyClass(Employee.class);
		job.setMapOutputValueClass(IntWritable.class);
		

		job.setOutputKeyClass(Employee.class);
		job.setOutputValueClass(IntWritable.class);
		Path resultPath = new Path("/beihang/empresult");
		FileSystem fileSystem = resultPath.getFileSystem(configuration);
		if(fileSystem.exists(resultPath)){
			fileSystem.delete(resultPath, true);
		}
		FileOutputFormat.setOutputPath(job, resultPath);
		//7.�ύ���񣬿�ʼִ��
		job.waitForCompletion(true);
	}
}
