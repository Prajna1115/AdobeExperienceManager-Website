package com.adobe.aem.example.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

/**
 * Model for Quick Links component
 */
@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


public interface QuickLinkItem {
    String getLinkLabel();
    String getLinkURL();
}

@Model(adaptables = Resource.class)
public class QuickLinksModel {

    @Inject
    private String title;

    @Inject
    @Named("links")
    private List<QuickLinkItem> quickLinks;

    public List<QuickLinkItem> getQuickLinks() {
        return quickLinks;
    }
}
