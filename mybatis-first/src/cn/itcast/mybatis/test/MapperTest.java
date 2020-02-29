package cn.itcast.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.User;

public class MapperTest {

	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void init() throws IOException{
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		// 2. SqlMapConfig.xmlを読み込む
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 3. sqlSessionFactoryを作成
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}

	@Test
	public void testQueryUserbyId(){
		//sqlSessionの取得
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//sqlSessionからMapper代理オブジェクトを取得する。
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

		//ユーザＩＤで検索
		User user=userMapper.queryUserbyId(10);

		System.out.print(user.toString());

		sqlSession.close();
	}

	@Test
	public void testSelectUserByUserName(){
		//sqlSessionの取得
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//sqlSessionからMapper代理オブジェクトを取得する。
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		//
		List<User> list=userMapper.selectUserByUserName("千葉");

		for(User user:list){
			System.out.println(user);
		}
	}
}
