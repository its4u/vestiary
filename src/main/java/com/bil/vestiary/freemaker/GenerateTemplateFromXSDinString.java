package com.bil.vestiary.freemaker;

import com.bil.xsd.parser.XSDAttribute;
import com.bil.xsd.parser.XSDElement;
import org.apache.commons.lang3.StringUtils;

public  class GenerateTemplateFromXSDinString {

    private static String lineSeparator = System.getProperty("line.separator");

    private GenerateTemplateFromXSDinString() {
        throw new IllegalStateException("Utility class");
    }

    public static void printData(XSDElement xsdElement, int level, StringBuilder stringBuilder, MetadataFileForGenerateTemplate metadataFileForGenerateTemplate, String rootElement) {

        String xsi=" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\""+metadataFileForGenerateTemplate.getNamespace()+" "+metadataFileForGenerateTemplate.getXsdFile()+"\"";
        String margin = StringUtils.repeat(" ", level);


        if (xsdElement.getMaxOcurrs()>1) {
            stringBuilder.append(margin+"<#list "+xsdElement.getXpath(true)+" as "+xsdElement.getName()+"Item>");
            stringBuilder.append(lineSeparator);
            margin = StringUtils.repeat(" ", level+2);
            getBaliseStart(xsdElement,stringBuilder,margin,rootElement,xsi);
            getChildrens(xsdElement,stringBuilder,margin,level+4,metadataFileForGenerateTemplate,rootElement);
            margin = StringUtils.repeat(" ", level);
            stringBuilder.append(margin+"</#list>");
            stringBuilder.append(lineSeparator);

        } else {
            getBaliseStart(xsdElement,stringBuilder,margin,rootElement,xsi);
            getChildrens(xsdElement,stringBuilder,margin,level+2,metadataFileForGenerateTemplate,rootElement);
        }

    }

    private static void getBaliseStart(XSDElement xsdElement,StringBuilder stringBuilder,String margin,String rootElement,String xsi) {
        stringBuilder.append(margin + "<" + xsdElement.getName()
                + (xsdElement.getName().equalsIgnoreCase(rootElement) ? xsi : "")
                + printAttributeOfXSDELement(xsdElement)
                + ">"
                + (xsdElement.getChildren().isEmpty() ?
                "<#if ("+ xsdElement.getXpath(false)+")?has_content>"
                        + "${(" + xsdElement.getXpath(false) +  ")!}"
                        +"</#if>"
                        + "</" + xsdElement.getName() + ">"
                : ""));
        stringBuilder.append(lineSeparator);
    }

    private static void getChildrens(XSDElement xsdElement,StringBuilder stringBuilder,String margin,int level,MetadataFileForGenerateTemplate metadataFileForGenerateTemplate, String rootElement) {
        if (!xsdElement.getChildren().isEmpty()) {
            for (XSDElement child : xsdElement.getChildren()) {
                    printData(child, level , stringBuilder,metadataFileForGenerateTemplate,rootElement);
            }
            stringBuilder.append(margin + "</" + xsdElement.getName() + ">");
            stringBuilder.append(lineSeparator);
        }
    }

    private static String printAttributeOfXSDELement(XSDElement element) {
        StringBuilder attribute= new StringBuilder();
        if (element.getAttributes()!=null && !element.getAttributes().isEmpty()){
            attribute.append(" ");
            for (XSDAttribute attr : element.getAttributes()) {
                attribute.append("<#if ("+ element.getXpath(false)+")?has_content>")
                        .append(attr.getName())
                        .append("=\"${")
                        .append(element.getXpath(false))
                        .append(".@")
                        .append(attr.getName())
                        .append("}\" ")
                        .append("</#if>");
            }
        }
        return attribute.toString();
    }

}
