package org.great.jbasedao;

import java.util.List;

public interface JBaseDao {
	public abstract List<?> selectAll();//��ѯ���ݱ������е�����
	public abstract boolean deleteBean(int id);//ɾ����Ӧid��������
	public abstract boolean insertBean(Object bean);//�ڱ��в���һ������
	public abstract boolean updateBean(Object bean);//����ĳ���������
}
