package com.setting.file;

import java.io.File;

public class FolderWriter {
	private File homeDirectory;
	private File dBDirectory;
	private String aplicationFloder = "\\AppData\\Local\\Stanicli\\";
	private String dataBaseFloder = "\\AppData\\Local\\Stanicli\\DB\\";

	public FolderWriter() {
		homeDirectory = new File(System.getProperty("user.home") + aplicationFloder);

		if (!homeDirectory.exists()) {
			System.out.println("creating directory: " + homeDirectory.getName());
			boolean result = false;

			try {
				homeDirectory.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}
		dbFolderWriter();
	}

	private void dbFolderWriter() {
		dBDirectory = new File(System.getProperty("user.home") + dataBaseFloder);

		if (!dBDirectory.exists()) {
			System.out.println("creating directory: " + dBDirectory.getName());
			boolean result = false;

			try {
				dBDirectory.mkdir();
				result = true;
			} catch (SecurityException se) {
				// handle it
			}
			if (result) {
				System.out.println("DIR created");
			}
		}

	}

}
