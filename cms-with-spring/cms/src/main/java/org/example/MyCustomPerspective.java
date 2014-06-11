package org.example;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.example.spring.HelloService;
import org.hippoecm.frontend.plugin.IPluginContext;
import org.hippoecm.frontend.plugin.config.IPluginConfig;
import org.hippoecm.frontend.plugins.standards.perspective.Perspective;
import org.hippoecm.frontend.service.IconSize;

public class MyCustomPerspective extends Perspective {

    private static final long serialVersionUID = 1L;

    @SpringBean
    private HelloService helloService;

    public MyCustomPerspective(IPluginContext context, IPluginConfig config) {
        super(context, config);
        setOutputMarkupId(true);
        //test global message
        add(new Label("hello-message", helloService.getHelloMessage(null)));
    }

    @Override
    public void renderHead(final IHeaderResponse response) {
        super.renderHead(response);
    }

    @Override
    public ResourceReference getIcon(IconSize type) {
        return new PackageResourceReference(MyCustomPerspective.class, "spring-perspective-" + type.getSize() + ".png");
    }

}