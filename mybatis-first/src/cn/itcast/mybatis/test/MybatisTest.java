package cn.itcast.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class MybatisTest {
	private SqlSessionFactory sqlSessionFactory = null;

	@Test
	public void init() throws Exception {
		// 1. SqlSessionFactoryBuilderを作成
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		// 2. SqlMapConfig.xmlを読み込む
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 3. sqlSessionFactoryを作成
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

		//sqlsessionを作成
		SqlSession sqlSession=this.sqlSessionFactory.openSession();

		//sql文を実行
		User user=sqlSession.selectOne("test.queryUserbyId", 10);

		System.out.print(user.toString());
		//sqlSession解除
				sqlSession.close();
	}

	@Test
	public void testSelectUserByUserName() throws Exception {
		// 1. SqlSessionFactoryBuilderを作成
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		// 2. SqlMapConfig.xmlを読み込む
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 3. sqlSessionFactoryを作成
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

		//sqlsessionを作成
		SqlSession sqlSession=this.sqlSessionFactory.openSession();

		//sql文を実行
		List<User> list=sqlSession.selectList("test.selectUserByUserName", "千葉");

		for (User user : list) {
			System.out.print(user.toString());
		}
		//sqlSession解除
				sqlSession.close();
	}

	@Test

	public void insertUser() throws Exception{
		// 1. SqlSessionFactoryBuilderを作成
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		// 2. SqlMapConfig.xmlを読み込む
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 3. sqlSessionFactoryを作成
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

		//sqlsessionを作成
		SqlSession sqlSession=this.sqlSessionFactory.openSession();

		// ユーザ登録の引数インスタンスの作成
		User user=new User();
		// userに以下の引数を代入
		//username
		user.setUsername("千葉　武蔵");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("千葉県千葉市美浜区打たせ");
		//登録
		sqlSession.insert("insertUser",user);
		//コミット
		sqlSession.commit();

		//sqlSession解除
		sqlSession.close();
	}

}
