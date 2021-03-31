<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu page</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">

    <style>
        * {
            padding: 0;
            margin: 0;
        }

        a {
            text-decoration: none;
        }

        body {
            display: grid;
            /*padding-top: 100px;*/
            grid-template-rows: 100vh;
            grid-template-areas: "present_block" "best_burgers" "cheap_burgers";
        }

        header {
            display: grid !important;
            position: fixed;
            height: 100px;
            background: #000;
            width: 100%;
            grid-template-columns: 2fr 1fr 1fr 1fr;
            color: #fff;
            align-items: center;
            justify-items: center;
            z-index: 2;
        }

        header ul {
            list-style: none;
        }

        header ul li {
            display: inline-block;
            position: relative;
            text-align: center;
            line-height: 100px;
            padding: 0 5px;
        }

        header a {
            color: #fff;
            transition: all .5s;
            font-family: "Paytone One", sans-serif;

        }

        header a:hover {
            color: #F2C64D;
        }

        header ul li a {
            display: block;
        }

        #present_block {
            position: relative;
            display: grid;
            justify-items: center;
            align-items: center;
            grid-area: present_block;
            background-size: cover;
            background: url("https://s1.1zoom.ru/big3/620/Fast_food_Hamburger_Vegetables_Fire_Two_520128_5616x3744.jpg") center center;
        }

        #present_block p {
            color: #fff;
            font-size: 10em;
            text-shadow: 5px 5px 10px #000;
            font-family: "Paytone One", sans-serif
        }

        #best_burgers {
            display: grid;
            justify-items: center;
            grid-area: best_burgers;
            background-image: url("https://cdn.wallpapersafari.com/68/24/nfArvM.jpg");
            font-family: "Montserrat", sans-serif;
            padding: 150px 0;
        }

        #best_burgers > h1 {
            font-size: 3em;
            margin-bottom: 90px;
        }

        #best_burgers > h2 {
            margin-bottom: 10px;
            color: #F2C64D;
            font-size: 2em;
            font-family: "Pacifico", cursive;
        }

        #best_burgers ul {
            display: grid;
            list-style: none;
            grid-template-columns: 1fr 1fr;
            gap: 10px;
            row-gap: 30px;
            width: 80%;
        }

        #best_burgers ul li {
            display: grid;
            grid-template-columns: 1fr 2fr;
            height: 170px;
            justify-items: center;
        }

        #best_burgers ul li img {
            border-radius: 50%;
            width: 166px;
            height: 166px;
        }

        .about_best_burger {
            display: grid;
        }

        .about_best_burger p {
            color: dimgray;
            font-size: 16px;
            font-weight: 400;
            font-family: 'Montserrat', sans-serif;
        }

        .price_and_basket {
            display: grid;
            grid-template-columns: 1fr 1fr;
            justify-items: center;
            align-items: center;
            height: 10%;
        }

        .price_and_basket h3 {
            justify-self: left;
            color: #F0542C;
            font-size: 1.5em;
        }

        .price_and_basket button {
            background: none;
            outline: none;
            border: none;
            color: #F0542C;
            font-weight: bold;
            cursor: pointer;
            transition: color .3s;
        }

        .price_and_basket button:hover {
            color: #ac3512;
        }

        .show_more {
            width: 80%;
            font-family: "Montserrat", sans-serif;
            font-size: 16px;
            text-align: center;
            border: 1px solid #F0542C;
            color: #F0542C;
            padding: 22px 44px;
            transition: all 0.5s;
            border-radius: 20px;
            font-weight: bold;
            margin-top: 100px;
        }

        .show_more:hover {
            background: #F0542C;
            color: #fff;
        }

        #cheap_burgers {
            grid-area: cheap_burgers;
        }

        #cheap_burgers ul {
            display: grid;
            grid-template-columns: 1fr 1fr;
        }

        #cheap_burgers ul li {
            height: 435px;
            overflow: hidden;
            position: relative;
            display: grid;
            align-items: end;
            color: #fff;
        }

        #cheap_burgers ul li:hover img {
            transform: scale(1.1);
        }

        #cheap_burgers ul li img {
            position: absolute;
            z-index: -1;
            width: 100%;
            transition: all .3s ease-in-out;
        }

        .about_cheap_burgers {
            margin: 0 0 70px 70px;
            width: 60%;
            display: grid;
        }

        .price {
            color: #F0542C !important;
            font-size: 1.5em !important;
        }

        .about_cheap_burgers h3 {
            font-size: 2em;
            font-family: "Montserrat", sans-serif;
            margin-bottom: 10px;
        }

        .about_cheap_burgers p {
            font-size: 16px;
            font-weight: 400;
            font-family: 'Montserrat', sans-serif;
        }

        .about_cheap_burgers a {
            background: #F2C64D;
            color: #fff;
            padding: 13px 30px;
            justify-self: left;
            margin-top: 20px;
            font-family: "Montserrat", sans-serif;
            font-weight: bold;
            border-radius: 20px;
            transition: all .5s;
            border: 1px solid #F2C64D;
        }

        .about_cheap_burgers a:hover {
            background: transparent;
            border: 1px solid #F2C64D;
            color: #F2C64D;
        }
    </style>

</head>
<body>
<header>
    <ul>
        <li><a href="/main">Home</a></li>
        <li><a href="/menu">Menu</a></li>
    </ul>
    <a href="/main"><img
                src="https://image.freepik.com/free-vector/vintage-burger-hand-drawn-logo-illustration_43582-60.jpg"
                width="180" height="95" alt=""></a>
    <a href="/sign_up">Registration</a>
    <a href="/cart"><img src="https://img2.freepng.ru/20180329/zvw/kisspng-computer-icons-shopping-cart-retail-clip-art-shopping-cart-5abdaab0711a27.4162977915223794404633.jpg" width="20" alt=""></a>
</header>
<div id="present_block">
    <p>Big Burgers</p>
</div>
<!------ Include the above in your HEAD tag ---------->


<form action="/sign_in" method="post" class="form-horizontal">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Email</label>
                            <input placeholder="Email" name="email" type="email">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input placeholder="password" type="password" name="password">
                        </div>
                        <div class="form-group ">
                            <input type="submit" value="Sign In">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>