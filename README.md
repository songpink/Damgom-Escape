# Damgom-Escape
안드로이드 농담곰 방탈출 게임

# 프로젝트 개요

여자친구의 생일선물로 만들어 준 방탈출 게임입니다. 여자친구가 좋아하는 캐릭터인 농담곰과 핑크빈을 사용했습니다.



# 게임 플레이 영상

[농담곰 방탈출 게임 플레이 영상](https://youtu.be/BA0TccC7hLQ)

## 성장한 부분

- 안드로이드 어플리케이션 개발에 재미를 느껴 게임도 만들 수 있을 것이라 생각해 만들었고, 다양한 안드로이드 스튜디오 기능(BGM, Indent, 애니메이션, 이미지 등)에 익숙해지게 되었습니다.
- 스마트폰 UI를 어떻게 하면 더 깔끔하게 꾸밀 수 있는지에 대해 고민하게 되었습니다.
- 하나의 Activity 내에 많은 View가 있을 시 이를 어떻게 관리해야 하는지에 대해 고민하게 되었습니다.

- **자세한 게임 설명**
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a0ebfd49-c991-4e27-b317-84a47cac33a6/bfd113e0-7940-4f10-8e95-d430e8429d47/Untitled.png)
    
    **[게임 컨셉]**
    장난기 많은 성격인 핑크빈이 농담곰을 속여 자신의 집으로 오도록 만들었습니다. 농담곰이 핑크빈의 집에 갇혀 핑크빈의 집을 탈출해야 하는 스토리입니다.
    
    **[게임 진행]**
    
    1. 거실에서 시작합니다. 거실에서는 침실, 오락실, 영화관, 녹음실로 이동할 수 있으며 이 방들에서 정보를 얻어야 합니다.
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a0ebfd49-c991-4e27-b317-84a47cac33a6/08cb5cef-61fb-46b9-b4f8-b1d9eb870951/Untitled.png)
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a0ebfd49-c991-4e27-b317-84a47cac33a6/568d2683-059c-48f5-b99a-fff914ac4b6f/Untitled.png)
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a0ebfd49-c991-4e27-b317-84a47cac33a6/ebbbee43-6abf-4479-a91b-887199f5fb8d/Untitled.png)
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a0ebfd49-c991-4e27-b317-84a47cac33a6/20fd8157-c485-4735-a7a4-a2495b475b5b/Untitled.png)
    
    1. 방에 입장한 횟수가 일정 횟수가 되면 npc가 등장하며 문제를 냅니다. 문제를 맞히면 다음으로 진행할 수 있습니다.
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a0ebfd49-c991-4e27-b317-84a47cac33a6/822fc3d2-5312-4cbe-8c42-e3469a166608/Untitled.png)
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a0ebfd49-c991-4e27-b317-84a47cac33a6/6330bd67-7d50-402a-aa0c-8c279a9023e0/Untitled.png)
    
    1. 핑크빈의 방에 입장하면 핑크빈과 2개의 게임을 합니다. 게임에서 이기면 탈출하게 됩니다.
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a0ebfd49-c991-4e27-b317-84a47cac33a6/9c55f347-908c-4e73-8f4a-a9eb45b5e30a/Untitled.png)
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/a0ebfd49-c991-4e27-b317-84a47cac33a6/42eaed79-f504-4c0f-8354-d8d9040c7a4d/Untitled.png)
    
    **[게임 구조]**
    
    | Activity | 동작 | Intent |
    | --- | --- | --- |
    | start_page | 게임 설명, 스토리 설명 | livingroom으로 화면전환 |
    | livingroom | 고양이 등장, 퀴즈
    미니빈 등장, 퀴즈 – 맞힐 시 pinkbeanroom 액티비티 start | bedroom으로 화면전환
    movieroom으로 화면전환
    arcade로 화면전환
    recordingroom으로 화면전환
    pinkbeanroom으로 화면전환 |
    | bedroom | 문제1 등장
    arcade에서 이벤트 발생 시 문제2 등장 | livingroom으로 화면전환 |
    | movieroom | 단서1, 2, 3 등장 | livingroom으로 화면전환 |
    | arcade | 금고1 등장
    금고 비밀번호 정답 시 bedroom에서 문제2 등장 | livingroom으로 화면전환 |
    | recordingroom | 단서 등장 | livingroom으로 화면전환 |
    | pinkbeanroom | 게임 1, 2 실행 | exit으로 화면전환 |
    | exit | 편지 | - |
