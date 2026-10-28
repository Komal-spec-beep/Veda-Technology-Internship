package day28.multithreadedfilesearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadedFileSearch {

	public static void main(String[] args) {
		File folder = new File("test-files");
		String keyword = "Java";

		if (!folder.exists() || !folder.isDirectory()) {
		    System.out.println("Folder not found!");
		    return;
		}
		File[] files = folder.listFiles();

		if (files == null || files.length == 0) {
		    System.out.println("No files found!");
		    return;
		}
		
		long singleStartTime = System.currentTimeMillis();

		singleThreadedSearch(files, keyword);

		long singleEndTime = System.currentTimeMillis();

		System.out.println(
		    "Single-threaded Search Time: "
		    + (singleEndTime - singleStartTime) + " ms"
		);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		long startTime = System.currentTimeMillis();
		for (File file : files) {
		    if (file.isFile() && file.getName().endsWith(".txt")) {
		        executor.submit(() -> searchInFile(file, keyword));
		    }
		}
		executor.shutdown();

		try {
		    if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
		        executor.shutdownNow();
		    }
		} catch (InterruptedException e) {
		    executor.shutdownNow();
		    Thread.currentThread().interrupt();
		}
		
		long endTime = System.currentTimeMillis();

		System.out.println(
		    "Multithreaded Search Time: " + (endTime - startTime) + " ms"
		);

	}
	
	static void searchInFile(File file, String keyword) {
	    try {
	        int lineNumber = 0;

	        for (String line : Files.readAllLines(file.toPath())) {
	            lineNumber++;

	            if (line.toLowerCase().contains(keyword.toLowerCase())) {
	                System.out.println(
	                    file.getName() + " | Line " + lineNumber + " | " + line
	                );
	            }
	        }

	    } catch (IOException e) {
	        System.out.println("Error reading file: " + file.getName());
	    }
	}
	
	static void singleThreadedSearch(File[] files, String keyword) {
	    for (File file : files) {
	        if (file.isFile() && file.getName().endsWith(".txt")) {
	            searchInFile(file, keyword);
	        }
	    }
	}

}
