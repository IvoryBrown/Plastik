package com.setting.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FolderWriter {
	private String PER_R_N = "\r\n";
	private File homeDirectory;
	private File dBDirectory;
	private String aplicationFloder = "\\AppData\\Local\\Stanicli\\";
	private String dataBaseFloder = "\\AppData\\Local\\Stanicli\\DB\\";
	private String kliensBaseFloder = "\\AppData\\Local\\Stanicli\\KliensName\\";

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
		kliensFolderWriter();
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

		try {
		
			if (DBFileWriter.outputDB().size() == 0) {

				BufferedWriter output = new BufferedWriter(
						new FileWriter(System.getProperty("user.home") + dataBaseFloder + "output.txt"));

				String allSetting = "11" + PER_R_N + "112" + PER_R_N + "113";
				output.write(allSetting);
				output.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private void kliensFolderWriter() {
		dBDirectory = new File(System.getProperty("user.home") + kliensBaseFloder);
		
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
		
		try {
			System.out.println(DBFileWriter.outputKliensName());
			if (DBFileWriter.outputKliensName().length() == 0) {
				System.out.println("1");
				BufferedWriter output = new BufferedWriter(
						new FileWriter(System.getProperty("user.home") + kliensBaseFloder + "kliens_name.txt"));
				
				String allSetting = "kliens_1";
				output.write(allSetting);
				output.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
