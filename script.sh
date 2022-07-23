# AWS ECR 권한 획득
# Ex. aws --profile {profile name} ecr get-login-password --region {region} | docker login --username AWS --password-stdin 660548980558.dkr.ecr.ap-northeast-2.amazonaws.com
aws --profile big ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 660548980558.dkr.ecr.ap-northeast-2.amazonaws.com

# docker image 를 미리 생성 해둔 것을 ECR 에 올리기 위해 image 추가로 생성 (docker push 하기 위해 앞에 prefix 를 맞춰야함)
# Ex. docker tag spring-hello:latest {ECR 주소}/spring-hello:latest
docker tag spring-hello:latest 660548980558.dkr.ecr.ap-northeast-2.amazonaws.com/spring-hello:latest

# docker image 를 ECR 에 push
docker push 660548980558.dkr.ecr.ap-northeast-2.amazonaws.com/spring-hello:latest