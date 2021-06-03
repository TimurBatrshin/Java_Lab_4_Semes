<#--<!doctype html>-->
<#--<html lang="en">-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <meta name="viewport"-->
<#--          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">-->
<#--    <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
<#--    <title>Чат</title>-->
<#--    <script-->
<#--            src="https://code.jquery.com/jquery-3.4.1.js"-->
<#--            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="-->
<#--            crossorigin="anonymous"></script>-->
<#--    <script>-->
<#--        let webSocket;-->


<#--        function connect() {-->
<#--            webSocket = new WebSocket('ws://localhost:8080/chat');-->

<#--            webSocket.onmessage = function receiveMessage(response) {-->
<#--                let json = JSON.parse(response['data']);-->
<#--                $('#messagesList').first().after("<li>" + json['from'] + ' ' + json['text'] + "</li>")-->
<#--            }-->
<#--        }-->

<#--        function sendMessage(text, pageId) {-->
<#--            let message = {-->
<#--                "text": text,-->
<#--                "from": pageId-->
<#--            };-->

<#--            webSocket.send(JSON.stringify(message));-->
<#--        }-->
<#--    </script>-->
<#--</head>-->
<#--<body onload="connect()">-->
<#--<div>-->
<#--    <label for="message">Текст сообщения</label>-->
<#--    <input name="message" id="message" placeholder="Сообщение">-->
<#--    <button onclick="sendMessage($('#message').val(), '${pageId}')">Отправить</button>-->
<#--    <h3>Сообщения</h3>-->
<#--    <ul id="messagesList">-->

<#--    </ul>-->
<#--</div>-->
<#--</body>-->
<#--</html>-->


<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="../css/main_style.css">
    <script
            src="https://code.jquery.com/jquery-3.4.1.js"
            integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
            crossorigin="anonymous"></script>
    <script>
        let webSocket;


        function connect() {
            webSocket = new WebSocket('ws://localhost:8080/chat');

            webSocket.onmessage = function receiveMessage(response) {
                let json = JSON.parse(response['data']);
                $('#messagesList').first().after("<li>" + json['from'] + ' ' + json['text'] + "</li>")
            }
        }

        function sendMessage(text, pageId) {
            let message = {
                "text": text,
                "from": pageId
            };

            webSocket.send(JSON.stringify(message));
        }
    </script>
</head>
<body onload="connect()">
<div class="wrapper">
    <div class="content">
        <div class="header">
            <div class="container">
                <div class="header__row">
                    <div class="header__logo">
                        <img src="https://fiba3x3.com/img/3x3-logo-cut.svg">
                    </div>
                    <ul class="header__menu">
                        <li class="header__menu-elements header__menu-elements_active"><a href="/main">HOME</a></li>
                        <li class="header__menu-elements"><a href="/contest">3X3</a></li>
                        <li class="header__menu-elements"><a href="/ranking">RANKINGS</a></li>
                        <li class="header__menu-elements"><a href="/myTeam">MyTEAM</a></li>
                        <li class="header__menu-elements"><a href="/profile">Profile</a></li>
                        <#if authentication??>
                            <li class="header__menu-elements"><a href="/logout">Exit</a></li>
                        <#else>
                            <li class="header__menu-elements"><a href="/sign_in">LOGIN</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
        <div>
            <label for="message">Текст сообщения</label>
            <input name="message" id="message" placeholder="Сообщение">
            <button onclick="sendMessage($('#message').val(), '${pageId}')">Отправить</button>
            <h3>Сообщения</h3>
            <ul id="messagesList">

            </ul>
        </div>
    </div>
    <footer class="footer">
        <div class="first-footer">
            <div class="container-footer">
                <div class="first-footer__row">
                    <div class="first-footer__logo">
                        <img src="../img/logo-white.jpg" alt="">
                    </div>
                    <ul class="first-footer__menu">
                        <li class="first-footer__menu-elements"><a href=""><img src="../img/facebook.png" alt=""></a>
                        </li>
                        <li class="first-footer__menu-elements"><a href=""><img style="width: 25px; height: 25px;"
                                                                                src="../img/vk.png" alt=""></a></li>
                        <li class="first-footer__menu-elements"><a href=""><img src="../img/instagram.png" alt=""></a>
                        </li>
                        <li class="first-footer__menu-elements"><a href=""><img src="../img/twitter.png" alt=""></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>
</div>

</body>
</html>
