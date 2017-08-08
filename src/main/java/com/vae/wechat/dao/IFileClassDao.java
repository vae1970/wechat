package com.vae.wechat.dao;

import com.vae.wechat.model.FileClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IFileClassDao {

	/**
	 * 获取文档分类总数信息
	 * @return 文档分类总数
	 */
	public int getListCount(String queryParam);


	/**
	 * 根据文档分类id获取文档分类信息
	 * @param id 文档分类id
	 * @return 文档分类信息
	 */
	public FileClass load(int id);

	/**
	 * 添加文档分类
	 * @param fileClass 文档分类对象
	 */
	public int add(FileClass fileClass);

	/**
	 * 更新文档分类信息
	 * @param fileClass 文档分类对象
	 * @return 更新是否成功
	 */
	public int update(FileClass fileClass);
	


	/**
	 * 检查是否是父节点
	 *
	 * @param id
	 * @return
	 */
	public List<FileClass> checkFileClassIsParent(@Param("id") int id);

	/**
	 * 根据父id获取全部子节点
	 *
	 * @param parentClassId
	 * @return
	 */
	public List<FileClass> getListByParentClassId(@Param("parentClassId") int parentClassId);

	/**
	 *
	 * @param className
	 * @return
	 */
	public int getFileClassIdByParentClassName(@Param("className") String className);

	public  List<FileClass> getListByType(@Param("archiveType") String archiveType);
}
