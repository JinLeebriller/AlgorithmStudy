//api추가


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>문서</title>
    
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    
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

    <script>
      function q1() {
        $.ajax({
          type: "GET",
          url: "https://api.thecatapi.com/v1/images/search",
          data: {},
          success: function(response){
            console.log(response)
            let cat_img = response[0]["url"]
            $("#img-cat").attr("src", cat_img)
          },
          error: function(error){
            console.log("고양이 이미지를 가져오는 중 오류 발생:", error);
          }
        })
      }
    </script>
</body>
</html>
