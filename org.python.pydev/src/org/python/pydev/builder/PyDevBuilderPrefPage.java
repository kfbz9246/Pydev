/*
 * Created on Feb 1, 2005
 *
 * @author Fabio Zadrozny
 */
package org.python.pydev.builder;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.python.pydev.plugin.PydevPlugin;
import org.python.pydev.plugin.PydevPrefs;
import org.python.pydev.utils.LabelFieldEditor;

/**
 * @author Fabio Zadrozny
 */
public class PyDevBuilderPrefPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    public static final boolean DEFAULT_USE_PYDEV_BUILDERS = true;
    public static final String USE_PYDEV_BUILDERS = "USE_PYDEV_BUILDERS";

    /**
     * @param style
     */
    public PyDevBuilderPrefPage() {
        super(GRID);
        setPreferenceStore(PydevPlugin.getDefault().getPreferenceStore());
        setDescription("PyDev builders");
    }

    /**
     * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
     */
    protected void createFieldEditors() {
        Composite p = getFieldEditorParent();
        
        String s = "WARNING: \n\n" +
        		"PyDev builders are required for many features \n" +
        		"provided by Pydev such as:\n" +
        		"\n" +
        		"- Code completion\n" +
        		"- PyLint\n" +
        		"- TODO tasks\n" +
        		"\n" +
        		"So, if you choose to disable it, note that the features \n" +
        		"mentioned above may not work as expected or may even not \n" +
        		"work at all (use at your own risk).\n";
        
        addField(new LabelFieldEditor("LabelFieldEditor", s, p));
        addField(new BooleanFieldEditor(USE_PYDEV_BUILDERS, "Use builders?", p));
    }

    /**
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    public void init(IWorkbench workbench) {
    }

    public static boolean usePydevBuilders() {
        return PydevPrefs.getPreferences().getBoolean(USE_PYDEV_BUILDERS);
    }

}
