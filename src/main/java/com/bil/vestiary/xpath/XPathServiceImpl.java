package com.bil.vestiary.xpath;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class XPathServiceImpl implements XPathService {

    private static Logger logger = Logger.getLogger(XPathServiceImpl.class);

    private DocumentBuilderFactory builderFactory;
    private TransformerFactory transformerFactory;
    private Transformer transformer;

    public XPathServiceImpl() {
        this.builderFactory = DocumentBuilderFactory.newInstance();

        try {
            this.transformerFactory= TransformerFactory.newInstance();
            this.transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "http://www.w3.org/2001/XMLSchema-instance");
            this.transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
           logger.error(e.getMessage());
        }

    }

    public Document parseMessage(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        return builder.parse(inputStream);

    }

    public String getNodeValue(Document document,String expression) {
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
            return nodeList.item(0).getChildNodes().item(0).getNodeValue();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "no value";
        }
    }

    public void setNodeValue(Document document,String expression,String value) {
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
            nodeList.item(0).getChildNodes().item(0).setNodeValue(value);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }


    public InputStream document2InputStream(Document document) throws IOException, TransformerException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Source xmlSource = new DOMSource(document);
        Result outputTarget = new StreamResult(outputStream);
        this.transformer.transform(xmlSource, outputTarget);
        return new ByteArrayInputStream(outputStream.toByteArray());

    }
}
