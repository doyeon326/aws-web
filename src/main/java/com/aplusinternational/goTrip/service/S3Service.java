package com.aplusinternational.goTrip.service;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.NoArgsConstructor;


@Service
@NoArgsConstructor
public class S3Service {
    private AmazonS3 s3Client;
    

    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    @Value("#{systemProperties['cloud.aws.s3.bucket']}")
    private String bucket;

    @Value("${cloud.aws.region.static}")
    private String region;

    @PostConstruct
    public void setS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(this.region)
                .build();
    }

	public String upload(MultipartFile multipartFile, String dirName) throws IOException {
		String fileName = dirName + "/" + multipartFile.getOriginalFilename();
		String uploadImageUrl = putS3(multipartFile, fileName);
		//removeNewFile(multipartFile);
		return uploadImageUrl;
	}

	private String putS3(MultipartFile multipartFile, String fileName) throws IOException {
		System.out.println("file is in!: "+ fileName+" putS3");
		System.out.println(this.bucket);
		s3Client.putObject(new PutObjectRequest(bucket, fileName, multipartFile.getInputStream(), null).withCannedAcl(CannedAccessControlList.PublicRead));
		return s3Client.getUrl(bucket, fileName).toString();
	}


}
