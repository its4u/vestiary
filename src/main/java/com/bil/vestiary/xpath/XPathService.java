package com.bil.vestiary.xpath;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.InputStream;

@Service
public interface XPathService {

    public Document parseMessage(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException;

    public String getNodeValue(Document document,String expression);

    public void setNodeValue(Document document,String expression,String value);

    public InputStream document2InputStream(Document document) throws IOException, TransformerException;

}
