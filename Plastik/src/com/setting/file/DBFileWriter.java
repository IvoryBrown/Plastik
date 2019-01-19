package com.setting.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class DBFileWriter {
	private static String PER_R_N = "\r\n";
	private static Cipher desCipher;
	private static SecretKey myDesKey;
	private static byte[] textEncrypted;
	private static String url;
	private static String name;
	private static String password;
	private static String dataBaseFloder = "\\AppData\\Local\\Stanicli\\DB\\";

	public static void writeDB(String url, String name, String password) {
		try {
			BufferedWriter output = new BufferedWriter(
					new FileWriter(System.getProperty("user.home") + dataBaseFloder + "output.txt"));
			if (password != null) {
				String allSetting = url + PER_R_N + name + PER_R_N + password;
				output.write(allSetting);
			}
			if (password == null) {
				String allSetting = url + PER_R_N + name;
				output.write(allSetting);
			}
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		DBFileWriter.url = url;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		DBFileWriter.name = name;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		DBFileWriter.password = password;
	}

}
