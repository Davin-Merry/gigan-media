package com.revature.service;

import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * This service is responsible for performing business logic for exchanges between
 * Amazon's S3 service. 
 * 
 * @author Davin Merry
 */

@Service
public class ImageService {
	private String accessKey = "AKIA3YVHFNGDBJ55TJU7";
	private String secretAccessKey = "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";
	private String region = "us-east-2";
	private String bucketName = "gigan-media-bucket";
	private String subDirectory = "profile_images/";
	
	public String uploadProfile(InputStream f) {
		BasicAWSCredentials awsCred = new BasicAWSCredentials(accessKey, secretAccessKey);
		AmazonS3 s3 = AmazonS3ClientBuilder.standard()
				.withRegion(region).withCredentials(new AWSStaticCredentialsProvider(awsCred)).build();
		
		
		
		String constructedURL = "https://" + bucketName + ".s3.us-east-2.amazonaws.com/" + subDirectory;
		return null;
	}
}
