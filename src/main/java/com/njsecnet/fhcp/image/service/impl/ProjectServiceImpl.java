package com.njsecnet.fhcp.image.service.impl;

import com.njsecnet.fhcp.image.constant.HarborRestfulApi;
import com.njsecnet.fhcp.image.service.ProjectService;
import com.njsecnet.fhcp.image.util.HttpClient;
import com.njsecnet.fhcp.image.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {


    private Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Override
    public Map<String,Object> search(String q) {


        String httpurl = HarborRestfulApi.api_search;

        if(!StringUtils.isEmpty(q)){
            httpurl = httpurl + "?q="+q;
        }

        Map<String,Object> responseMap = HttpClient.doGet(httpurl);

        return responseMap;
    }

    @Override
    public Map<String,Object> projectList(String name, boolean isPublic, String owner, String page, String pageSize) {

        String httpurl = HarborRestfulApi.api_projects;

        httpurl = httpurl + "?name="+((StringUtils.isEmpty(name))?"":name);

        if(!StringUtils.isEmpty(owner))
        {
            httpurl = httpurl + "&owner="+owner;
        }
        if(!StringUtils.isEmpty(page))
        {
            httpurl = httpurl + "&page="+page;
        }
        if(!StringUtils.isEmpty(pageSize))
        {
            httpurl = httpurl + "&page_size="+pageSize;
        }

        logger.info(httpurl);

        Map<String,Object> responseMap = HttpClient.doGet(httpurl);

        return responseMap;
    }


    @Override
    public String checkProjectNameIsExists(String projectName) {

        if(StringUtils.isEmpty(projectName)){

            return "404";
        }

        String httpurl = HarborRestfulApi.api_project_name_isExists+"?project_name="+projectName;

        String responseString = HttpClient.doHead(httpurl);

        return responseString;
    }
}
