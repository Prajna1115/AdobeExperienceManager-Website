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
public class QuickLinksModel {

    @ValueMapValue
    private String title;

    @ChildResource(name = "quickLinks")
    private List<LinkModel> quickLinks;

    public String getTitle() {
        return title;
    }

    public List<LinkModel> getQuickLinks() {
        if (quickLinks != null) {
            List<LinkModel> reversed = new ArrayList<>(quickLinks);
            Collections.reverse(reversed);
            return reversed;
        }
        return Collections.emptyList();
    }
}

