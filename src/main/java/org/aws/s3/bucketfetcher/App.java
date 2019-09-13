package org.aws.s3.bucketfetcher;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.auth.credentials.ContainerCredentialsProvider;

public class App 
{
    public static void main( String[] args )
    {
        S3Client s3 = S3Client.builder()
            .credentialsProvider(ContainerCredentialsProvider.builder().build())
            .build();
        // List buckets
        ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
        ListBucketsResponse listBucketsResponse = s3.listBuckets(listBucketsRequest);
        listBucketsResponse.buckets().stream().forEach(x -> System.out.println(x.name()));
    }
}
