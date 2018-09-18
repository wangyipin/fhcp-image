package com.njsecnet.fhcp.image.domain;

public class ProjectVO {


    private  String project_id;
    private  String owner_id;
    private  String name;
    private  String creation_time;
    private  String update_time;
    private  boolean deleted;
    private  String owner_name;
    private  String togglable;
    private  String current_user_role_id;
    private  String repo_count;

    private  MetadataVo metadata;


    public String getProject_id() {
        return project_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public String getName() {
        return name;
    }

    public String getCreation_time() {
        return creation_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public String getTogglable() {
        return togglable;
    }

    public String getCurrent_user_role_id() {
        return current_user_role_id;
    }

    public String getRepo_count() {
        return repo_count;
    }

    public MetadataVo getMetadata() {
        return metadata;
    }


    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void setTogglable(String togglable) {
        this.togglable = togglable;
    }

    public void setCurrent_user_role_id(String current_user_role_id) {
        this.current_user_role_id = current_user_role_id;
    }

    public void setRepo_count(String repo_count) {
        this.repo_count = repo_count;
    }

    public void setMetadata(MetadataVo metadata) {
        this.metadata = metadata;
    }
}
