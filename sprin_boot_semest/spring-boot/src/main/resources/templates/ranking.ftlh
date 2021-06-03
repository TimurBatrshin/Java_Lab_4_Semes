<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="../css/main_style.css">
    <link rel="stylesheet" type="text/css" href="../css/ranking.css">
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
                        <li class="header__menu-elements  header__menu-elements_active"><a href="/ranking">RANKINGS</a></li>
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
        <div class="ranking-role">
            <ul class="ranking-role__list">
                <li class="ranking-role__elements"><a href="">Individual</a></li>
                <li class="ranking-role__elements"><a href="">Team</a></li>
            </ul>
        </div>
        <table class="ranking__rankings rankings-individual" data-table-type="individual" data-table-name="all"
               data-table-active="true">
            <thead>
            <tr>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Rank</th>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Photo</th>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Player</th>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Nationality</th>
                <th class="rankings-individual__rank rankings-individual__rank--heading"> Points</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td class="rankings-individual__rank">1</td>
                <td class="rankings-individual__image">
                    <img width="40" height="40" alt="Nauris Miezis" class=" lazyloaded"
                         data-src="https://fiba3x3cdn.azureedge.net/images/Member/0/c/0/f/0c0fdec4-9a8f-4353-98ec-4a97ecd72c5a/profile.80x80.png?ck=637342457000000000"
                         src="https://fiba3x3cdn.azureedge.net/images/Member/0/c/0/f/0c0fdec4-9a8f-4353-98ec-4a97ecd72c5a/profile.80x80.png?ck=637342457000000000">
                </td>
                <td class="rankings-individual__player">Nauris Miezis</td>
                <td class="rankings-individual__nationality"><img width="40" height="30" alt="Latvia"
                                                                  class=" lazyloaded"
                                                                  data-src="/flags/4x3/lv.svg" src="/flags/4x3/lv.svg">
                    <span>Latvia</span></td>
                <td class="rankings-individual__points">871,074</td>
            </tr>
            <#if users??>
                <#list users as user>
                    <tr>
                        <td class="rankings-individual__rank"></td>
                        <td class="rankings-individual__image">
                            <img width="40" height="40" class=" lazyloaded" src="${user.photoUrl}">
                        </td>
                        <td class="rankings-individual__player">${user.first_name}</td>
                        <td class="rankings-individual__nationality">${user.nationality}</td>
                        <td class="rankings-individual__points">${user.point}</td>
                    </tr>
                </#list>
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