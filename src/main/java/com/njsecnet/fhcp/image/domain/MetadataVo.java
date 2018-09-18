package com.njsecnet.fhcp.image.domain;

public class MetadataVo {

    private  String  isPublic;
    private  String enable_content_trust;
    private  String prevent_vulnerable_images_from_running;
    private  String prevent_vulnerable_images_from_running_severity;
    private  String automatically_scan_images_on_push;


    public String getIsPublic() {
        return isPublic;
    }

    public String getEnable_content_trust() {
        return enable_content_trust;
    }

    public String getPrevent_vulnerable_images_from_running() {
        return prevent_vulnerable_images_from_running;
    }

    public String getPrevent_vulnerable_images_from_running_severity() {
        return prevent_vulnerable_images_from_running_severity;
    }

    public String getAutomatically_scan_images_on_push() {
        return automatically_scan_images_on_push;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public void setEnable_content_trust(String enable_content_trust) {
        this.enable_content_trust = enable_content_trust;
    }

    public void setPrevent_vulnerable_images_from_running(String prevent_vulnerable_images_from_running) {
        this.prevent_vulnerable_images_from_running = prevent_vulnerable_images_from_running;
    }

    public void setPrevent_vulnerable_images_from_running_severity(String prevent_vulnerable_images_from_running_severity) {
        this.prevent_vulnerable_images_from_running_severity = prevent_vulnerable_images_from_running_severity;
    }

    public void setAutomatically_scan_images_on_push(String automatically_scan_images_on_push) {
        this.automatically_scan_images_on_push = automatically_scan_images_on_push;
    }
}
