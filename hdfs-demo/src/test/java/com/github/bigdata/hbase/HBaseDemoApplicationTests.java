package com.github.bigdata.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HBaseDemoApplicationTests {

    // hdfs地址
    private static final String HDFS_PATH = "hdfs://hadoop001:8020";
    private Connection connection ;
    private final String TABLE_NAME = "myuser";
    private Table table ;

    @BeforeEach
    public void initTable () throws IOException {
        Configuration configuration = HBaseConfiguration.create();
        //configuration.set("hbase.zookeeper.quorum","hadoop101:2181,hadoop102:2181,hadoop103:2181");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        // 如果是集群 则主机名用逗号分隔
        configuration.set("hbase.zookeeper.quorum", "hadoop001");

        connection= ConnectionFactory.createConnection(configuration);
        table = connection.getTable(TableName.valueOf(TABLE_NAME));
    }

    @AfterEach
    public void close() throws IOException {
        table.close();
        connection.close();
    }

    //操作数据库  第一步：获取连接  第二步：获取客户端对象   第三步：操作数据库  第四步：关闭
    /**
     * 创建一张表  myuser  两个列族  f1   f2
     */
    @Test
    public void createTable() throws IOException {
        //获取连接对象，创建一张表
        //获取管理员对象，来对手数据库进行DDL的操作
        Admin admin = connection.getAdmin();
        //指定我们的表名
        TableName myuser = TableName.valueOf("myuser1");
        HTableDescriptor hTableDescriptor = new HTableDescriptor(myuser);
        //指定两个列族
        HColumnDescriptor f1 = new HColumnDescriptor("f1");
        HColumnDescriptor f2 = new HColumnDescriptor("f2");
        hTableDescriptor.addFamily(f1);
        hTableDescriptor.addFamily(f2);
        admin.createTable(hTableDescriptor);
        admin.close();
        connection.close();
    }


    /**
     * 删除 hBase 表
     *
     */
    @Test
    public void deleteTable() {
        String tableName="myuser1";
        try {
            HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
            // 删除表前需要先禁用表
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *  向myuser表当中添加数据
     */
    @Test
    public void addData() throws IOException {
        //获取表
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        Put put = new Put("0001".getBytes());//创建put对象，并指定rowkey值
        put.addColumn("f1".getBytes(),"name".getBytes(),"kl".getBytes());
        put.addColumn("f1".getBytes(),"age".getBytes(), Bytes.toBytes(18));
        put.addColumn("f1".getBytes(),"id".getBytes(), Bytes.toBytes(25));
        put.addColumn("f1".getBytes(),"address".getBytes(), Bytes.toBytes("地球人"));
        table.put(put);
        table.close();
    }


    /**
     * hbase的批量插入数据
     */
    @Test
    public void batchInsert() throws IOException {
        //创建put对象，并指定rowkey
        Put put = new Put("0002".getBytes());
        //f1
        put.addColumn("f1".getBytes(),"id".getBytes(),Bytes.toBytes(1));
        put.addColumn("f1".getBytes(),"name".getBytes(),Bytes.toBytes("曹操"));
        put.addColumn("f1".getBytes(),"age".getBytes(),Bytes.toBytes(30));
        //f2
        put.addColumn("f2".getBytes(),"sex".getBytes(),Bytes.toBytes("1"));
        put.addColumn("f2".getBytes(),"address".getBytes(),Bytes.toBytes("沛国谯县"));
        put.addColumn("f2".getBytes(),"phone".getBytes(),Bytes.toBytes("16888888888"));
        put.addColumn("f2".getBytes(),"say".getBytes(),Bytes.toBytes("helloworld"));

        Put put2 = new Put("0003".getBytes());
        put2.addColumn("f1".getBytes(),"id".getBytes(),Bytes.toBytes(2));
        put2.addColumn("f1".getBytes(),"name".getBytes(),Bytes.toBytes("刘备"));
        put2.addColumn("f1".getBytes(),"age".getBytes(),Bytes.toBytes(32));
        put2.addColumn("f2".getBytes(),"sex".getBytes(),Bytes.toBytes("1"));
        put2.addColumn("f2".getBytes(),"address".getBytes(),Bytes.toBytes("幽州涿郡涿县"));
        put2.addColumn("f2".getBytes(),"phone".getBytes(),Bytes.toBytes("17888888888"));
        put2.addColumn("f2".getBytes(),"say".getBytes(),Bytes.toBytes("talk is cheap , show me the code"));

        Put put3 = new Put("0004".getBytes());
        put3.addColumn("f1".getBytes(),"id".getBytes(),Bytes.toBytes(3));
        put3.addColumn("f1".getBytes(),"name".getBytes(),Bytes.toBytes("孙权"));
        put3.addColumn("f1".getBytes(),"age".getBytes(),Bytes.toBytes(35));
        put3.addColumn("f2".getBytes(),"sex".getBytes(),Bytes.toBytes("1"));
        put3.addColumn("f2".getBytes(),"address".getBytes(),Bytes.toBytes("下邳"));
        put3.addColumn("f2".getBytes(),"phone".getBytes(),Bytes.toBytes("12888888888"));
        put3.addColumn("f2".getBytes(),"say".getBytes(),Bytes.toBytes("what are you 弄啥嘞！"));

        Put put4 = new Put("0005".getBytes());
        put4.addColumn("f1".getBytes(),"id".getBytes(),Bytes.toBytes(4));
        put4.addColumn("f1".getBytes(),"name".getBytes(),Bytes.toBytes("诸葛亮"));
        put4.addColumn("f1".getBytes(),"age".getBytes(),Bytes.toBytes(28));
        put4.addColumn("f2".getBytes(),"sex".getBytes(),Bytes.toBytes("1"));
        put4.addColumn("f2".getBytes(),"address".getBytes(),Bytes.toBytes("四川隆中"));
        put4.addColumn("f2".getBytes(),"phone".getBytes(),Bytes.toBytes("14888888888"));
        put4.addColumn("f2".getBytes(),"say".getBytes(),Bytes.toBytes("出师表你背了嘛"));

        Put put5 = new Put("0006".getBytes());
        put5.addColumn("f1".getBytes(),"id".getBytes(),Bytes.toBytes(5));
        put5.addColumn("f1".getBytes(),"name".getBytes(),Bytes.toBytes("司马懿"));
        put5.addColumn("f1".getBytes(),"age".getBytes(),Bytes.toBytes(27));
        put5.addColumn("f2".getBytes(),"sex".getBytes(),Bytes.toBytes("1"));
        put5.addColumn("f2".getBytes(),"address".getBytes(),Bytes.toBytes("哪里人有待考究"));
        put5.addColumn("f2".getBytes(),"phone".getBytes(),Bytes.toBytes("15888888888"));
        put5.addColumn("f2".getBytes(),"say".getBytes(),Bytes.toBytes("跟诸葛亮死掐"));


        Put put6 = new Put("0007".getBytes());
        put6.addColumn("f1".getBytes(),"id".getBytes(),Bytes.toBytes(5));
        put6.addColumn("f1".getBytes(),"name".getBytes(),Bytes.toBytes("xiaobubu—吕布"));
        put6.addColumn("f1".getBytes(),"age".getBytes(),Bytes.toBytes(28));
        put6.addColumn("f2".getBytes(),"sex".getBytes(),Bytes.toBytes("1"));
        put6.addColumn("f2".getBytes(),"address".getBytes(),Bytes.toBytes("内蒙人"));
        put6.addColumn("f2".getBytes(),"phone".getBytes(),Bytes.toBytes("15788888888"));
        put6.addColumn("f2".getBytes(),"say".getBytes(),Bytes.toBytes("貂蝉去哪了"));

        List<Put> listPut = new ArrayList<Put>();
        listPut.add(put);
        listPut.add(put2);
        listPut.add(put3);
        listPut.add(put4);
        listPut.add(put5);
        listPut.add(put6);

        table.put(listPut);
    }
    /**
     * 查询rowkey为0005的人
     */
    @Test
    public void getData() throws IOException {
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        //通过get对象，指定rowkey
        Get get = new Get(Bytes.toBytes("0005"));

        get.addFamily("f1".getBytes());//限制只查询f1列族下面所有列的值
        //查询f2  列族 phone  这个字段
        get.addColumn("f2".getBytes(),"phone".getBytes());
        //通过get查询，返回一个result对象，所有的字段的数据都是封装在result里面了
        Result result = table.get(get);
        List<Cell> cells = result.listCells();  //获取一条数据所有的cell，所有数据值都是在cell里面 的
        for (Cell cell : cells) {
            byte[] rowkey = CellUtil.cloneRow(cell);//获取rowkey
            byte[] family_name = CellUtil.cloneFamily(cell);//获取列族名
            byte[] column_name = CellUtil.cloneQualifier(cell);//获取列名
            byte[] cell_value = CellUtil.cloneValue(cell);//获取cell值
            //需要判断字段的数据类型，使用对应的转换的方法，才能够获取到值
            if("age".equals(Bytes.toString(column_name))  || "id".equals(Bytes.toString(column_name))){
                System.out.println(Bytes.toString(family_name));
                System.out.println(Bytes.toString(column_name));
                System.out.println(Bytes.toString(rowkey));
                System.out.println(Bytes.toInt(cell_value));
            }else{
                System.out.println(Bytes.toString(family_name));
                System.out.println(Bytes.toString(column_name));
                System.out.println(Bytes.toString(rowkey));
                System.out.println(Bytes.toString(cell_value));
            }
        }
        table.close();
    }

    /**
     * 不知道rowkey的具体值，我想查询rowkey范围值是0003  到0006
     */
    @Test
    public void scanData() throws IOException {
        //获取table
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        Scan scan = new Scan();//没有指定startRow以及stopRow  全表扫描
        //扫描f1列族
        scan.addFamily("f1".getBytes());
        //扫描 f2列族 phone  这个字段
        scan.addColumn("f2".getBytes(),"phone".getBytes());
        //设置起始结束rowkey，前闭后开
        scan.setStartRow("0003".getBytes());
        scan.setStopRow("0007".getBytes());

        //设置每批次返回客户端的行数，比如这里是10个result，避免数据量太大，网络拥堵
        scan.setCaching(10);
        //设置每批次返回客户端的cell个数，比如这里是5个cell，如果1行有12个cell，则分3次获取形成3个result，避免某个cell的数据量太大，网络拥堵
        scan.setBatch(5);
        //将结果在客户端缓存，优先从cacheBlock中读取数据
        scan.setCacheBlocks(true);
        //获得每个cell中最新2个版本的值
        scan.setMaxVersions(2);

        //通过getScanner查询获取到了表里面所有的数据，是多条数据
        ResultScanner scanner = table.getScanner(scan);
        //遍历ResultScanner 得到数据，数据都是封装在result对象里面了
        for (Result result : scanner) {
            List<Cell> cells = result.listCells();
            for (Cell cell : cells) {
                byte[] family_name = CellUtil.cloneFamily(cell);
                byte[] qualifier_name = CellUtil.cloneQualifier(cell);
                byte[] rowkey = CellUtil.cloneRow(cell);
                byte[] value = CellUtil.cloneValue(cell);
                //判断id和age字段，这两个字段是整形值
                if("age".equals(Bytes.toString(qualifier_name))  || "id".equals(Bytes.toString(qualifier_name))){
                    System.out.println("数据的rowkey为" +  Bytes.toString(rowkey)   +"======数据的列族为" +  Bytes.toString(family_name)+"======数据的列名为" +  Bytes.toString(qualifier_name) + "==========数据的值为" +Bytes.toInt(value));
                }else{
                    System.out.println("数据的rowkey为" +  Bytes.toString(rowkey)   +"======数据的列族为" +  Bytes.toString(family_name)+"======数据的列名为" +  Bytes.toString(qualifier_name) + "==========数据的值为" +Bytes.toString(value));
                }
            }
        }
    }


    @Test
    /**
     * 查询所有的rowkey比0002小的所有的数据
     */
    public void rowFilter() throws IOException {
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        Scan scan = new Scan();
        //获取我们比较对象
        BinaryComparator binaryComparator = new BinaryComparator("0002".getBytes());
        /***
         * rowFilter需要加上两个参数
         * 第一个参数就是我们的比较规则
         * 第二个参数就是我们的比较对象
         */
        RowFilter rowFilter = new RowFilter(CompareFilter.CompareOp.LESS, binaryComparator);
        //为我们的scan对象设置过滤器
        scan.setFilter(rowFilter);
        ResultScanner scanner = table.getScanner(scan);
        for (Result result : scanner) {
            List<Cell> cells = result.listCells();
            for (Cell cell : cells) {
                byte[] rowkey = CellUtil.cloneRow(cell);
                byte[] family_name = CellUtil.cloneFamily(cell);
                byte[] qualifier_name = CellUtil.cloneQualifier(cell);
                byte[] value = CellUtil.cloneValue(cell);
                //判断id和age字段，这两个字段是整形值
                if("age".equals(Bytes.toString(qualifier_name))  || "id".equals(Bytes.toString(qualifier_name))){
                    System.out.println("数据的rowkey为" +  Bytes.toString(rowkey)   +"======数据的列族为" +  Bytes.toString(family_name)+"======数据的列名为" +  Bytes.toString(qualifier_name) + "==========数据的值为" +Bytes.toInt(value));
                }else{
                    System.out.println("数据的rowkey为" +  Bytes.toString(rowkey)   +"======数据的列族为" +  Bytes.toString(family_name)+"======数据的列名为" +  Bytes.toString(qualifier_name) + "==========数据的值为" +Bytes.toString(value));
                }
            }
        }
    }

    /**
     * 通过familyFilter来实现列族的过滤
     * 需要过滤，列族名包含f2
     * f1  f2   hello   world
     */
    @Test
    public void familyFilter() throws IOException {
        Table table = connection.getTable(TableName.valueOf(TABLE_NAME));
        Scan scan = new Scan();
        SubstringComparator substringComparator = new SubstringComparator("f2");
        //通过familyfilter来设置列族的过滤器，列族名称包含“f2”
        FamilyFilter familyFilter = new FamilyFilter(CompareFilter.CompareOp.EQUAL, substringComparator);
        scan.setFilter(familyFilter);
        ResultScanner scanner = table.getScanner(scan);
        for (Result result : scanner) {
            List<Cell> cells = result.listCells();
            for (Cell cell : cells) {
                byte[] family_name = CellUtil.cloneFamily(cell);
                byte[] qualifier_name = CellUtil.cloneQualifier(cell);
                byte[] rowkey = CellUtil.cloneRow(cell);
                byte[] value = CellUtil.cloneValue(cell);
                //判断id和age字段，这两个字段是整形值
                if("age".equals(Bytes.toString(qualifier_name))  || "id".equals(Bytes.toString(qualifier_name))){
                    System.out.println("数据的rowkey为" +  Bytes.toString(rowkey)   +"======数据的列族为" +  Bytes.toString(family_name)+"======数据的列名为" +  Bytes.toString(qualifier_name) + "==========数据的值为" +Bytes.toInt(value));
                }else{
                    System.out.println("数据的rowkey为" +  Bytes.toString(rowkey)   +"======数据的列族为" +  Bytes.toString(family_name)+"======数据的列名为" +  Bytes.toString(qualifier_name) + "==========数据的值为" +Bytes.toString(value));
                }
            }
        }
    }


}
