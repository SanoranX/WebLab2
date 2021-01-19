<%@page contentType="text/html" pageEncoding="UTF-8" language="java" session="true" %>
<!doctype html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="images/icon.png" type="image/png">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style/style.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/scripts.js"></script>
</head>
<body onload="drawGraph('canvas',1)">

<div class="header">
    <h2 align="center" id="name">Рафаилов Илья</h2>
    <h2 align="center">Лабораторная работа по Web [2]</h2>
    <h2 align="center">Вариант: 10712</h2>
</div>

<div class="card-body">
    <canvas id="canvas" onclick="clickGraph('canvas', document.getElementById('form').R.value)" width="300" height="300"></canvas>
    <div class="dynamic-area1"></div>
    <div class="dynamic-area2"></div>
</div>

<div class="card-input">
    <form class="form card-body" id="form" action="checking" method="post" onsubmit="return validate(this);">
        <label>X:</label>
        <input type="checkbox" name="X" value="-4" id="1c" onclick="checkboxChecked(this.id)"> <label> -4 |</label>
        <input type="checkbox" name="X" value="-3" id="2c" onclick="checkboxChecked(this.id)"> <label> -3 |</label>
        <input type="checkbox" name="X" value="-2" id="3c" onclick="checkboxChecked(this.id)"> <label> -2 |</label>
        <input type="checkbox" name="X" value="-1" id="4c" onclick="checkboxChecked(this.id)"> <label> -1 |</label>
        <input type="checkbox" name="X" value="0" id="5c" onclick="checkboxChecked(this.id)"> <label> 0 |</label>
        <input type="checkbox" name="X" value="1" id="6c" onclick="checkboxChecked(this.id)"> <label> 1 |</label>
        <input type="checkbox" name="X" value="2" id="7c" onclick="checkboxChecked(this.id)"> <label> 2 |</label>
        <input type="checkbox" name="X" value="3" id="8c" onclick="checkboxChecked(this.id)"> <label> 3 |</label>
        <input type="checkbox" name="X" value="4" id="9c" onclick="checkboxChecked(this.id)"> <label> 4 |</label>
        <br>
        <label>Y:</label>
        <input type="text" name="Y" maxlength="7" placeholder="[-5; 5]">
        <br>
        <label>R:</label>
        <input type="radio" name="R" value="1" id="1" onclick="drawGraph('canvas', 1)" required> 1 |</input>
        <input type="radio" name="R" value="1.5" id="1.5" onclick="drawGraph('canvas', 1.5)" required> 1.5 |</input>
        <input type="radio" name="R" value="2" id="2" onclick="drawGraph('canvas', 2)" required> 2 |</input>
        <input type="radio" name="R" value="2.5" id="2.5" onclick="drawGraph('canvas', 2.5)" required> 2.5 |</input>
        <input type="radio" name="R" value="3" id="3" onclick="drawGraph('canvas', 3)" required> 3 |</input>
        <br>
        <input type="submit" name="submit" value="Отправить">
        <br>
        <a href="checking" class="btn">Показать историю</a>
    </form>
</div>
</body>
</html>
