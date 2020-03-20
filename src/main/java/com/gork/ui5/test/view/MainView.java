package com.gork.ui5.test.view;

import com.gork.ui5.test.elements.Ui5Switch;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@Route
//@CssImport("./styles/styles.css")
public class MainView extends VerticalLayout {

    public MainView() {

    	Ui5Switch ui5switch = new Ui5Switch();

        add(ui5switch);
    }

}
