// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2025 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.editor.youngandroid;

import com.google.appinventor.client.editor.FileEditor;
import com.google.appinventor.client.editor.youngandroid.YaBlocksEditor;
import com.google.appinventor.client.editor.simple.SimpleComponentDatabase;
import com.google.appinventor.shared.rpc.project.ProjectNode;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Editor for displaying the generated YAIL code for a Young Android Form.
 * Currently read-only.
 */
public final class YaCodeEditor extends FileEditor {

    private final TextArea codeArea;
    private final VerticalPanel panel;

    public YaCodeEditor(YaProjectEditor projectEditor, ProjectNode formNode) {
        super(projectEditor, formNode);

        panel = new VerticalPanel();
        panel.setSize("100%", "100%");

        codeArea = new TextArea();
        codeArea.setSize("100%", "100%");
        codeArea.setReadOnly(true);
        codeArea.getElement().setAttribute("style", "font-family: monospace; font-size: 12px;");

        panel.add(codeArea);

        initWidget(panel);
    }

    @Override
    public void onShow() {
        // Logic to refresh code will be handled by YaProjectEditor switching logic for
        // now
    }

    @Override
    public void onHide() {
    }

    @Override
    public void onSave() {
        // Read-only, nothing to save
    }

    @Override
    public void onClose() {
    }

    @Override
    public String getTabText() {
        return "Code";
    }

    public void setText(String text) {
        codeArea.setText(text);
    }

    public static final String EDITOR_TYPE = "Code";

    public void updateCode(YaBlocksEditor blocksEditor) {
        try {
            String yail = blocksEditor.getYail().getContent();
            setText(yail);
        } catch (Exception e) {
            setText("Error generating YAIL: " + e.getMessage());
        }
    }

    @Override
    public String getEditorType() {
        return EDITOR_TYPE;
    }
}
