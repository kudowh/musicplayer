package org.great.jbasedao;

import java.util.List;

public interface JBaseDao {
	public abstract List<?> selectAll();//查询数据表中所有的数据
	public abstract boolean deleteBean(int id);//删除对应id的数据行
	public abstract boolean insertBean(Object bean);//在表中插入一行数据
	public abstract boolean updateBean(Object bean);//更新某个表的数据
}
