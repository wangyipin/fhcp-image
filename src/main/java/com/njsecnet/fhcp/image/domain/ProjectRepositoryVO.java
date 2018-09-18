package com.njsecnet.fhcp.image.domain;

public class ProjectRepositoryVO {

    private  ProjectVO projectVO;

    private RepositoryVO repositorieVO;


    public ProjectVO getProjectVO() {
        return projectVO;
    }

    public RepositoryVO getRepositorieVO() {
        return repositorieVO;
    }


    public void setProjectVO(ProjectVO projectVO) {
        this.projectVO = projectVO;
    }

    public void setRepositorieVO(RepositoryVO repositorieVO) {
        this.repositorieVO = repositorieVO;
    }
}
