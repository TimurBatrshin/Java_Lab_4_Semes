<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring/>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="../css/main_style.css">
    <style>
        .error {
            color: red;
        }
    </style>
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
                        <li class="header__menu-elements"><a href="/profile">Profile</a></li>
                        <#if authentication??>
                            <li class="header__menu-elements header__menu-elements_active"><a href="/logout">Exit</a>
                            </li>
                        <#else>
                            <li class="header__menu-elements header__menu-elements_active"><a href="/sign_in">LOGIN</a>
                            </li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
        <h1 class="news-title">Sign Up 3x3</h1>
        <@spring.bind "signUpForm"/>
        <div>
            <form action="/sign_up" method="post">
                <div class="main">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <#--            <input name="first_name" type="text" placeholder="Name">-->

                    <div class="field">
                        <label>Name</label>
                        <@spring.formInput "signUpForm.first_name" "placeholder='Name'"/>
                        <@spring.showErrors "<br>"/>
                        <#if namesErrorMessage??>
                            <h1>Lexa Lox</h1>
                        </#if>
                    </div>

                    <div class="field">
                        <label>SurName</label>
                        <#--                <input name="last_name" type="text" placeholder="Surname">-->
                        <@spring.formInput "signUpForm.last_name" "placeholder='SurName'"/>
                        <@spring.showErrors "<br>" "error"/>
                        <#if namesErrorMessage??>
                            <h1>Lexa Lox</h1>
                        </#if>
                    </div>

                    <div class="field">
                        <label>Email</label>
                        <#--                <input name="email" type="email" placeholder="email">-->
                        <@spring.formInput "signUpForm.email" "placeholder='Email'"/>
                        <@spring.showErrors "<br>" "error"/>
                    </div>

                    <div class="field">
                        <label>Country</label>
                        <select class="form-control form-control-sm" name="nationality">
                            <option>Russia</option>
                            <option>USA</option>
                        </select>
                    </div>
                    <div class="field">
                        <label>City</label>
                        <input name="city" type="text" placeholder="city">
                    </div>

                    <div class="field">
                        <label>Password</label>
                        <#--                <input name="password" type="password" placeholder="password">-->
                        <@spring.formPasswordInput "signUpForm.password" "placeholder='password'"/>
                        <@spring.showErrors "<br>" "error"/>
                    </div>

                    <div class="field">
                        <label></label>
                        <input type="submit" value="Sign up">
                    </div>
                </div>
            </form>
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
                        <li class="first-footer__menu-elements"><a href=""><img src="../img/facebook.png"
                                                                                alt=""></a>
                        </li>
                        <li class="first-footer__menu-elements"><a href=""><img style="width: 25px; height: 25px;"
                                                                                src="../img/vk.png" alt=""></a></li>
                        <li class="first-footer__menu-elements"><a href=""><img src="../img/instagram.png"
                                                                                alt=""></a>
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
