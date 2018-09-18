package com.njsecnet.fhcp.image.service;


import java.util.Map;

public interface ProjectService {


    /**
     * 根据project 和 repository 名称获取project 和 repository集合数据
     * @param  q 表示project 和 repository 名称获取
     */
    public Map<String,Object> search(String q);


    /**
     * 根据条件获取项目列表
     * @param name 项目名称
     * @param isPublic 是否为私有项目   true私有
     * @param owner 项目所有者
     * @param page 第几页*
     * @param pageSize  每页显示条数
     */
    public Map<String,Object> projectList(String name, boolean isPublic, String owner, String page, String pageSize);


    /**
     * 检查用户提供的项目名称是否已存在
     * @param projectName  用户新建的项目名称
     */
    public String checkProjectNameIsExists(String projectName);
}
