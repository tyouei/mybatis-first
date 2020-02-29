package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
/**
 * Mapperインターフェースの作成基準
 * ①xmlのnamespaceはmapperのインターフェースのフルパス（package+interface）
 * ②Mapperのインターフェース名はxmlで定義されたsql文のIdと同じにすること。
 * ③Mapperのインターフェースのパラメータのタイプはxmlで定義されたsql文のparameterTypeと同じにすること。
 * ④Mapperのインターフェースの戻り値のタイプはxmlで定義されたsql文のresultTypeと同じにすること。
 * @author ei.tyou
 *
 */

public interface UserMapper {
	/**
	 * ユーザＩＤでユーザ情報を取得する。
	 * @param id
	 * @return
	 */
	User queryUserbyId(int id);


	List<User> selectUserByUserName(String username);

}
