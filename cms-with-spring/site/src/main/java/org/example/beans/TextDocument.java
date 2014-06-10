package org.example.beans;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;

@Node(jcrType="myspringbasedhippoproject:textdocument")
public class TextDocument extends BaseDocument{
    
    public String getTitle() {
        return getProperty("myspringbasedhippoproject:title");
    }

    public String getSummary() {
        return getProperty("myspringbasedhippoproject:summary");
    }
    
    public HippoHtml getHtml(){
        return getHippoHtml("myspringbasedhippoproject:body");    
    }

}
