package com.adobe.aem.example.core.models;



import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 * Model to represent individual Quick Link items
 */
@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinkModel {

    @ValueMapValue
    private String linkLabel;

    @ValueMapValue
    private String linkURI;

    public String getLinkLabel() {
        return linkLabel;
    }

    public String getLinkURL() {
        return linkURI;
    }
}
