/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *

 *******************************************************************************/
package org.python.pydev.shared_interactive_console.console.ui;

import org.python.pydev.shared_interactive_console.console.InterpreterResponse;
import org.python.pydev.shared_interactive_console.console.ScriptConsolePrompt;

public interface IScriptConsoleListener {

    // Called in the UI thread before command is entered.
    void userRequest(String text, ScriptConsolePrompt prompt);

    // Called out of the UI thread.
    void interpreterResponse(InterpreterResponse response, ScriptConsolePrompt prompt);

    boolean isOnStateWhereCommandHandlingShouldStop(String commandLine);
}
