package com.bil.vestiary.freemaker;

public class MetadataFileForGenerateTemplate {

    private String templateID;

    private String templateName;

    private String msgType;

    private String namespace;

    private String xsdFile;

    public MetadataFileForGenerateTemplate(String templateID, String templateName, String msgType, String namespace) {
        this.templateID = templateID;
        this.templateName = templateName;
        this.msgType = msgType;
        this.namespace = namespace;
    }

    public String getTemplateID() {
        return templateID;
    }

    public void setTemplateID(String templateID) {
        this.templateID = templateID;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getXsdFile() {
        return xsdFile;
    }

    public void setXsdFile(String xsdFile) {
        this.xsdFile = xsdFile;
    }

    @Override
    public String toString() {
        return "MetadataFileForGenerateTemplate{" +
                "templateID='" + templateID + '\'' +
                ", templateName='" + templateName + '\'' +
                ", msgType='" + msgType + '\'' +
                ", namespace='" + namespace + '\'' +
                ", xsdFile='" + xsdFile + '\'' +
                '}';
    }
}
