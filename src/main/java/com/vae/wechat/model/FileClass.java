package com.vae.wechat.model;

/**
 * 文档分类表
 * @author Jerry
 *
 */

public class FileClass {

	/**
	 * id
	 */
	private int id;
    /**
     * 分类名称
     */
    private String className;

	/**
	 * 父分类ID(顶级分类0)
	 */
	private int parentClassID = 0;
    /**
     * 父分类名称
     */
    private String parentClassName;

	/**
	 * 备注
	 */
	private String remark;

	public FileClass() {
	}

	public FileClass(int id, int parentClassID, String className, String parentClassName, String remark) {
		super();
		this.id = id;
		this.className = className;
        this.parentClassID = parentClassID;
        this.parentClassName = parentClassName;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getParentClassID() {
		return parentClassID;
	}

	public void setParentClassID(int parentClassID) {
		this.parentClassID = parentClassID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    public String getParentClassName() {
        return parentClassName;
    }

    public void setParentClassName(String parentClassName) {
        this.parentClassName = parentClassName;
    }
}
