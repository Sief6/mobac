package mobac.gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringWriter;
import java.lang.reflect.Method;

import javax.swing.JOptionPane;

import org.apache.axis2.description.java2wsdl.bytecode.ParamNameExtractor;

import mobac.program.beanshell.Tools;

public class HelpAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		StringWriter sw = new StringWriter();
		sw.append("<html>");
		sw.append("<h2>Available tools function:</h2>");

		Method[] methods = Tools.class.getMethods();

		for (Method m : methods) {
			if (!Tools.class.equals(m.getDeclaringClass()))
				continue;
			sw.append("<pre>");
			sw.append(getClassName(m.getReturnType()) + " Tools." + m.getName() + "(");
			Class<?>[] params = m.getParameterTypes();
			String[] names = ParamNameExtractor.getParameterNamesFromDebugInfo(m);
			int last = params.length - 1;
			for (int i = 0; i < params.length; i++) {
				sw.append(getClassName(params[i]));
				if (names != null)
					sw.append(" " + names[i]);
				if (i != last)
					sw.append(", ");
			}
			sw.append(")</pre>");
		}

		sw.append("</html>");
		JOptionPane.showMessageDialog(null, sw.toString(), "Help", JOptionPane.PLAIN_MESSAGE);
	}

	private String getClassName(Class<?> clazz) {
		if (clazz.isArray()) {
			String name = clazz.getName();
			switch (name.charAt(1)) {
			case 'B':
				return "byte[]";
			case 'C':
				return "char[]";
			case 'D':
				return "double[]";
			case 'F':
				return "float[]";
			case 'I':
				return "int[]";
			case 'J':
				return "long[]";
			case 'L':
				return "Object";
			case 'S':
				return "short[]";
			case 'Z':
				return "boolean[]";
			default:
				return "unknown[]";
			}
		} else
			return clazz.getSimpleName();
	}
}
