package com.zhcc.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Create by ZHCC on 2018/9/19
 */
public class UploadAction extends ActionSupport {
    private String title;
    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    private String savepath;

    private String allowTypes;

    public String getAllowTypes() {
        return allowTypes;
    }

    public void setAllowTypes(String allowTypes) {
        this.allowTypes = allowTypes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSavepath() {
        return ServletActionContext.getServletContext().getRealPath(savepath);
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }

    @Override
    public String execute() throws Exception {

        FileOutputStream fos = new FileOutputStream(getSavepath() + "\\" + getUploadFileName());
        FileInputStream fis = new FileInputStream(getUpload());
        byte[] buffer=new byte[1024];
        int len=0;
        while ((len = fis.read(buffer)) > 0) {
            fos.write(buffer,0,len);
        }
        return SUCCESS;
    }

    public String filterType(String[] types) {
        String fileType=getUploadContentType();
        for (String type : types) {
            if (type.equals(fileType)) {
                return null;
            }
        }
        return ERROR;
    }

    public void validate(){
        String filterResult=filterType(getAllowTypes().split(","));
        if (filterResult != null) {
            addFieldError("upload","您要上传的文件类型不正确！");
        }
    }
}
