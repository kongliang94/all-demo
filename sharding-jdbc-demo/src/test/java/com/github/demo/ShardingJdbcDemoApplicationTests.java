package com.github.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.demo.entity.Goods;
import com.github.demo.entity.SysDict;
import com.github.demo.entity.User;
import com.github.demo.mapper.GoodsMapper;
import com.github.demo.mapper.SysDictMapper;
import com.github.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ShardingJdbcDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	GoodsMapper goodsMapper;

	@Autowired
	UserMapper userMapper;

	@Autowired
	SysDictMapper sysDictMapper;

	/**
	 * Sharding-JDBC对水平分表
	 */
	@Test
	void addGood() {
		Goods good = new Goods();
		good.setGname("小米手机");
		good.setUserId(100L);
		good.setGstatus("已发布");
		goodsMapper.insert(good);
	}
	@Test
	void addGoods() {
		for (int i = 0; i < 10; i++){
			Goods good = new Goods();
			good.setGname("小米手机" + i);
			good.setUserId(i+1L);
			good.setGstatus("已发布");
			goodsMapper.insert(good);
		}
	}

	@Test
	void getGood(){
		QueryWrapper queryWrapper=new QueryWrapper();
		queryWrapper.eq("gid",558330457536593921L);
		// Logic SQL: SELECT  gid,gname,user_id,gstatus  FROM goods WHERE  gid = ?
		// Actual SQL: g1 ::: SELECT  gid,gname,user_id,gstatus  FROM goods_2 WHERE  gid = ? ::: [558330457536593921]
		// 逻辑上查的goods实际查询goods_2
		Optional<Goods> good = Optional.ofNullable(goodsMapper.selectOne(queryWrapper));
		System.out.println(good.toString());
	}

	/**
	 * 多数据源
	 */
	@Test
	void addUser(){
		User user = new User();
		user.setUsername("琳妹妹");
		user.setUstatus("0");
		userMapper.insert(user);
	}

	@Test
	void getUser(){
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		//此处请填写自己程序生成的ID
		queryWrapper.eq("user_id",558623160178573312L);
		User good = userMapper.selectOne(queryWrapper);
		System.out.println(good.toString());
	}

	/**
	 * 下面是公共表测试方法, 操作公共表时，例如增加和删除操作时，会修改所有数据库中的这张表。
	 */
	@Test
	void addDict(){
		SysDict myDict = new SysDict();
		myDict.setDictName("已启用");
		myDict.setDictCode("1");
		sysDictMapper.insert(myDict);
	}

	@Test
	void deleteDict(){
		QueryWrapper<SysDict> wrapper = new QueryWrapper<SysDict>();
		wrapper.eq("dict_id","");
		sysDictMapper.delete(wrapper);
	}

}
