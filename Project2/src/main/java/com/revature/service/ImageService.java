package com.revature.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.revature.util.SecurityUtil;

/**
 * This service is responsible for performing business logic for exchanges between
 * Amazon's S3 service. 
 * 
 * @author Davin Merry
 */

@Service
public class ImageService {
	/*
	 * Important information is below:
	 */
	private String accessKey = "AKIA3YVHFNGDBJ55TJU7";
	private String secretAccessKey = "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";
	private String region = "us-east-2";
	private String bucketName = "gigan-media-bucket";
	private String subDirectory = "profile_images/";
	
	/**
	 * Uploads a file to Amazon's S3 service.
	 * 
	 * @param f The <code>InputStream</code> to use as file data.
	 * @param fName The filename to give it.
	 * @param fileType The extension name of the file.
	 * @param size Explicit size of the file being uploaded.
	 * @return The URL linked to the file that was just uploaded.
	 */
	public String uploadProfile(InputStream f, String fName, String fileType, long size) {
		//Create and connect to Amazon S3 using our credentials.
		BasicAWSCredentials awsCred = new BasicAWSCredentials(accessKey, secretAccessKey);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard()
				.withRegion(region).withCredentials(new AWSStaticCredentialsProvider(awsCred)).build();
		
		//Hash the user's email. We will use this for our file's unique name.
		fName = new SecurityUtil().hashMd5(fName);
		
		//Create a new ObjectMetadata and store our file size there.
		//It is required if we want to upload a pure InputStream as our file.
		ObjectMetadata md = new ObjectMetadata();
		md.setContentLength(size);
		
		//Put our InputStream for upload request using our bucket, directory, 
		PutObjectRequest uploadReq = new PutObjectRequest(bucketName, subDirectory + fName + "." + fileType, f, md);
		uploadReq.setCannedAcl(CannedAccessControlList.PublicRead);
		
		//Finally, we put our upload request into the bucket.
		s3.putObject(uploadReq);
		System.out.println("Completed file upload (" + fName + ", " + size + " bytes)");
		System.out.println("Returning new URL...");
		
		//We will then return our newly constructed URL to pass down to the controller that called this service.
		String constructedURL = "https://" + bucketName + ".s3.us-east-2.amazonaws.com/" + subDirectory + fName + "." + fileType;
		return constructedURL;
	}
}
