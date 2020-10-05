package com.github.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.permission.FsAction;
import org.apache.hadoop.fs.permission.FsPermission;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
class HdfsDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	// hdfs地址
	private static final String HDFS_PATH = "hdfs://hadoop001:8020";
	private static final String HDFS_USER = "root";
	private static FileSystem fileSystem;

	@BeforeEach
	public void prepare() {
		try {
			Configuration configuration = new Configuration();
			// 这里我启动的是单节点的 Hadoop,所以副本系数设置为 1,默认值为 3
			configuration.set("dfs.replication", "1");
			fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration, HDFS_USER);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}


	@AfterEach
	public void destroy() {
		fileSystem = null;
	}

	@Test
	public void mkDir() throws Exception {
		fileSystem.mkdirs(new Path("/hdfs-api/test0/"));
	}

	@Test
	public void mkDirWithPermission() throws Exception {
		fileSystem.mkdirs(new Path("/hdfs-api/test1/"),
				new FsPermission(FsAction.READ_WRITE, FsAction.READ, FsAction.READ));
	}

	@Test
	public void create() throws Exception {
		// 如果文件存在，默认会覆盖, 可以通过第二个参数进行控制。第三个参数可以控制使用缓冲区的大小
		FSDataOutputStream out = fileSystem.create(new Path("/hdfs-api/test/a.txt"),
				true, 4096);
		out.write("hello hadoop!".getBytes());
		out.write("hello spark!".getBytes());
		out.write("hello flink!".getBytes());
		// 强制将缓冲区中内容刷出
		out.flush();
		out.close();
	}

	@Test
	public void exist() throws Exception {
		boolean exists = fileSystem.exists(new Path("/hdfs-api/test/a.txt"));
		System.out.println(exists);
	}

	@Test
	public void readToString() throws Exception {
		FSDataInputStream inputStream = fileSystem.open(new Path("/hdfs-api/test/a.txt"));
		String context = inputStreamToString(inputStream, "utf-8");
		System.out.println(context);
	}
	@Test
	public void rename() throws Exception {
		Path oldPath = new Path("/hdfs-api/test/a.txt");
		Path newPath = new Path("/hdfs-api/test/b.txt");
		boolean result = fileSystem.rename(oldPath, newPath);
		System.out.println(result);
	}

	public void delete() throws Exception {
		/*
		 *  第二个参数代表是否递归删除
		 *    +  如果 path 是一个目录且递归删除为 true, 则删除该目录及其中所有文件;
		 *    +  如果 path 是一个目录但递归删除为 false,则会则抛出异常。
		 */
		boolean result = fileSystem.delete(new Path("/hdfs-api/test/b.txt"), true);
		System.out.println(result);
	}

	@Test
	public void copyFromLocalFile() throws Exception {
		// 如果指定的是目录，则会把目录及其中的文件都复制到指定目录下
		Path src = new Path("D:\\BigData-Notes\\notes\\installation");
		Path dst = new Path("/hdfs-api/test/");
		fileSystem.copyFromLocalFile(src, dst);
	}

	@Test
	public void copyFromLocalBigFile() throws Exception {

		File file = new File("D:\\kafka.tgz");
		final float fileSize = file.length();
		InputStream in = new BufferedInputStream(new FileInputStream(file));

		FSDataOutputStream out = fileSystem.create(new Path("/hdfs-api/test/kafka5.tgz"),
				new Progressable() {
					long fileCount = 0;

					public void progress() {
						fileCount++;
						// progress 方法每上传大约 64KB 的数据后就会被调用一次
						System.out.println("上传进度：" + (fileCount * 64 * 1024 / fileSize) * 100 + " %");
					}
				});

		IOUtils.copyBytes(in, out, 4096);

	}

	public void listFiles() throws Exception {
		FileStatus[] statuses = fileSystem.listStatus(new Path("/hdfs-api"));
		for (FileStatus fileStatus : statuses) {
			//fileStatus 的 toString 方法被重写过，直接打印可以看到所有信息
			System.out.println(fileStatus.toString());
		}
	}

	@Test
	public void getFileBlockLocations() throws Exception {

		FileStatus fileStatus = fileSystem.getFileStatus(new Path("/hdfs-api/test/kafka.tgz"));
		BlockLocation[] blocks = fileSystem.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
		for (BlockLocation block : blocks) {
			System.out.println(block);
		}
	}


	/**
	 * 把输入流转换为指定编码的字符
	 *
	 * @param inputStream 输入流
	 * @param encode      指定编码类型
	 */
	private static String inputStreamToString(InputStream inputStream, String encode) {
		try {
			if (encode == null || ("".equals(encode))) {
				encode = "utf-8";
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, encode));
			StringBuilder builder = new StringBuilder();
			String str = "";
			while ((str = reader.readLine()) != null) {
				builder.append(str).append("\n");
			}
			return builder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
