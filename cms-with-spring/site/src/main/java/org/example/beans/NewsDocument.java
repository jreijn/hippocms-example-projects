package org.example.beans;

import java.util.Calendar;

import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoHtml;
import org.hippoecm.hst.content.beans.standard.HippoGalleryImageSetBean;

@Node(jcrType="myspringbasedhippoproject:newsdocument")
public class NewsDocument extends BaseDocument{

    public String getTitle() {
        return getProperty("myspringbasedhippoproject:title");
    }
    
    public String getSummary() {
        return getProperty("myspringbasedhippoproject:summary");
    }
    
    public Calendar getDate() {
        return getProperty("myspringbasedhippoproject:date");
    }

    public HippoHtml getHtml(){
        return getHippoHtml("myspringbasedhippoproject:body");    
    }

    /**
     * Get the imageset of the newspage
     *
     * @return the imageset of the newspage
     */
    public HippoGalleryImageSetBean getImage() {
        return getLinkedBean("myspringbasedhippoproject:image", HippoGalleryImageSetBean.class);
    }


}
