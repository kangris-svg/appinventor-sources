// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2025 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.editor.youngandroid.actions;

import com.google.appinventor.client.Ode;
import com.google.appinventor.client.editor.youngandroid.DesignToolbar;
import com.google.gwt.user.client.Command;

/**
 * Command to switch to the Code Editor.
 */
public class SwitchToCodeEditorAction implements Command {
  @Override
  public void execute() {
    long projectId = Ode.getInstance().getCurrentYoungAndroidProjectId();
    String currentScreen = Ode.getInstance().getDesignToolbar().getCurrentProject().currentScreen;
    Ode.getInstance().getDesignToolbar().switchToScreen(projectId, currentScreen, DesignToolbar.View.CODE);
  }
}
