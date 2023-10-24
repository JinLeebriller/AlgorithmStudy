# 서울시 실시간 따릉이 현황 API 이용

### 문제 설명
서울시 모든 위치의 따릉이 현황을 보여주는 웹 페이지를 구현해보자. 단, 업데이트 버튼을 누를 때마다 모든 정보가 새로 표기되어야 하며, 현재 거치된 따릉이 수(parkingBikeTotCnt)가 5개 이하인 경우 글자색을 빨간색으로 나타내어야 한다.

```
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        const api = "http://spartacodingclub.shop/sparta_api/seoulbike";
        const reload = () => {};
    </script>
    <style>

        table {
            border: 1px solid;
            border-collapse: collapse;
        }

        td,
        th {
            padding: 10px;
            border: 1px solid;
        }
    </style>
</head>
<body>
    <div>
        <button onclick="reload()">업데이트</button>
        <table>
            <thead>
                <tr>
                    <td>거치대 위치</td>
                    <td>거치대 수</td>
                    <td>현재 거치된 따릉이 수</td>
                </tr>
            </thead>
            <tbody id="names-q1">
            </tbody>
        </table>
    </div>
</body>
```
