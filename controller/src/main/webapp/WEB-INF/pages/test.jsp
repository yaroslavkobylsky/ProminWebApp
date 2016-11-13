<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${message}</title>
    <script
            src="https://code.jquery.com/jquery-3.1.1.js"
            integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
            crossorigin="anonymous">
    </script>
</head>
<body>
    <div>
        <button id="test_ajax">test AJAX request</button>
        <h5 id="ajax_answer"></h5>
    </div>

    </br>

    <div>
        <h5 class="test_jquery"></h5>
    </div>


    <script>
        window.onload = function () {
            console.log("onload page");
            document.getElementById("test_ajax").onclick = function(){
                var xmlHttpRequest = new XMLHttpRequest();
                console.log("onclick");
                xmlHttpRequest.open("GET", "testAJAX", true);
                console.log("after open");
                xmlHttpRequest.send();
                console.log("after send");
                xmlHttpRequest.onreadystatechange = function () {
                    console.log("onreadystatechange");
                    if (xmlHttpRequest.readyState = 4 && xmlHttpRequest.status == 200) {
                        document.getElementById("ajax_answer").innerHTML = xmlHttpRequest.responseText;
                        console.log("onloadready");
                    }
                }
                xmlHttpRequest.onerror = function () {
                    document.getElementById("ajax_answer").innerHTML = "Произошла ошибка при получении ответа!";
                }
            }
        }
    </script>
    <script>
        $(function() {
            console.log( "jquery ready!" );
            $(".test_jquery").text("hello!");
            /*test adding child*/
            $(".test_jquery").append(" appended text");
        });
    </script>
</body>
</html>
