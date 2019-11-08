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
	private String accessKey = System.getenv("AWS_ACCESS_KEY");
	private String secretAccessKey = System.getenv("AWS_SECRET_KEY");
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
		
		//Put our InputStream for upload request using our bucket, directory, file name (w/ file type), InputStream, and metadata.
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
	
	/**
	 * Calls the <code>uploadProfile</code> function. The only difference is
	 * the change in the variable <code>subDirectory</code>.
	 * 
	 * @param f The <code>InputStream</code> to use as file data.
	 * @param fName The filename to give it.
	 * @param fileType The extension name of the file.
	 * @param size Explicit size of the file being uploaded.
	 * @return The URL linked to the file that was just uploaded.
	 */
	public String uploadImage(InputStream f, String fName, String fileType, long size) {
		subDirectory = "post_images/";
		//Giving the file a weird name, so as to give a unique name.
		return uploadProfile(f, fName + size, fileType, size);
	}
}
