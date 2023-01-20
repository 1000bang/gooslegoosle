
# 구슬구슬 - gooslegoosle 🍚

## B조
프로젝트 기간 : 2022. 12.26 ~ 2023. 01.14

팀원 : 천병재(팀장), 강성빈

<br><br>
## 프로젝트 목적 :

갓지은 따뜻한 식사를 할 수 있도록 사용자에게 전국의 맛집을 소개하고 

사용자는 맛집을 예약하고 리뷰를 공유하는 웹 반응형 홈페이지 제작
<br><br>


## 구슬구슬이란 ?

![Untitled](https://user-images.githubusercontent.com/113667600/209509785-9dc5a84a-8544-414e-b7de-604497148e5d.png)

### 잘지은 한끼를 먹을 수 있게 맛집정보를 공유하고 예약하는 사이트

<br><br>

## 트렐로 : 

이미지를 클릭하면 해당 페이지로 이동합니다!

[![trello](https://user-images.githubusercontent.com/113667600/213486591-200c0368-01bf-47ab-a7eb-23f43f76db25.png)](https://trello.com/b/o3e9VVuB/gooslegoosle-timeline)
<br><br>


## 노션 : 

이미지를 클릭하면 해당 페이지로 이동합니다!

[![notion](https://user-images.githubusercontent.com/113667600/213486605-dfb47065-485f-491b-ae81-3e8cbbdbfbed.png)](https://1000bang.notion.site/Project-373eb1c07a074cff9e69d2c44bae356d)
<br><br>


## 기능 :
<details>
<summary>토글 접기/펼치기</summary>
<div markdown="1">

### 유저 : 

- 회원가입
    - Postcode API
- 로그인 (카카오, 네이버, 구글 로그인 api)
- 유저 정보 수정
- 맛집 검색
    - 가게 디테일 페이지
        - 지도 api
        - 가게 정보 사용자에게 보여줌
        - 카카오 메세지 api (카톡 공유)
- 가게 예약
    - 예약하기 카카오 결제 api
    - 나의 예약 내역
    - 점주가 예약 거절 시 결제 취소 api
- 리뷰 작성 및 관리
    - 댓글 기능
- 고객센터
    - 본인이 작성한 글만 볼 수 있음
    - 관리자는 다 볼 수 있음
- 메세지
    - 알림 기능
    - 메세지 보관함
    - 파트너 전환 성공시 웰컴 메세지 자동 전송
    - 경고 조치시 메세지 자동전송

### 파트너 : 

- 파트너신청
- 가게 등록
    - 메뉴등록
    - 같은 아이디로 두번 등록 시 실패 페이지 로드
- 예약관리
    - 승인/ 거절
- 통계
    - 최근 일주일 일별 예약건수
    - 최근 한달 주별 예약건수
    - 최근 6개월 월별 예약건수
- 고객센터를 통해 블랙 컨슈머 신고
- 리뷰 답글 / 관리

### 관리자 :

- 매거진/ 공지사항 작성
    - 새로운 회원 또는 게시물 등록시 24시간 동안 new 표시
- 파트너신청 승인  (점주가 파트너신청 시 검수 후 가게등록이 가능하게 설계)
- 유저와 파트너의 요청 관리 ( Service Center)
    - 메세지
    - 유저 및 파트너 검색
    - 유저 경고 및 이용제한 조치
- 통계
    - 최근 2주별 일별 가입건수
    - 최근 2주 일별 리뷰 등록 수
    - 최근 2주 일별 파트너십 신청 수

</div>
</details>


<br><br>


## 실행화면

<details>
<summary>토글 접기/펼치기</summary>
<div markdown="1">  
    
## 회원가입 - 공통

![회원가입](https://user-images.githubusercontent.com/113667600/213486888-17f63b65-5657-40c7-8971-bbedb3f11103.gif)

## 로그인 - 공통
    
![로그인](https://user-images.githubusercontent.com/113667600/213491397-9940c772-f217-47a1-9e70-5263ac297153.gif)
    
## 정보수정/ 나의리뷰 / 내 예약목록 - 공통 
    
![정보수정](https://user-images.githubusercontent.com/113667600/213491430-a6b7670d-91ae-4162-9cc9-f2024e48e643.gif)
    
## 예약하기 - 공통
![예약](https://user-images.githubusercontent.com/113667600/213491116-3c3cc208-f3ff-42bb-8cc0-058a92fb8c10.gif)
    
## 파트너 신청 - 파트너
![파트너신청](https://user-images.githubusercontent.com/113667600/213477012-5cd971d6-fdf9-4a5a-8499-8653d37ed233.gif)


## 메뉴 수정 및 예약관리 - 파트너 
![메뉴수정](https://user-images.githubusercontent.com/113667600/213476728-c18cfd12-8b7a-467e-8e9a-1be296f71fed.gif)
![메뉴수정2](https://user-images.githubusercontent.com/113667600/213476932-9839e62e-c2ca-4d77-9cea-bbf091374596.gif)    

## 파트너 승인 - 관리자
![admin파트너승인](https://user-images.githubusercontent.com/113667600/213639226-5032d413-b936-4997-85bb-07d88ebad7e6.gif)

## 유저관리 - 관리자
![admin유저관리1](https://user-images.githubusercontent.com/113667600/213639234-e2294029-f685-48bd-9da7-b7478d174b08.gif)
![admin유저관리2](https://user-images.githubusercontent.com/113667600/213639246-fcd97cf4-2118-4590-853c-0eaf6442db24.gif)


## 고객센터, 통계 - 관리자 
![admin고객센터,통계](https://user-images.githubusercontent.com/113667600/213639209-2184cfcf-f426-4637-8b46-7616e0764cfe.gif)



</div>
</details>

    
<br><br>
