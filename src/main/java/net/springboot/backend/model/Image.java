package net.springboot.backend.model;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class Image {
    private String FileName;

    private MultipartFile Image;

    private String Type;

    public Image(String fileName, MultipartFile image, String type) {
        FileName = fileName;
        Image = image;
        Type = type;
    }

    public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public MultipartFile getImage() {
        return Image;
    }

    public void setImage(MultipartFile image) {
        Image = image;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    
}
