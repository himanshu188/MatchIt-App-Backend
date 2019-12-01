package com.mathit.MathIt;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
@PropertySource("classpath:application.properties")
public class AmazonClient {
    private AmazonS3 s3client;

    @Value("${aws.access.key.id}") String awsKeyId;
    @Value("${aws.access.key.secret}") String awsKeySecret;
    @Value("${aws.region}") String awsRegion;
    @Value("${aws.s3.audio.bucket}") String awsS3AudioBucket;

    private File convertMultiPartToFile(MultipartFile file) throws IOException{
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    private void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(awsS3AudioBucket, fileName, file)
            .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public String uploadFile(MultipartFile multipartFile){
        String url = "https://mathit-application.s3.amazonaws.com";
        try{
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            url +=  "/" + fileName;
            uploadFileTos3bucket(fileName, file);
            file.delete();

        } catch (Exception e){
            e.printStackTrace();

        }
        return url;
    }
    @PostConstruct
    private void initalize(){
        AWSCredentials credentials = new
                BasicAWSCredentials(awsKeyId, awsKeySecret);
        this.s3client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(awsRegion)
                .build();
    }

}
