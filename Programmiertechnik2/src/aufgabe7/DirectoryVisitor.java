package aufgabe7;

import java.io.File;

public interface DirectoryVisitor {
	
	void enterDirectory(File dir);
	void leaveDiectory(File dir);
	void visitFile(File dir);
}
