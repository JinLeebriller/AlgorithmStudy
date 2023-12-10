# 고양이 사진

### 문제 설명

JQuery와 Ajax를 사용해 예제를 풀어보자.

https://api.thedogapi.com/v1/images/search
https://api.thecatapi.com/v1/images/search

두 링크(개와 고양이) 중 원하는 API를 사용하면 된다.

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>JQuery와 Ajax를 사용해 예제를 풀어보자</h1>

    <hr/>

    <div class="question-box">
      <h2>고양이 사진 API를 이용해보기</h2>
      <p>고양이 사진 띄우기</p>
      <p>업데이트 버튼을 누를 때마다 다른 사진이 띄워져야 합니다.</p>
      <button onclick="q1()">고양이 사진 바꾸기</button>
      <div>
        <img id="img-cat" src="http://image.dongascience.com/Photo/2017/03/14900752352661.jpg"/>
      </div>
    </div>
  </body>
</html>
```
