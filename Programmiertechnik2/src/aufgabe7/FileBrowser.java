package aufgabe7;

// O. Bittel
// 13.4.2011

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileBrowser {

	public static void main(String[] args) {
		String dirname = "/home/julian/Desktop/test";
		if (args.length != 0)
			dirname = args[0];
		File dir = new File(dirname);
		if (!dir.isDirectory())
			throw new IllegalArgumentException(
					"argument should be a directory!");

		System.out.println("/*\n *TEST dirPrint-> print out " + dirname
				+ " recursively\n */");
		dirPrint(dir);
		System.out
				.println("/*\n *TEST dirSearch -> search for extension .txt in "
						+ dirname + "\n */");
		List<String> list = new LinkedList<>();
		dirSearch(dir, ".txt", list);			
	}

	public static void traverse(File file, DirectoryVisitor dv) {
		File[] files = file.listFiles();
		for (File f : files) {
			if (!f.isDirectory()) {
				dv.visitFile(f);
			}
		}
		for (File f : files) {
			if (f.isDirectory()) {
				dv.enterDirectory(f);
				traverse(f, dv);
			}
		}
	}

	public static void dirPrint(File file) {		
		traverse(file, new DirectoryPrintVisitor());

		/*Version 1*/
//		File[] files = file.listFiles();
//		/* first print out all the non directories */
//		for (File f : files) {
//			if (!f.isDirectory())
//				System.out.println("[FILEBROWSER]: $<" + f.getPath());
//		}
//
//		/* then go on traversing recursively through all the directories */
//		for (File f : files) {
//			if (f.isDirectory())
//				dirPrint(f);
//		}

	}

	public static void dirSearch(File file, String extension, List<String> l) {
		DirectorySearchVisitor dv = new DirectorySearchVisitor().setExtension(".txt");
		traverse(file, dv);
		for (String s : dv.getSearchList()) {
			System.out.println("[FILEBROWSER]: $<" + s);
		}	
		/*Version 1*/
//		String path;
//		for (File f : file.listFiles()) {
//			if (!f.isDirectory()) {
//				path = f.getAbsolutePath();
//				if (path.endsWith(extension))
//					l.add(path);
//			} else {
//				dirSearch(f, extension, l);
//			}
//		}
	}
}
