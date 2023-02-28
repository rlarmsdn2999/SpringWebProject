package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {
	@GetMapping("uploadForm")
	public void uploadForm() {
		System.out.println("upload form");
	}

	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {

		String uploadFolder = "C:\\upload";

		for (MultipartFile multipartFile : uploadFile) {

			System.out.println("--------------------------------------");
			System.out.println("Upload File Name: " + multipartFile.getOriginalFilename());
			System.out.println("Upload File Size: " + multipartFile.getSize());

			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

			try {
				multipartFile.transferTo(saveFile); // ���� ����
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}

	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		System.out.println("Upload Ajax!!");
	}

	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) {
		System.out.println("Update Ajax POST...............");

		List<AttachFileDTO> list = new ArrayList<>();

		String uploadFolder = "C:\\upload";
		String uploadFolderPath = getFolder();

		// make folder ----------
		File uploadPath = new File(uploadFolder, uploadFolderPath); // uploadFolder �ؿ� getFolder�� ���� ��η� File ��ü ����
		System.out.println("upload Path : " + uploadPath);

		boolean isuploadPath = uploadPath.exists();
		if (isuploadPath == false) {
			uploadPath.mkdirs(); // make yyyy/MM/dd folder
		}

		for (MultipartFile multipartFile : uploadFile) {

			AttachFileDTO attachDTO = new AttachFileDTO();

			System.out.println("--------------------------------------");
			System.out.println("Upload File Name: " + multipartFile.getOriginalFilename());
			System.out.println("Upload File Size: " + multipartFile.getSize());

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has File Path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			System.out.println("Only file name : " + uploadFileName);

			UUID uuid = UUID.randomUUID();
			String uuid_uploadFileName = uuid.toString() + "_" + uploadFileName;

			attachDTO.setFileName(uploadFileName);
			attachDTO.setUuid(uuid.toString());
			attachDTO.setUploadPath(uploadFolderPath);

			// File saveFile = new File(uploadFolder, uploadFileName);
			// File saveFile = new File(uploadPath, uploadFileName);

			try {
				File saveFile = new File(uploadPath, uuid_uploadFileName);
				multipartFile.transferTo(saveFile);

				// check image type file
				if (checkImageType(saveFile)) {
					attachDTO.setImage(true);

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uuid_uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}

				// add to list
				list.add(attachDTO);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// ���� ��¥�� ��θ� ���ڿ��� �����ϴ� �Լ�
	private String getFolder() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);

		return str.replace("-", File.separator); // ���� ��η� ������ �� ��ȯ��
	}

	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@PostMapping(value = "/uploadAjaxAction")
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		System.out.println("Update Ajax POST...............");

		String uploadFolder = "C:\\upload";
		String uploadFolderPath = getFolder();

		// make folder ----------
		File uploadPath = new File(uploadFolder, uploadFolderPath); // uploadFolder �ؿ� getFolder�� ���� ��η� File ��ü ����
		System.out.println("upload Path : " + uploadPath);

		boolean isuploadPath = uploadPath.exists();
		if (isuploadPath == false) {
			uploadPath.mkdirs(); // make yyyy/MM/dd folder
		}

		for (MultipartFile multipartFile : uploadFile) {

			System.out.println("--------------------------------------");
			System.out.println("Upload File Name: " + multipartFile.getOriginalFilename());
			System.out.println("Upload File Size: " + multipartFile.getSize());

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has File Path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			System.out.println("Only file name : " + uploadFileName);

			UUID uuid = UUID.randomUUID();
			String uuid_uploadFileName = uuid.toString() + "_" + uploadFileName;

			try {
				File saveFile = new File(uploadPath, uuid_uploadFileName);
				multipartFile.transferTo(saveFile);

				// check image type file
				if (checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uuid_uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) { // Ư�� ������ �̸��� �޾Ƽ� �̹��� �����͸� �����ϴ� �ڵ�
		System.out.println("fileName : " + fileName); // fileName�� ������ ���

		File file = new File("c:\\upload\\" + fileName);

		System.out.println("file : " + file);

		ResponseEntity<byte[]> result = null;

		try {
			HttpHeaders header = new HttpHeaders();

			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName) {
		System.out.println("download file : " + fileName);

		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);

		System.out.println("resource : " + resource);

		// �ٿ�ε� ���� ������ ���� ��
		if (resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// HttpHeaders ��ü�� �̿��ؼ� �ٿ�ε� �� ������ �̸��� ó���ϵ��� ��
		String resourceName = resource.getFilename();

		// remove UUID
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

		HttpHeaders headers = new HttpHeaders();

		try {

			String downloadName = null;

			if (userAgent.contains("Trident")) {
				System.out.println("IE browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			} else if (userAgent.contains("Edge")) {
				System.out.println("Edge browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");

				System.out.println("Edge name : " + downloadName);
			} else {
				System.out.println("Chrome browser");
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}

			// Content-Disposition�� attachment�� �ִ� ���, �ڿ� ���� fileName�� �Բ� Body�� ���� ���� �ٿ�ε�
			// ������� �ǹ�
			headers.add("Content-Disposition", "attachment; fileName=" + downloadName);
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		System.out.println("deleteFile: " + fileName);
		
		File file;
		
		try {
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			
			file.delete();
			
			//�̹��� �����̶��, ���� �̹����� �����	
			if(type.equals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				
				System.out.println(largeFileName);
				
				file = new File(largeFileName);
				file.delete();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}
}