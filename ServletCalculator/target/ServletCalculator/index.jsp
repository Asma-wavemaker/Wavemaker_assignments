<html>
<head>
<title>Calculator App</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="heading">
        <h2>Calculator</h2>
    </div>
    <div class="cal">
    <form action="ServletCalculator" method="get" >
        <div class="inputvalue">
            <h4>Enter First Number:</h4><input type="text" name="txtN1" class="inpfield"><br>
            <h4>Enter Second Number:</h4><input type="text" name="txtN2" class="inpfield" ><br>
        </div>
        <div class="choicestmt">
        <h4>Select any of following Operations</h4>
        </div>
        <div class="choices">
            <div><input type="radio" name="opr" value="+"> Addition</div>
            <div><input type="radio" name="opr" value="-"> Substraction</div>
            <div><input type="radio" name="opr" value="*"> Multiply</div>
            <div><input type="radio" name="opr" value="/"> Divide</div>
            <div><input type="radio" name="opr" value="%"> Modulus</div>
        </div>
        <div class="btns">
            <div><input type="reset" class="bt"></div>
            <div><input type="submit" value="Calculate" class="bt"></div>

        </div>
        </form>
    </div>
</body>
</html>
