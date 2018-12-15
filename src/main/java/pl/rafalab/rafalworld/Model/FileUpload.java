package pl.rafalab.rafalworld.Model;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	private MultipartFile filename;

	public FileUpload(MultipartFile filename) {
		this.filename = filename;
	}

	public MultipartFile getFile() {
		return filename;
	}

	public void setFile(MultipartFile filename) {
		this.filename = filename;
	}
	
	
	

}
