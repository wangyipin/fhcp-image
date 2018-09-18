package com.njsecnet.fhcp.image.domain;

public class RepositoryVO {

    private  String project_id;
    private  String project_name;
    private  String project_public;
    private  String repository_name;
    private  String pull_count;
    private  String tags_count;

    public String getProject_id() {
        return project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getProject_public() {
        return project_public;
    }

    public String getRepository_name() {
        return repository_name;
    }

    public String getPull_count() {
        return pull_count;
    }

    public String getTags_count() {
        return tags_count;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setProject_public(String project_public) {
        this.project_public = project_public;
    }

    public void setRepository_name(String repository_name) {
        this.repository_name = repository_name;
    }

    public void setPull_count(String pull_count) {
        this.pull_count = pull_count;
    }

    public void setTags_count(String tags_count) {
        this.tags_count = tags_count;
    }
}
