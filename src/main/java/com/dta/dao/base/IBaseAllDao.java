package com.dta.dao.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseAllDao<T, V>{
	/*
	 * ����һ������
	 */
	public int addObject(T po);
	
	/*
	 * ����id����һ������
	 */
	public int updateObjectById(T po);
	
	/*
	 * ����idɾ��һ������
	 */
	public int deleteObjectById(Serializable id);
	
	/*
	 * ɾ����������
	 */
	public int deleteMultiData(List<Serializable> ids);
	
	/*
	 * ��ѯ���е�����
	 */
	public List<T>getAll();
	
	/*
	 *��ҳ��ѯ 
	 */
	public List<T>getPage();
	
	/*
	 * �õ�����
	 */
	public int getSize();
	
	/*
	 * ����id��ѯһ������
	 */
	public T getObjectById(Serializable id);
	
}