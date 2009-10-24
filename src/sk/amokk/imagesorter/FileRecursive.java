package sk.amokk.imagesorter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileRecursive extends File {

	private static final long serialVersionUID = 1L;

	private File startDir;
	private List<File> list = new ArrayList<File>();

	public FileRecursive(String pathname) {
		super(pathname);
		this.startDir = new File(pathname);
	}


	public  File[] listFilesRecursive() {
		return listFilesRecursive(startDir);
	}
	
	private File[] listFilesRecursive(File start) {
		
		File[] filesAndDirs = start.listFiles();
		list.addAll(Arrays.asList(filesAndDirs));
		
		for (File file : filesAndDirs) {
			if (file.isDirectory() && file.canRead() && (file != null)) //TODO should be exceptions 
				listFilesRecursive(file);
		}
		return (File[])(list.toArray(new File[list.size()]));
	}
	
	public File[] listFilesRecursive(FilenameFilter filter) {
		File ss[] = listFilesRecursive();
		if (ss == null) return null;
		List<File> v = new ArrayList<File>();
		for (int i = 0 ; i < ss.length ; i++) {
		    if ((filter == null) || filter.accept(this, ss[i].getPath())) {
		    	v.add(ss[i]);
		    }
		}
		return (File[])(v.toArray(new File[v.size()]));
	}
	
	

	
}
