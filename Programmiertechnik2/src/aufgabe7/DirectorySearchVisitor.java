package aufgabe7;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class DirectorySearchVisitor implements DirectoryVisitor {
	List<String> list = new LinkedList<>();
	String extension;

	public String getExtension() {
		return extension;
	}

	public DirectorySearchVisitor setExtension(String extension) {
		this.extension = extension;
		return this;
	}

	public List<String> getSearchList() {
		return list;
	}

	public DirectorySearchVisitor clearSearchList() {
		list = new LinkedList<>();
		return this;
	}

	@Override
	public void enterDirectory(File dir) {
		// bleibt leer

	}

	@Override
	public void leaveDiectory(File dir) {
		// bleibt leer

	}

	@Override
	public void visitFile(File dir) {
		if (dir.getPath().endsWith(extension))
			list.add(dir.getAbsolutePath());
	}

}
