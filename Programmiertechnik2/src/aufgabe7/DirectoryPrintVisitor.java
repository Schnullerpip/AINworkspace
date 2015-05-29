package aufgabe7;

import java.io.File;

public class DirectoryPrintVisitor implements DirectoryVisitor {
	private int indentation = 0;
	
	void printIndentation(){
		System.out.print("[FILEBROWSER]: $<");
		for(int i = 0; i < indentation; i++){
			System.out.print("\t");
		}
	}

	@Override
	public void enterDirectory(File dir) {
		indentation++;
		visitFile(dir);
	}

	@Override
	public void leaveDiectory(File dir) {
		indentation--;
		visitFile(dir);
	}

	@Override
	public void visitFile(File dir) {
		printIndentation();
		String isFile = dir.isFile() ? "->" : "/";
		System.out.print(isFile + dir.getName()+"\n");

	}

}
