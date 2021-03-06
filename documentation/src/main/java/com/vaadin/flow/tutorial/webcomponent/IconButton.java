package com.vaadin.flow.tutorial.webcomponent;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.tutorial.annotations.CodeFor;

@CodeFor("web-components/creating-java-api-for-a-web-component.asciidoc")
@Tag("vaadin-button")
@HtmlImport("bower_components/vaadin-button/vaadin-button.html")
@HtmlImport("bower_components/vaadin-icons/vaadin-icons.html")
public class IconButton extends Component {

    private VaadinIcon icon;

    public IconButton(VaadinIcon icon) {
        setIcon(icon);
    }

    public void setIcon(VaadinIcon icon) {
        this.icon = icon;
        getElement().removeAllChildren();
        Element iconElement = new Element("iron-icon");
        // @formatter:off
        iconElement.setAttribute("icon", "vaadin:" + icon.name().toLowerCase().replace("_", "-"));
        // @formatter:on
        getElement().appendChild(iconElement);

        Component iconComponent = icon.create();
        getElement().removeAllChildren();
        getElement().appendChild(iconComponent.getElement());

    }

    public void addClickListener(
            ComponentEventListener<ClickEvent<IconButton>> listener) {
        addListener(ClickEvent.class, (ComponentEventListener) listener);
    }

    public VaadinIcon getIcon() {
        return icon;
    }
}
