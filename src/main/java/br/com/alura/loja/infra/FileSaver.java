package br.com.alura.loja.infra;

import java.io.IOException;

import javax.servlet.http.Part;

public class FileSaver {

	private static final String SERVER_PATH = "/home/bruno/loja-alura";

	public String path(Part arquivo, String path) throws IOException {

		String relativePath = path + "/" + arquivo.getSubmittedFileName();

		try {
			String savePath = SERVER_PATH + "/" + relativePath;
			arquivo.write(savePath);
			return relativePath;
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
