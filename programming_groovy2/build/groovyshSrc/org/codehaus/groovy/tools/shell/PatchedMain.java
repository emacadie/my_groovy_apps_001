package org.codehaus.groovy.tools.shell;
import groovy.lang.Binding;
import org.codehaus.groovy.tools.shell.Groovysh;
import org.codehaus.groovy.tools.shell.IO;
import org.fusesource.jansi.AnsiConsole;
// workaround for jAnsi problems, (backspace and arrow keys not working)
public class PatchedMain {
public static void main(String[] args) {
AnsiConsole.systemUninstall();
Binding binding = new Binding();
Groovysh groovysh = new Groovysh(binding, new IO());
// Evaluate -e argument, java6 style
if (args != null) {
for (int i = 0; i < args.length; i++) {
if ("-e".equals(args[i]) && args.length >= i + 1) {
String[] lines = args[i + 1].split("\r?\n");
for (int j = 0; j < lines.length; j++) {
System.out.println(lines[j]); // verbose, but useful.
groovysh.execute(lines[j]);
}
}
i++;
}
}
groovysh.run((String) null);
}
}