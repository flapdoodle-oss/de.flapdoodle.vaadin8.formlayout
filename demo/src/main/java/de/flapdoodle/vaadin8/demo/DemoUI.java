package de.flapdoodle.vaadin8.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.flapdoodle.vaadin8.FormLayout;

@Theme("demo")
@Title("Flapdoodle FormLayout Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout all = new VerticalLayout();

		FormLayout formLayout = new FormLayout();
		formLayout.setWidthUndefined();
		// formLayout.setSizeFull();

		formLayout.addComponent(new TextField("Name"));
		formLayout.addComponent(new DateField("Birthday"));
		TextField fullSizeTextField = new TextField("Full");
		fullSizeTextField.setWidth(100, Unit.PERCENTAGE);
		formLayout.addFullRowComponent(fullSizeTextField);
		Button button = fullSizeButton("Help Me");

		VerticalLayout vertical = new VerticalLayout(button);
		vertical.setSizeFull();
		formLayout.addFullRowComponent(vertical);

		all.addComponent(formLayout);
		all.addComponent(fullSizeButton("outer"));

		setContent(all);
	}

	private static Button fullSizeButton(String caption) {
		Button ret = new Button(caption);
		ret.setSizeFull();
		return ret;
	}
}
