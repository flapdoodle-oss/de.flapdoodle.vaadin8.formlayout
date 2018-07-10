package de.flapdoodle.vaadin8;

/*
 * Copyright 2000-2018 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Component;

import de.flapdoodle.vaadin8.client.form.FormLayoutState;

/**
 * FormLayout is a Replacement for Vaadin FormLayout.
 */
public class FormLayout extends AbstractOrderedLayout {

	public FormLayout() {
		super();
		setSpacing(true);
		setMargin(new MarginInfo(true, false));
		setWidth(100, UNITS_PERCENTAGE);
	}

	/**
	 * Constructs a FormLayout and adds the given components to it.
	 *
	 * @see AbstractOrderedLayout#addComponents(Component...)
	 *
	 * @param children
	 *          Components to add to the FormLayout
	 */
	public FormLayout(Component... children) {
		this();
		addComponents(children);
	}

	/**
	 * @deprecated This method currently has no effect as expand ratios are not
	 *             implemented in FormLayout
	 */
	@Override
	@Deprecated
	public void setExpandRatio(Component component, float ratio) {
		super.setExpandRatio(component, ratio);
	}

	/**
	 * @deprecated This method currently has no effect as expand ratios are not
	 *             implemented in FormLayout
	 */
	@Override
	@Deprecated
	public float getExpandRatio(Component component) {
		return super.getExpandRatio(component);
	}

	public void addFullRowComponent(Component component) {
		super.addComponent(component);
		setUseFullRow(component);
	}

	public void setUseFullRow(Component component) {
		getState().useFullRow.put(component, true);
	}

	@Override
	protected FormLayoutState getState() {
		return (FormLayoutState) super.getState();
	}

	@Override
	protected FormLayoutState getState(boolean markAsDirty) {
		return (FormLayoutState) super.getState(markAsDirty);
	}
}