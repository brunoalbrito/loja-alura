package br.com.alura.loja.infra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;

import javax.servlet.http.Part;

import org.hibernate.validator.constraints.SafeHtml.WhiteListType;


public class FileSaver {

	public static final String SERVER_PATH = "C:\\Users\\StartMeUp\\Documents\\home\\bruno\\loja-alura";

	public String path(Part arquivo, String path) throws IOException {

		String relativePath = path + "/" + arquivo.getSubmittedFileName();

		try {
			String savePath = SERVER_PATH + "/" + relativePath;
			arquivo.write(savePath);
			return relativePath;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void transfer(Path source, OutputStream outputStream) {
		try {
			FileInputStream input = new FileInputStream(source.toFile());
			ReadableByteChannel inputChanne = Channels.newChannel(input);
			WritableByteChannel outputChannel = Channels.newChannel(outputStream);
			ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);
			
			while(inputChanne.read(buffer) != -1) {
				buffer.flip();
				outputChannel.write(buffer);
				buffer.clear();
			}
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
