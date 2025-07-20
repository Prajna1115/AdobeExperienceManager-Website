package com.adobe.aem.example.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = "demobusinessmodel/components/header"
)
public class GlobalHeader {

    @ValueMapValue
    private String logoPath;


    @ValueMapValue
    private String phone;

    @ValueMapValue
    private String email;

    @ValueMapValue
    private String location;

    @ValueMapValue
    private String quoteLink;

    @ChildResource(name = "navigationItems")
    private List<Resource> navItems;

    private List<NavigationItem> navigationList;

    @PostConstruct
    protected void init() {
        navigationList = new ArrayList<>();
        if (navItems != null) {
            for (Resource navItem : navItems) {
                String title = navItem.getValueMap().get("title", String.class);
                String anchor = navItem.getValueMap().get("anchor", String.class); // e.g., #home
                navigationList.add(new NavigationItem(title, anchor));
            }
        }
    }

    public String getLogoPath() { return logoPath; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getLocation() { return location; }
    public String getQuoteLink() { return quoteLink; }
    public List<NavigationItem> getNavigationItems() { return navigationList; }

    public static class NavigationItem {
        private final String title;
        private final String anchor;

        public NavigationItem(String title, String anchor) {
            this.title = title;
            this.anchor = anchor;
        }

        public String getTitle() { return title; }
        public String getAnchor() { return anchor; }
    }
}
