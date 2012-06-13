package com.orca.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtils {
	protected Log log = LogFactory.getLog(this.getClass());
	private static final String newLine = "\r\n";

	public String readFile(File file) throws IOException {
		StringBuilder builder = new StringBuilder();
		BufferedReader in = null;
		try {
			String string = null;
			in = new BufferedReader(new FileReader(file));
			while ((string = in.readLine()) != null) {
				builder.append(string + newLine);
			}
		} catch (IOException e) {
			log.debug("Error reading file " + file.getName() + "......." + e);
			throw new IOException(e);
		} finally {
			IOUtils.closeQuietly(in);
		}
		return builder.toString();
	}

	public void writeFile(File file, String string) throws IOException {
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(file);
			stream.write(string.getBytes());
			stream.flush();
		} catch (IOException e) {
			log.debug("Error writing " + file.getName() + " to disk...." + e);
			throw new IOException(e);
		} finally {
			IOUtils.closeQuietly(stream);
		}
	}

}
