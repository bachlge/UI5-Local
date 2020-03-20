package com.gork.ui5.test.elements;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("ui5-switch")
@JsModule("@ui5/webcomponents/dist/Switch.js")
public class Ui5Switch extends Component {

	private static final Logger LOGGER = LoggerFactory.getLogger(Ui5Switch.class);

	public Ui5Switch() {
		LOGGER.info("constructor ...");
		this.getElement().setProperty("textOn", "Yes");
		this.getElement().setProperty("textOff", "No");
	}

	@PostConstruct
	private void init() {
		LOGGER.info("init ...");
	}

	public void setGraphical(Boolean graphical) {
		this.getElement().setProperty("graphical", graphical);
	}

	public void setChecked(Boolean checked) {
		this.getElement().setProperty("checked", checked);
	}

}
