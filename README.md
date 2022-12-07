## 다이어그램

![img.png](note/diagram.png)

## EndPoint

| 기능          |                      api                       |                                                Ex                                                |
|-------------|:----------------------------------------------:|:------------------------------------------------------------------------------------------------:|
| 댓글 등록       |    Post <br/>api/v1/hospitals/{id}/reviews     | http://ec2-43-200-70-107.ap-northeast-2.compute.amazonaws.com:8081/api/v1/hospitals/{id}/reviews |
| 도서목록 조회     |              GET<br/>pi/v1/books               |         http://ec2-43-200-70-107.ap-northeast-2.compute.amazonaws.com:8081/api/v1/books          |
| 특정 병원 조회    |         Get <br/>api/v1/hospitals/{id}         |      http://ec2-43-200-70-107.ap-northeast-2.compute.amazonaws.com:8081/api/v1/hospitals/3       |
| 특정 병원 리뷰 조회 | Get <br/>api/v1/hospitals/{hospitalId}/reviews |  http://ec2-43-200-70-107.ap-northeast-2.compute.amazonaws.com:8081/api/v1/hospitals/3/reviews   |
| 리뷰 단건 조회    |          Get <br/>api/v1/reviews/{id}          |       http://ec2-43-200-70-107.ap-northeast-2.compute.amazonaws.com:8081/api/v1/reviews/3        |
| 리뷰 전체 조회    |            Get <br/>api/v1/reviews             |        http://ec2-43-200-70-107.ap-northeast-2.compute.amazonaws.com:8081/api/v1/reviews         |
