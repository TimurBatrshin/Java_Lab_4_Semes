<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="../css/main_style.css">
</head>
<body>

<div class="wrapper">
    <div class="content">
        <div class="header">
            <div class="container">
                <div class="header__row">
                    <div class="header__logo">
                        <img src="https://fiba3x3.com/img/3x3-logo-cut.svg">
                    </div>
                    <ul class="header__menu">
                        <li class="header__menu-elements"><a href="/main">HOME</a></li>
                        <li class="header__menu-elements"><a href="/contest">3X3</a></li>
                        <li class="header__menu-elements"><a href="/ranking">RANKINGS</a></li>
                        <li class="header__menu-elements"><a href="/myTeam">MyTEAM</a></li>
                        <li class="header__menu-elements  header__menu-elements_active"><a href="/profile">Profile</a>
                        </li>
                        <#if authentication??>
                            <li class="header__menu-elements "><a href="/logout">Exit</a></li>
                        <#else>
                            <li class="header__menu-elements"><a href="/sign_in">LOGIN</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
        <h1 class="news-title">Profile</h1>
        <table class="ranking__rankings rankings-individual" data-table-type="individual" data-table-name="all"
               data-table-active="true">
            <thead>
            <tr>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Name</th>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Surname</th>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Email</th>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Nationality</th>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Rang</th>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Points</th>

            </tr>
            </thead>
            <tbody>
            <#if authentication??>
                <#if user??>
                    <tr>
                        <td class="rankings-individual__rank">${user.get().first_name}</td>
                        <td class="rankings-individual__image">${user.get().last_name}</td>
                        <td class="rankings-individual__player">${user.get().email}</td>
                        <td class="rankings-individual__nationality"></td>
                        <td class="rankings-individual__points"></td>
                        <td class="rankings-individual__points">${user.get().point}</td>

                    </tr>
                </#if>
            </#if>
            </tbody>
        </table>
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
