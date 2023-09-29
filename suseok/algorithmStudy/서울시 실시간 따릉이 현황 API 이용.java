<!-- 
문제1. 서울시 실시간 따릉이 현황 API 이용 

서울시 모든 위치의 따릉이 현황을 보여주는 웹 페이지를 구현해보자. 
단, 업데이트 버튼을 누를 때마다 모든 정보가 새로 표기되어야 하며, 
현재 거치된 따릉이 수(parkingBikeTotCnt)가 5개 이하인 경우 글자색을 빨간색으로 나타내어야 한다.
-->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JQuery_Ajax_연습</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <style type="text/css">
        div.box1 {
            margin: 10px 0 20px 0;
        }

        table {
            border: 1px solid;
            border-collapse: collapse;
        }

        td,
        th {
            padding: 10px;
            border: 1px solid;
        }

        .tr_color {
            color: red;
        }
    </style>
</head>
<body>
    <h1>서울시 따릉이 실시간 현황</h1>
    <hr />
    <div class="box1">
        <h2>서울시 따릉이 OpenAPI 사용하기</h2>
        <p>모든 위치의 따릉이 현황을 보여주세요</p>
        <p>업데이트 버튼을 누를 때마다 지웠다 새로 씌여져야 합니다.</p>
        <p>끼아아아아악</p>
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

    <script>
        function reload() {
            const api = "http://spartacodingclub.shop/sparta_api/seoulbike";

            $.ajax({
                type: "GET",
                url: api,
                data: {},
                success: function(response) {
                    $("#names-q1").empty();
                    let bike_list = response["getStationList"]["row"];
                    for (let i = 0; i < bike_list.length; i++) {
                        let name_stat = bike_list[i]["stationName"];
                        let rack_cnt = bike_list[i]["rackTotCnt"];
                        let park_bike = bike_list[i]["parkingBikeTotCnt"];

                        let tr_bike = "";
                        if (park_bike <= 5) {
                            tr_bike = `<tr class="tr_color">
                                            <td>${name_stat}</td>
                                            <td>${rack_cnt}</td>
                                            <td>${park_bike}</td>
                                        </tr>`;
                        } else {
                            tr_bike = `<tr>
                                            <td>${name_stat}</td>
                                            <td>${rack_cnt}</td>
                                            <td>${park_bike}</td>
                                        </tr>`;
                        }

                        $("#names-q1").append(tr_bike);
                    }
                }
            });
        }
    </script>
</body>
</html>
