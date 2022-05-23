# AWS Service 실습

1. SQS(Simple-Queue-Service)
   - Send Message
   - Receive Message

참고
- https://aws.amazon.com/ko/blogs/korea/getting-started-with-spring-boot-on-aws/
- https://uchupura.tistory.com/109

과제 (에러 해결, 등)
- (완료) com.amazonaws.SdkClientException: Failed to connect to service endpoint
  - ec2 를 Load 하는 과정에서 발생하는 이슈이다. (참고 : https://lemontia.tistory.com/1006)
  - VM 옵션에 -Dcom.amazonaws.sdk.disableEc2Metadata=true 추가하면 된다. 